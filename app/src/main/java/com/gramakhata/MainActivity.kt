package com.gramakhata

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MoonlitMarketApp()
            }
        }
    }
}

/* ---------------- BILL MODE ---------------- */
enum class BillMode {
    CREDIT_BILL,
    NORMAL_BILL
}

@Composable
fun MoonlitMarketApp() {

    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    var showCustomers by remember { mutableStateOf(false) }
    var showAbout by remember { mutableStateOf(false) }

    var selectedCustomer by remember { mutableStateOf<Customer?>(null) }

    var selectedItem by remember { mutableStateOf(itemsList.first()) }
    var quantity by remember { mutableStateOf("1") }

    val cart = remember { mutableStateListOf<Pair<Item, Int>>() }

    var billMode by remember { mutableStateOf(BillMode.CREDIT_BILL) }

    /* ---------------- MONTHLY TOTAL (ONLY PAID) ---------------- */
    val monthlyTotal by remember {
        derivedStateOf {
            DataStore.transactions
                .filter { isThisMonth(it.timestamp) }
                .filter { it.type == "TAKE" }
                .sumOf { it.amount }
        }
    }

    /* ✅🔥 NEW: TOTAL DUE (ALL CUSTOMERS) */
    val totalDueAllCustomers by remember {
        derivedStateOf {
            DataStore.customers.sumOf { calculateBalance(it.id) }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA))
            .padding(12.dp)
    ) {

        /* ---------------- HEADER ---------------- */
        item {
            Card {
                Column(Modifier.padding(16.dp)) {

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {
                            Text(
                                "📒 Gramakhata",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.headlineSmall
                            )
                            Text("Smart Billing System", color = Color.Gray)
                        }

                        /* 🔥 UPDATED TOP RIGHT */
                        Column {
                            Text("Total Due", color = Color.Gray)

                            Text(
                                "₹${totalDueAllCustomers.roundToInt()}",
                                fontWeight = FontWeight.Bold,
                                color = Color.Red
                            )

                            Text(
                                "This Month ₹${monthlyTotal.roundToInt()}",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(0xFF1B5E20)
                            )
                        }
                    }

                    Spacer(Modifier.height(10.dp))

                    Button(onClick = { showCustomers = !showCustomers }) {
                        Text("Customers")
                    }

                    Button(onClick = { showAbout = !showAbout }) {
                        Text("About")
                    }
                }
            }

            Spacer(Modifier.height(12.dp))
        }

        /* ---------------- ABOUT ---------------- */
        if (showAbout) {
            item {
                Card {
                    Column(Modifier.padding(12.dp)) {
                        Text("About", fontWeight = FontWeight.Bold)
                        Text(getAboutApp())
                    }
                }
                Spacer(Modifier.height(12.dp))
            }
        }

        /* ---------------- CUSTOMERS ---------------- */
        if (showCustomers) {
            item {
                Card {
                    Column(Modifier.padding(12.dp)) {

                        Text("Customers", fontWeight = FontWeight.Bold)

                        DataStore.customers.forEach { customer ->
                            val balance = calculateBalance(customer.id)

                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text(customer.name, fontWeight = FontWeight.Bold)
                                    Text("₹$balance")
                                }

                                Button(onClick = { selectedCustomer = customer }) {
                                    Text("Select")
                                }
                            }
                        }
                    }
                }

                Spacer(Modifier.height(12.dp))
            }
        }

        /* ---------------- ADD CUSTOMER ---------------- */
        item {
            Card {
                Column(Modifier.padding(12.dp)) {

                    Text("Add Customer", fontWeight = FontWeight.Bold)

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") }
                    )

                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = { Text("Phone") }
                    )

                    Button(onClick = {
                        if (name.isNotBlank() && phone.isNotBlank()) {
                            DataStore.customers.add(
                                Customer(DataStore.customers.size + 1, name, phone)
                            )
                            name = ""
                            phone = ""
                        }
                    }) {
                        Text("Add")
                    }
                }
            }
        }

        /* ---------------- BILLING ---------------- */
        item {
            selectedCustomer?.let { customer ->

                Card {
                    Column(Modifier.padding(12.dp)) {

                        Text("Billing: ${customer.name}", fontWeight = FontWeight.Bold)

                        Row {
                            Button(onClick = { billMode = BillMode.CREDIT_BILL }) {
                                Text("Credit")
                            }
                            Spacer(Modifier.width(8.dp))
                            Button(onClick = { billMode = BillMode.NORMAL_BILL }) {
                                Text("Normal")
                            }
                        }

                        var expanded by remember { mutableStateOf(false) }

                        Button(onClick = { expanded = true }) {
                            Text(selectedItem.name)
                        }

                        DropdownMenu(expanded, { expanded = false }) {
                            itemsList.forEach {
                                DropdownMenuItem(
                                    text = { Text("${it.name} ₹${it.price}") },
                                    onClick = {
                                        selectedItem = it
                                        expanded = false
                                    }
                                )
                            }
                        }

                        OutlinedTextField(
                            value = quantity,
                            onValueChange = { quantity = it },
                            label = { Text("Qty") }
                        )

                        Button(onClick = {
                            val qty = quantity.toIntOrNull() ?: 1
                            cart.add(selectedItem to qty)
                        }) {
                            Text("Add Item")
                        }

                        cart.forEach {
                            Text("${it.first.name} x ${it.second}")
                        }

                        val subtotal = cart.sumOf { it.first.price * it.second }

                        val discountRate = 5.0 / 100.0   // FIXED PERCENT LOGIC
                        val discount = subtotal * discountRate

                        val total = subtotal - discount

                        Text("Total ₹${total.roundToInt()}")

                        /* ---------------- SEND BILL ---------------- */
                        Button(onClick = {

                            addTransaction(customer.id, total, "GIVE")

                            if (billMode == BillMode.NORMAL_BILL) {
                                addTransaction(customer.id, total, "TAKE")
                            }

                            val message = """
🧾 *GRAMAKHATA BILL RECEIPT*

🏪 Customer: ${customer.name}
📱 Phone: ${customer.phone}

━━━━━━━━━━━━━━━
🛍 ITEMS:
${cart.joinToString("\n") {
                                "${it.first.name} x ${it.second} = ₹${(it.first.price * it.second).roundToInt()}"
                            }}
━━━━━━━━━━━━━━━

💰 Subtotal: ₹${subtotal.roundToInt()}
🎁 Discount (5%): -₹${discount.roundToInt()}
━━━━━━━━━━━━━━━
🧾 *TOTAL: ₹${total.roundToInt()}*
━━━━━━━━━━━━━━━

📌 Status: ${if (billMode == BillMode.CREDIT_BILL) "CREDIT (Pending)" else "PAID"}
📅 ${java.text.SimpleDateFormat("dd MMM yyyy, hh:mm a").format(java.util.Date())}

🙏 Thank you for shopping!
💚 GRAMAKHATA
""".trimIndent()

                            sendWhatsApp(context, customer.phone, message)
                            cart.clear()

                        }) {
                            Text("Send Bill")
                        }

                        /* ---------------- MARK PAID ---------------- */
                        Button(onClick = {

                            val due = calculateBalance(customer.id)

                            addTransaction(customer.id, due, "TAKE")

                            val message = """
💚 *PAYMENT RECEIVED*

🏪 Customer: ${customer.name}

💰 Amount Paid: ₹${due.roundToInt()}

━━━━━━━━━━━━━━━
✔ Payment Status: CLEARED
📅 ${java.text.SimpleDateFormat("dd MMM yyyy, hh:mm a").format(java.util.Date())}

🙏 Thank you for shopping with us!
💚 Visit again soon

— GRAMAKHATA
""".trimIndent()

                            sendWhatsApp(context, customer.phone, message)

                        }) {
                            Text("Mark Paid")
                        }
                    }
                }
            }
        }
    }
}

/* ---------------- MONTH CHECK ---------------- */
fun isThisMonth(time: Long): Boolean {
    val now = Calendar.getInstance()
    val t = Calendar.getInstance()
    t.timeInMillis = time

    return now.get(Calendar.MONTH) == t.get(Calendar.MONTH) &&
            now.get(Calendar.YEAR) == t.get(Calendar.YEAR)
}

/* ---------------- ABOUT ---------------- */
fun getAboutApp(): String {
    return """
📒 GRAMAKHATA

Smart Digital Billing System 🏪

✔ Digital khata tracking
✔ Credit management
✔ Monthly analytics
✔ WhatsApp billing
✔ Fast shop billing

👨‍💻 Skanda Krishna S R
"""
}

/* ---------------- WHATSAPP ---------------- */
fun sendWhatsApp(context: android.content.Context, phone: String, message: String) {
    val url = "https://wa.me/$phone?text=${Uri.encode(message)}"
    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}
package com.gramakhata

import androidx.compose.runtime.mutableStateListOf

/* ---------------- DATA MODELS ---------------- */

data class Customer(
    val id: Int,
    val name: String,
    val phone: String
)

data class Transaction(
    val customerId: Int,
    val amount: Double,
    val type: String,
    val timestamp: Long = System.currentTimeMillis()
)

data class Item(val name: String, val price: Double)

/* ---------------- STORE ---------------- */

object DataStore {
    val customers = mutableStateListOf<Customer>()
    val transactions = mutableStateListOf<Transaction>()
}

/* ---------------- FUNCTIONS ---------------- */

fun addTransaction(customerId: Int, amount: Double, type: String) {
    DataStore.transactions.add(
        Transaction(customerId, amount, type)
    )
}

fun calculateBalance(customerId: Int): Double {
    val list = DataStore.transactions.filter { it.customerId == customerId }

    val give = list.filter { it.type == "GIVE" }.sumOf { it.amount }
    val take = list.filter { it.type == "TAKE" }.sumOf { it.amount }

    return give - take
}

/* ---------------- ITEMS ---------------- */

val itemsList = listOf(

    // 🥛 DAIRY
    Item("Amul Milk 500ml", 30.0),
    Item("Amul Milk 1L", 60.0),
    Item("Nandini Milk 500ml", 28.0),
    Item("Nandini Milk 1L", 56.0),
    Item("Nandini Curd 500ml", 35.0),
    Item("Amul Butter 100g", 60.0),
    Item("Amul Butter 500g", 275.0),
    Item("Britannia Paneer 200g", 95.0),
    Item("Mother Dairy Lassi 200ml", 25.0),
    Item("Epigamia Greek Yogurt 200g", 60.0),

    // 🍚 RICE & FLOUR
    Item("India Gate Basmati Rice 1kg", 120.0),
    Item("India Gate Basmati Rice 5kg", 580.0),
    Item("Tilda Basmati Rice 1kg", 140.0),
    Item("Sona Masoori Rice 1kg", 65.0),
    Item("Sona Masoori Rice 5kg", 320.0),
    Item("Aashirvaad Atta 1kg", 55.0),
    Item("Aashirvaad Atta 5kg", 260.0),
    Item("Pillsbury Atta 5kg", 270.0),
    Item("Fortune Sooji 1kg", 60.0),
    Item("Ragi Flour 1kg", 70.0),

    // ☕ TEA & COFFEE
    Item("Tata Tea Gold 250g", 140.0),
    Item("Tata Tea Premium 1kg", 520.0),
    Item("Red Label Tea 250g", 135.0),
    Item("Wagh Bakri Tea 1kg", 480.0),
    Item("Bru Instant Coffee 100g", 150.0),
    Item("Nescafe Classic 100g", 170.0),
    Item("Nescafe Gold 100g", 320.0),

    // 🧂 ESSENTIALS
    Item("Tata Salt 1kg", 22.0),
    Item("Aashirvaad Salt 1kg", 20.0),
    Item("Tata Sugar 1kg", 42.0),
    Item("Daawat Toor Dal 1kg", 160.0),
    Item("Tata Sampann Urad Dal 1kg", 140.0),
    Item("Moong Dal 1kg", 130.0),

    // 🍜 INSTANT FOOD
    Item("Maggi Noodles Pack", 15.0),
    Item("Maggi Masala 6 Pack", 85.0),
    Item("Yippee Noodles Pack", 14.0),
    Item("Knorr Soup Mix", 25.0),
    Item("Top Ramen Noodles", 12.0),

    // 🍪 BISCUITS
    Item("Parle-G Small", 10.0),
    Item("Parle-G Big", 25.0),
    Item("Britannia Good Day", 30.0),
    Item("Marie Gold", 25.0),
    Item("Hide & Seek Chocolate", 40.0),
    Item("Oreo Original", 30.0),

    // 🍫 CHOCOLATES
    Item("Dairy Milk Small", 20.0),
    Item("Dairy Milk Silk", 80.0),
    Item("KitKat 4 Finger", 20.0),
    Item("5 Star", 10.0),
    Item("Perk", 10.0),
    Item("Ferrero Rocher 3 Pack", 99.0),

    // 🧴 PERSONAL CARE
    Item("Clinic Plus Shampoo 180ml", 120.0),
    Item("Head & Shoulders 180ml", 150.0),
    Item("Sunsilk Shampoo 180ml", 110.0),
    Item("Colgate Toothpaste 200g", 110.0),
    Item("Closeup Toothpaste 150g", 95.0),
    Item("Dove Soap", 55.0),
    Item("Lux Soap", 35.0),
    Item("Lifebuoy Soap", 30.0),

    // 🧺 DETERGENTS
    Item("Surf Excel 1kg", 220.0),
    Item("Ariel Powder 1kg", 210.0),
    Item("Wheel Powder 1kg", 140.0),
    Item("Rin Soap Bar", 20.0),
    Item("Tide Powder 1kg", 200.0),

    // 🛢 COOKING OIL
    Item("Fortune Sunflower Oil 1L", 160.0),
    Item("Gold Winner Oil 1L", 155.0),
    Item("Freedom Oil 1L", 150.0),
    Item("Saffola Active Oil 1L", 180.0),

    // 🥤 BEVERAGES
    Item("Coca Cola 1L", 50.0),
    Item("Pepsi 1L", 50.0),
    Item("Sprite 1L", 50.0),
    Item("Frooti 200ml", 10.0),
    Item("Maaza 250ml", 20.0),
    Item("Tropicana Juice 1L", 110.0),

    // 🍞 DAILY ITEMS
    Item("Britannia Bread", 40.0),
    Item("Eggs (6)", 45.0),
    Item("Amul Cheese 200g", 120.0),

    // 🧼 CLEANING
    Item("Harpic Toilet Cleaner", 95.0),
    Item("Dettol Liquid 250ml", 180.0),
    Item("Lizol Floor Cleaner", 150.0),
    Item("Vim Dishwash Bar", 20.0),

    // 🔌 HOUSEHOLD
    Item("Matchbox", 5.0),
    Item("Cycle Agarbatti", 30.0),
    Item("Classmate Notebook", 40.0),
    Item("Cello Pen", 10.0),
    Item("Duracell Battery Pack", 120.0)
)
# 🏡 GramaKhata

A smart digital village/property record management app — built with Android (Jetpack Compose) + Kotlin

---

# 📱 About the App

GramaKhata is an Android application designed to simplify village-level property and record management. It helps users maintain digital khata records, manage citizen/property details, and securely store information using local storage — all without needing internet connectivity.

The app is simple, lightweight, and easy to use for rural administration purposes.

---

# 🎯 Problem Statement

Village and property records are often maintained manually using notebooks and paper files. This creates several problems such as:

- ⚠️ Missing records
- ⚠️ Duplicate entries
- ⚠️ Difficult record searching
- ⚠️ Human calculation errors
- ⚠️ Time-consuming management

### ✅ Solution

GramaKhata provides a simple digital record management system that helps users store and organize records efficiently.

---

# ✨ Features

| Feature | Description |
|---|---|
| 📝 Add Records | Add citizen and property details quickly |
| 🔍 Search Records | Instantly search stored records |
| 📊 Record Tracking | View and manage all saved records |
| ✏️ Update Records | Edit existing details anytime |
| 🗑️ Delete Records | Remove incorrect or outdated entries |
| 💾 Offline Storage | Works completely offline |
| 📱 Simple UI | Clean and user-friendly interface |

---

# 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Kotlin | Primary programming language |
| Jetpack Compose | Modern Android UI toolkit |
| Material 3 | UI Components and Design |
| SharedPreferences / DataStore | Local data storage |
| Android Studio | IDE |
| Min SDK | API 24 (Android 7.0) |
| Target SDK | API 35 |

---

# 📂 Project Structure

```plaintext
GramaKhata/
├── app/
│   └── src/main/java/com/gramakhata/
│       ├── MainActivity.kt
│       ├── DataStore.kt
│       ├── AddRecordScreen.kt
│       ├── SearchScreen.kt
│       ├── RecordsScreen.kt
│       ├── UpdateRecordScreen.kt
│       └── DeleteRecordScreen.kt
```

---

# 📸 App Screens

## 🏠 Dashboard
- Simple home screen
- Quick navigation to all features
- Clean village-friendly UI

---

## 📝 Add Record Screen
- Add property and citizen details
- Easy form-based input
- Secure local storage

---

## 🔍 Search Screen
- Quickly search saved records
- Fast and simple retrieval

---

## 📊 Records Screen
- View all saved entries
- Organized record list
- Easy management

---

## ✏️ Update Record Screen
- Modify existing records
- Update details anytime

---

## 🗑️ Delete Record Screen
- Remove duplicate or incorrect entries
- Keeps records organized

---

# 💾 Data Storage

This app uses Android local storage for maintaining records:

- ✅ No internet required
- ✅ No external database needed
- ✅ Data persists across app restarts
- ✅ Secure offline storage
- ✅ Fast and lightweight

---

# 🚀 Getting Started

## Prerequisites

- Android Studio (Latest version)
- Android Emulator or Physical Device (API 24+)
- JDK 11 or above

---

# 📥 Installation

## Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/GramaKhata.git
```

---

## Open in Android Studio

```plaintext
File → Open → Select GramaKhata folder
```

Wait for Gradle sync to complete.

---

## Run the App

Click ▶️ Run button or press:

```plaintext
Shift + F10
```

---

# 📦 Dependencies

```kotlin
// Jetpack Compose
implementation(platform("androidx.compose:compose-bom:2024.09.00"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")

// Navigation
implementation("androidx.navigation:navigation-compose:2.7.7")

// DataStore
implementation("androidx.datastore:datastore-preferences:1.1.1")
```

---

# 🎯 Impact Goals

- 📌 Digital transformation for rural administration
- 📌 Reduced paperwork and manual errors
- 📌 Faster record access and management
- 📌 Improved transparency in records
- 📌 Easy offline accessibility

---

# 👨‍💻 Development

This project was developed as part of an Android App Development Internship using GenAI tools.

- Platform — Android
- Language — Kotlin
- UI Toolkit — Jetpack Compose
- Architecture — Single Activity Architecture
- Storage — SharedPreferences / DataStore

---

# 📄 License

MIT License

Copyright (c) 2026 GramaKhata

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files.

---

# 🙏 Acknowledgements

- Jetpack Compose — Modern Android UI toolkit by Google
- Android Studio — Official Android IDE by Google
- Kotlin — Modern programming language for Android development
- Material Design 3 — UI Components and Design System

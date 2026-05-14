# 🏡 GramaKhata

A smart digital village/property record management app — built with Android (Jetpack Compose) + Kotlin

---

# 📱 About the App

GramaKhata is an Android application designed to simplify village-level property and record management. It helps users maintain digital records, manage citizen/property details, and securely store information using local storage — all without requiring internet connectivity.

The app is lightweight, beginner-friendly, and easy to use.

---

# 🎯 Problem Statement

Village and property records are often maintained manually using paper files and notebooks. This creates several problems such as:

- ⚠️ Missing records
- ⚠️ Duplicate entries
- ⚠️ Difficult record searching
- ⚠️ Human errors
- ⚠️ Time-consuming management

### ✅ Solution

GramaKhata provides a simple digital solution for storing and managing records efficiently.

---

# ✨ Features

| Feature | Description |
|---|---|
| 📝 Add Records | Add citizen and property details |
| 🔍 Search Records | Instantly search saved records |
| 📊 Record Tracking | View and manage all records |
| ✏️ Update Records | Edit record details anytime |
| 🗑️ Delete Records | Remove unwanted entries |
| 💾 Offline Storage | Works without internet |
| 📱 Simple UI | Easy and clean interface |

---

# 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Kotlin | Primary programming language |
| Jetpack Compose | Modern Android UI toolkit |
| Material 3 | UI Components and Design |
| DataStore | Local data storage |
| Android Studio | Development IDE |
| Min SDK | API 24 (Android 7.0) |
| Target SDK | API 35 |

---

# 📂 Project Structure

```plaintext
GramaKhata/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com.gramakhata/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── DataStore.kt
│   │   │   │   └── ui.theme/
│   │   │   ├── res/
│   │   │   └── AndroidManifest.xml
│
├── gradle/
├── build.gradle.kts
└── settings.gradle.kts
```

---

# 📸 App Screens

## 🏠 Dashboard
- Simple and clean home screen
- Easy navigation to app features
- User-friendly interface

---

## 📝 Add Record Screen
- Add village/property details
- Simple form-based input
- Secure data storage

---

## 🔍 Search Screen
- Quickly search saved records
- Fast and easy retrieval

---

## 📊 Records Screen
- View all stored entries
- Organized record management

---

## ✏️ Update Record Screen
- Modify existing records
- Edit details anytime

---

## 🗑️ Delete Record Screen
- Remove incorrect or duplicate entries
- Keep records organized

---

# 💾 Data Storage

This app uses Android DataStore for local storage.

### Benefits

- ✅ No internet required
- ✅ Data saved permanently
- ✅ Fast and lightweight
- ✅ Secure local storage
- ✅ Offline accessibility

---

# 🚀 Getting Started

## Prerequisites

- Android Studio (Latest Version)
- Android Emulator or Physical Device (API 24+)
- JDK 11 or Above

---

# 📥 Installation

## Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/GramaKhata.git
```

---

## Open in Android Studio

```plaintext
File → Open → Select GramaKhata Folder
```

---

## Run the Application

```plaintext
Shift + F10
```

OR click the ▶️ Run button in Android Studio.

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

# 🎯 Project Goals

- 📌 Reduce paperwork
- 📌 Improve record management
- 📌 Simplify village administration
- 📌 Provide offline accessibility
- 📌 Minimize manual errors

---

# 👨‍💻 Development

This project was developed as part of an Android App Development Internship using GenAI tools.

- Platform — Android
- Language — Kotlin
- UI Toolkit — Jetpack Compose
- Storage — DataStore
- IDE — Android Studio

---

# 📄 License

MIT License

Copyright (c) 2026 GramaKhata

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files.

---

# 🙏 Acknowledgements

- Jetpack Compose — Modern Android UI toolkit by Google
- Android Studio — Official Android IDE by Google
- Kotlin — Modern Android programming language
- Material Design 3 — UI Components and Design System

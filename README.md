🏡 GramaKhata

A smart digital ledger & village record management app — built with Android (Jetpack Compose) + Kotlin

📱 About the App

GramaKhata is an Android application designed to simplify village-level property and record management. It helps users maintain digital khata records, manage citizen/property details, track payments, and securely store information using local storage — all without requiring internet connectivity.

The application is designed to support small rural administrative workflows with a clean, easy-to-use interface.

🎯 Problem Statement

In many rural areas, property records and local tax/payment details are still maintained manually in notebooks or paper files. This creates several problems such as:

Missing or damaged records
Duplicate entries
Difficulty searching old data
Human calculation errors
Time-consuming manual management

GramaKhata solves this problem by providing a simple digital record management system that stores and organizes village/property records efficiently.

✨ Features
Feature	Description
📝 Add Records	Add citizen/property details quickly
🔍 Search Records	Instantly search stored records
📊 Record Tracking	View and manage all saved entries
💾 Offline Storage	Works completely offline using local storage
✏️ Update Details	Edit and update records anytime
🗑️ Delete Records	Remove outdated or incorrect entries
📱 Simple UI	Clean and user-friendly Android interface
🛠️ Tech Stack
Technology	Usage
Kotlin	Primary programming language
Jetpack Compose	Modern Android UI toolkit
SharedPreferences / DataStore	Local data storage
Android Studio	IDE
Material 3	UI Design Components
Min SDK	API 24 (Android 7.0)
Target SDK	API 35
📂 Project Structure
GramaKhata/
├── app/
│   └── src/main/java/com/gramakhata/
│       ├── MainActivity.kt        # App entry point
│       ├── DataStore.kt           # Local data handling
│       ├── ui.theme/              # App theme files
│       └── Screens/               # App screens
│
├── res/                           # Resources
├── AndroidManifest.xml
└── build.gradle.kts
📸 App Screens
🏠 Dashboard
Simple home screen for easy navigation
Quick access to all major features
Clean village-friendly UI
📝 Add Record Screen
Add property/citizen information
Store details securely
Easy form-based input
🔍 Search Screen
Search records instantly
Fast filtering and retrieval
📊 Records Screen
View all stored entries
Organized list layout
Easy management options
✏️ Update Record Screen
Modify existing records
Update details anytime
🗑️ Delete Record Feature
Remove unnecessary or duplicate entries
Keeps records clean and organized
💾 Data Storage

This app uses local Android storage for maintaining records:

✅ No internet required
✅ Fast and lightweight
✅ Data persists after app restart
✅ Secure local storage
✅ Easy offline access

🚀 Getting Started
Prerequisites
Android Studio (Latest version)
Android Emulator or Physical Device (API 24+)
JDK 11 or above
📥 Installation
Clone the repository
git clone https://github.com/YOUR_USERNAME/GramaKhata.git
Open in Android Studio
File → Open → Select GramaKhata folder

Wait for Gradle sync to complete.

▶️ Run the App

Click the Run ▶️ button
OR

Shift + F10
📦 Dependencies
// Jetpack Compose
implementation(platform("androidx.compose:compose-bom:2024.09.00"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")

// Navigation
implementation("androidx.navigation:navigation-compose:2.7.7")

// DataStore
implementation("androidx.datastore:datastore-preferences:1.1.1")
🎯 Impact Goals
📌 Digital Transformation for Rural Administration
📌 Reduced paperwork and manual errors
📌 Faster record access and management
📌 Improved transparency in local records
📌 Easy offline accessibility for rural areas
👨‍💻 Development

This project was developed as part of an Android App Development Internship using GenAI tools.

Category	Details
Platform	Android
Language	Kotlin
UI Toolkit	Jetpack Compose
Architecture	Single Activity Architecture
Storage	DataStore / SharedPreferences
📄 License
MIT License
Copyright (c) 2026 GramaKhata

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software.
🙏 Acknowledgements
Jetpack Compose — Modern Android UI toolkit by Google
Android Studio — Official Android IDE by Google
Kotlin — Modern programming language for Android development
Material Design 3 — UI Components and Design System

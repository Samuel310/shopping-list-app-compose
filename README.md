# Shopping List App

A modern Android shopping list application built with **Kotlin** and **Jetpack Compose**, designed to help you easily manage your grocery shopping items.

## Features

- ✅ Add shopping items with name and quantity
- ✏️ Edit existing items
- 🗑️ Delete items from your list
- 📋 View all items in a clean, organized list
- 🎯 Empty state UI with visual feedback

## Technology Stack

### Architecture

- **Clean Architecture** with Clean MVVM pattern
- **Dependency Injection** using Hilt
- **Repository Pattern** for data abstraction

### UI & Presentation

- **Jetpack Compose** for modern, reactive UI
- **Material 3** design components
- **Lottie** animations for enhanced UX
- **Splash Screen** for app launch experience

### Data & Storage

- **Room Database** for local data persistence
- **Kotlin Flow** for reactive data streams
- **Coroutines** for asynchronous operations

### Android Framework

- Kotlin 11 JVM target
- Android SDK 24 (minimum) to 35 (target)
- AndroidX libraries
- Lifecycle and ViewModel management

## Project Structure

```Bash
app/src/main/java/com/apps310/groceryapp/
├── features/
│   └── shopping_list/
│       ├── data/              # Data layer (Database, DAO, Repository Implementation)
│       ├── domain/            # Domain layer (Entities, Repository Interface)
│       └── presentation/      # Presentation layer (UI, ViewModels, State)
├── core/                       # Shared utilities and core functionality
├── MainActivity.kt             # Main activity entry point
├── MyApplication.kt            # Application class
└── App.kt                      # App configuration
```

## Key Components

### Data Layer

- **ProductDao**: Room database access object for product operations
- **ProductRepositoryImpl**: Implementation of data repository pattern

### Domain Layer

- **ProductRepository**: Interface defining repository contracts
- **Product**: Data model representing a shopping list item

### Presentation Layer

- **ProductViewModel**: Manages shopping list state and operations
- **ProductDialogViewModel**: Handles dialog state for add/edit operations
- **ShoppingListScreen**: Main composable screen
- **ProductItem**: Individual item composable
- **ProductDialog**: Dialog for adding/editing items
- **EmptyListPlaceHolder**: Placeholder shown when list is empty

## Getting Started

### Prerequisites

- Android Studio (latest version recommended)
- Android SDK 24 or higher
- Java 11 or higher

### Installation

1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd GroceryApp
   ```

2. Open the project in Android Studio

3. Sync Gradle files (Gradle will automatically download dependencies)

4. Run the app on an emulator or physical device:

   ```bash
   ./gradlew installDebug
   ```

## Building & Running

### Build APK

```bash
./gradlew assembleDebug
```

### Run on device/emulator

```bash
./gradlew runDebug
```

### Run tests

```bash
./gradlew test
```

## App Details

- **Package Name**: `com.zillotrix.shoppinglist`
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 35 (Android 15)
- **Version**: 1.0

## Usage

1. **Add Item**: Tap the "Add" button to open the dialog and enter item name and quantity
2. **Edit Item**: Tap the edit icon on any item to modify its details
3. **Delete Item**: Tap the delete icon to remove an item from the list
4. **View List**: All items are displayed with their quantities in an easy-to-read format

## Build Configuration

The project uses a modular Gradle setup with:

- Kotlin DSL (`.kts`)
- Version catalog for dependency management
- Compose and Kapt plugin support
- Hilt dependency injection setup

## License

This project is provided as a demo application.

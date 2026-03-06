# 🌸 Explore Tokyo — 2-Day Itinerary App

An Android app that provides a guided 2-day Tokyo itinerary for travelers, combining youth culture and shopping (Day 1) with historic and cultural landmarks (Day 2).

## Features

- **Day 1 — West Tokyo:** Shibuya Crossing, Harajuku & Omotesando, Shinjuku Golden Gai
- **Day 2 — East Tokyo:** Senso-ji Temple, Tokyo Skytree, Odaiba Waterfront
- **Interactive Map** with location markers and route polylines (OSMDroid)
- **Activity Details** with descriptions, timing, tips, and coordinates
- Smooth animated transitions between screens
- Bottom navigation for quick access to Home, Day 1, Day 2, and Map

## Screenshots

*Coming soon*

## Tech Stack

| Component       | Technology                        |
|-----------------|-----------------------------------|
| Language        | Kotlin                            |
| UI              | Jetpack Compose + Material 3      |
| Navigation      | Compose Navigation (sealed routes)|
| Maps            | OSMDroid 6.1.18                   |
| Min SDK         | 26 (Android 8.0)                  |
| Target SDK      | 36                                |
| Build System    | Gradle (Kotlin DSL)               |

## Getting Started

### Prerequisites

- Android Studio Ladybug or later
- JDK 17

### Build & Run

```bash
# Clone the repository
git clone <repo-url>
cd explore-tokyo-2days

# Build the debug APK
./gradlew assembleDebug

# Install on a connected device/emulator
./gradlew installDebug
```

## Project Structure

```
app/src/main/java/com/exploretokyo/app/
├── data/           # Data models & itinerary content
├── navigation/     # Screen routes & NavHost setup
├── ui/
│   ├── components/ # Reusable composables (DayCard, TimelineItem, TipsCard)
│   ├── screens/    # Home, Day1, Day2, Map, ActivityDetail, Splash
│   └── theme/      # Material 3 theme & colors
└── MainActivity.kt
```

## License

This project is for personal/educational use.

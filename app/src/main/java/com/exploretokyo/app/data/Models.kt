package com.exploretokyo.app.data

data class Itinerary(
    val title: String,
    val dates: String,
    val constraints: Constraints,
    val generalTips: GeneralTips,
    val days: List<Day>,
    val highlights: List<String>,
    val notes: String
)

data class Constraints(
    val startTime: String,
    val endTime: String,
    val dinner: String
)

data class GeneralTips(
    val transport: String,
    val pace: String,
    val accommodation: String,
    val seasonNotes: String
)

data class Day(
    val dayNumber: Int,
    val date: String,
    val theme: String,
    val areas: List<String>,
    val activities: List<Activity>,
    val vibe: String,
    val walkingLevel: String
)

data class Activity(
    val id: String,
    val time: String,
    val title: String,
    val description: String,
    val area: String,
    val location: Location?,
    val illustrationRes: Int,
    val tips: List<String> = emptyList()
)

data class Location(
    val lat: Double,
    val lng: Double,
    val name: String
)

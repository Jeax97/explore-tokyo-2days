package com.exploretokyo.app.data

import com.exploretokyo.app.R

object ItineraryData {

    private val day1 = Day(
        dayNumber = 1,
        date = "March 6, 2026 (Friday)",
        theme = "West Side – Youth culture, shopping & city energy",
        areas = listOf("Shibuya", "Harajuku", "Shinjuku"),
        activities = listOf(
            Activity(
                id = "d1a1",
                time = "~11:30 AM – 12:30 PM",
                title = "Late Brunch in Shibuya",
                description = "Start the day with a late brunch or early lunch at one of the many casual spots near Shibuya Station. The area has everything from trendy cafés to ramen shops, perfect for easing into the day.",
                area = "Shibuya",
                location = Location(35.6595, 139.7004, "Shibuya Station"),
                illustrationRes = R.drawable.ic_shibuya_crossing,
                tips = listOf(
                    "Look for restaurants on the upper floors of buildings near Hachiko exit",
                    "Many places have picture menus or English menus"
                )
            ),
            Activity(
                id = "d1a2",
                time = "~12:30 PM – 3:00 PM",
                title = "Shibuya Crossing & Exploration",
                description = "Experience the world's most famous pedestrian crossing – Shibuya Scramble. Visit the iconic Hachiko statue by the station. Optionally head up to Shibuya Sky observation deck for stunning 360° views, or wander through the shops and department stores nearby.",
                area = "Shibuya",
                location = Location(35.6595, 139.7004, "Shibuya Crossing"),
                illustrationRes = R.drawable.ic_shibuya_crossing,
                tips = listOf(
                    "Best photos of the crossing from Shibuya Sky or the Starbucks overlooking it",
                    "Hachiko statue is right outside the station's Hachiko exit",
                    "Shibuya Sky tickets: book in advance online to skip lines"
                )
            ),
            Activity(
                id = "d1a3",
                time = "~3:00 PM – 5:30 PM",
                title = "Harajuku & Omotesando",
                description = "Walk to Harajuku (one station or ~15 min walk from Shibuya). Dive into Takeshita Street – a narrow lane packed with quirky fashion shops, crêpe stands, and vibrant youth culture. Then stroll down Omotesando avenue for upscale architecture, flagship stores, and excellent people-watching. Optionally take a quick detour to the entrance of Meiji Jingu's forested path for a tranquil contrast.",
                area = "Harajuku",
                location = Location(35.6702, 139.7026, "Takeshita Street"),
                illustrationRes = R.drawable.ic_harajuku_gate,
                tips = listOf(
                    "Takeshita Street is most lively in the afternoon",
                    "Try a colorful crêpe or cotton candy from the street vendors",
                    "Omotesando's tree-lined boulevard has beautiful architecture worth photographing",
                    "Meiji Jingu entrance is a 5-min walk from Harajuku Station"
                )
            ),
            Activity(
                id = "d1a4",
                time = "~5:30 PM – 7:00 PM",
                title = "Shinjuku Neon & Golden Gai",
                description = "Head to Shinjuku (short train ride from Harajuku) to catch the neon lights starting to glow as evening falls. Wander through the Kabukicho entertainment district and peek into the tiny alleys of Golden Gai – a cluster of narrow lanes with over 200 tiny bars, each holding just a handful of seats. Enjoy the atmospheric evening buzz, then head back to accommodation by 7 PM.",
                area = "Shinjuku",
                location = Location(35.6938, 139.7034, "Shinjuku Kabukicho"),
                illustrationRes = R.drawable.ic_shinjuku_neon,
                tips = listOf(
                    "Golden Gai is best experienced just by walking through – most bars seat only 6–8 people",
                    "The giant Godzilla head is on the TOHO Cinemas building in Kabukicho",
                    "Don Quijote (Donki) discount store is great for quirky souvenirs"
                )
            )
        ),
        vibe = "Energetic urban buzz with plenty of people-watching and photo opportunities",
        walkingLevel = "Moderate (flat areas, many benches/cafés)"
    )

    private val day2: Day = Day(
        dayNumber = 2,
        date = "March 7, 2026 (Saturday)",
        theme = "East Side + Tower Views + Bay – Historic charm, panoramic heights & futuristic waterfront",
        areas = listOf("Asakusa", "Tokyo Skytree", "Odaiba"),
        activities = listOf(
            Activity(
                id = "d2a1",
                time = "~11:30 AM – 1:00 PM",
                title = "Late Start in Asakusa",
                description = "Start in historic Asakusa with brunch or snacks near the temple area. Street food options along Nakamise include fresh tempura, ningyo-yaki (small cakes), and melon pan. Soak in the traditional Shitamachi (old town) atmosphere.",
                area = "Asakusa",
                location = Location(35.7148, 139.7967, "Asakusa"),
                illustrationRes = R.drawable.ic_sensoji,
                tips = listOf(
                    "Asakusa is the old-town heart of Tokyo – slower pace, more traditional feel",
                    "Try the freshly grilled senbei (rice crackers) from the Nakamise shops"
                )
            ),
            Activity(
                id = "d2a2",
                time = "~1:00 PM – 3:00 PM",
                title = "Senso-ji Temple & Nakamise",
                description = "Explore Tokyo's oldest and most famous temple, Senso-ji. Enter through the iconic Kaminarimon (Thunder Gate) with its massive red lantern, walk the bustling Nakamise shopping street lined with traditional souvenirs and snacks, then reach the main temple hall. Visit the five-story pagoda, buy an omamori (charm), and enjoy the incense and atmosphere in the good afternoon light.",
                area = "Asakusa",
                location = Location(35.7148, 139.7967, "Senso-ji Temple"),
                illustrationRes = R.drawable.ic_sensoji,
                tips = listOf(
                    "The large lantern at Kaminarimon is THE iconic photo spot",
                    "Draw an omikuji fortune for ¥100 – if you get bad luck, tie it to the rack!",
                    "The pagoda looks best in afternoon light from the northwest side",
                    "Free to enter – no tickets needed"
                )
            ),
            Activity(
                id = "d2a3",
                time = "~3:00 PM – 3:15 PM",
                title = "Travel to Tokyo Skytree",
                description = "Short walk or train from Asakusa to Tokyo Skytree. It's visible from the temple area – just follow the tower! Walking takes about 15 minutes along the Sumida River for nice views.",
                area = "Skytree Area",
                location = Location(35.7101, 139.8107, "Tokyo Skytree"),
                illustrationRes = R.drawable.ic_skytree,
                tips = listOf(
                    "Walking along the Sumida River offers great photo ops of the Skytree getting closer",
                    "You can also take the Tobu Skytree Line (one stop from Asakusa)"
                )
            ),
            Activity(
                id = "d2a4",
                time = "~3:15 PM – 6:00 PM",
                title = "Tokyo Skytree Observation",
                description = "Ascend the Tokyo Skytree – the world's tallest tower at 634m. The Tembo Deck at 350m offers breathtaking 360° views: Tokyo's vast cityscape, the Sumida River winding below, the bay stretching toward Odaiba, and on clear days, Mt. Fuji in the distance. Arrive mid-afternoon for daylight panoramas, then stay through sunset (~5:40 PM in early March) to watch the city lights emerge – a magical transition. Consider the optional Tembo Galleria at 450m for even more dramatic views.",
                area = "Skytree Area",
                location = Location(35.7101, 139.8107, "Tokyo Skytree"),
                illustrationRes = R.drawable.ic_skytree,
                tips = listOf(
                    "Book tickets online in advance to skip the queue (can be 1+ hours on weekends)",
                    "Tembo Deck: ¥2,100 adults / Tembo Galleria add-on: +¥1,000",
                    "The sunset transition from day to night is the #1 highlight – arrive by 5 PM latest",
                    "Look northwest for Mt. Fuji — clearest on cold, dry days",
                    "The glass floor panels on Tembo Deck are a fun photo spot"
                )
            ),
            Activity(
                id = "d2a5",
                time = "~6:00 PM – 7:00 PM",
                title = "Odaiba Waterfront (Optional)",
                description = "If energy allows, take the train to Odaiba (~20–30 min from Skytree area). Focus on the life-size Unicorn Gundam statue outside DiverCity Tokyo Plaza – it features evening lighting and transformation effects. Walk the promenade for illuminated views of Rainbow Bridge and the Tokyo bay skyline. Keep to 30–45 min of relaxed wandering/photos, then head back to central accommodation (~30–45 min). Alternative: Skip Odaiba and return directly from Skytree.",
                area = "Odaiba",
                location = Location(35.6250, 139.7756, "Odaiba"),
                illustrationRes = R.drawable.ic_gundam,
                tips = listOf(
                    "The Gundam statue lights up and 'transforms' at set times in the evening",
                    "Rainbow Bridge is beautifully lit after dark – best seen from the Odaiba seaside promenade",
                    "If skipping Odaiba, Solamachi mall at Skytree base has good shopping and food",
                    "Rinkai Line or Yurikamome line to Odaiba – scenic ride over Rainbow Bridge"
                )
            )
        ),
        vibe = "Blend of traditional culture, breathtaking high-altitude views at golden hour/evening, and modern futuristic bay elements",
        walkingLevel = "Moderate (mostly elevators/escalators at Skytree; flat promenade in Odaiba)"
    )

    val itinerary = Itinerary(
        title = "Relaxed 2-Day Tokyo Itinerary",
        dates = "March 6–7, 2026",
        constraints = Constraints(
            startTime = "No activities before ~11:30 AM",
            endTime = "Back at accommodation by 7:00 PM each day",
            dinner = "Excluded from planning"
        ),
        generalTips = GeneralTips(
            transport = "Use Suica/PASMO/IC card for seamless travel; rely on Google Maps or similar for real-time routes",
            pace = "Relaxed with built-in flexibility, café/rest breaks encouraged, moderate walking overall",
            accommodation = "Central Tokyo (e.g., Shinjuku, Shibuya or nearby)",
            seasonNotes = "Early March – mild daytime temperatures, cooler evenings near water, potential for clear views (e.g., Mt. Fuji from high spots)"
        ),
        days = listOf(day1, day2),
        highlights = listOf(
            "Shibuya Crossing & Hachiko",
            "Harajuku Takeshita Street & Omotesando",
            "Shinjuku neon & Kabukicho",
            "Senso-ji Temple & Nakamise",
            "Tokyo Skytree panoramic views",
            "Odaiba waterfront, Rainbow Bridge, Unicorn Gundam"
        ),
        notes = "All timings allow flexibility; shorten any segment if energy is lower. Advance tickets recommended for Skytree to minimize waits."
    )
}

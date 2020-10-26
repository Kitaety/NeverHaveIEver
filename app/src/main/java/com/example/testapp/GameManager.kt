package com.example.testapp

import java.util.*
import java.util.concurrent.ThreadLocalRandom

class GameManager {
    companion object{
        val phraseForNeverHaveIEver: Map<String, Array<String>>
            get() = mapOf(
                "en" to arrayOf(
                    "i've never bungee jumped",
                    "i've never ridden an animal",
                    "i have never hitchhiked in more than a month"
                ),
                "ru" to arrayOf(
                    "занималась(ся) сексом втроем",
                    "не ел(а) авакадо",
                    "не прыгал(а) с парашютом"
                )
            )
            val phraseTruth: Map<String, Array<String>>
                get() = mapOf(
                    "en" to arrayOf(
                        "which part of your body is the most attractive and sexy?",
                        "What kind of underwear are you wearing now?",
                        "Have you dated married man?"
                    ),
                    "ru" to arrayOf(
                        "плевал(а) ли ты на людей с балкона?",
                        "переспал(а) ли ты ради повышения?",
                        "ел(а) мороженое?"
                    )
                )
            val phraseDare: Map<String, Array<String>>
                get() = mapOf(
                    "en" to arrayOf(
                        "Drink a glass of alcohol or a liter of water",
                        "kiss the one sitting opposite you",
                        "dance to the music other players have chosen"
                    ),
                    "ru" to arrayOf(
                        "поцелуй в губы человека, сидящего справа от тебя",
                        "покажи животное, которое назовет человек, сидящий слева от тебя",
                        "выпей стакан воды"
                    )
            )

        fun nextPhraseForNeverHaveIEver():String?{
            val loc = Locale.getDefault().language
            var length = GameManager.phraseForNeverHaveIEver[loc]?.size

            val index = length?.let { ThreadLocalRandom.current().nextInt(0, it) }

            return index?.let { GameManager.phraseForNeverHaveIEver[loc]?.get(it) }
        }

        fun nextPhraseTruth():String?{
            val loc = Locale.getDefault().language
            var length = GameManager.phraseTruth[loc]?.size

            val index = length?.let { ThreadLocalRandom.current().nextInt(0, it) }

            return index?.let { GameManager.phraseTruth[loc]?.get(it) }
        }

        fun nextPhraseDare():String?{
            val loc = Locale.getDefault().language
            var length = GameManager.phraseDare[loc]?.size

            val index = length?.let { ThreadLocalRandom.current().nextInt(0, it) }

            return index?.let { GameManager.phraseDare[loc]?.get(it) }
        }
    }
}
package com.example.jobsearch.utils

object PeopleUtils {
    fun formatWatchingPeopleCount(lookingNumber: Int?): String {
        if(lookingNumber != null) {
            val lastDigit = lookingNumber % 10
            val lastTwoDigits = lookingNumber % 100

            val peopleString = when {
                lastTwoDigits in 11..19 -> "человек"
                lastDigit == 1 -> "человек"
                lastDigit in 2..4 -> "человека"
                else -> "человек"
            }
            return "Сейчас просматривает $lookingNumber $peopleString"
        }
        else {
            return ""
        }
    }
}
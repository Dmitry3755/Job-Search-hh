package com.example.jobsearch.utils

import android.content.Context
import com.example.domain.entities.auxiliary_entities.Experience
import com.example.jobsearch.R

object VacancyUtils {

    fun formatWatchingPeopleCount(lookingNumber: Int?): String {
        return lookingNumber?.let { "Сейчас просматривает $it человек" } ?: ""
    }

    fun formatSalary(short: String?, full: String?): String {
        return short ?: full ?: ""
    }

    fun formatDate(context: Context, publishedDate: String?): String {
        return "${context.getString(R.string.vacancies_date_publication)} $publishedDate"
    }

    fun formatExperience(experience: Experience?): String {
        return experience?.previewText ?: ""
    }

    fun getFavoriteIconResource(isFavorite: Boolean?): Int {
        return if (isFavorite == true) R.drawable.ic_favourites_true else R.drawable.ic_favourites
    }

}
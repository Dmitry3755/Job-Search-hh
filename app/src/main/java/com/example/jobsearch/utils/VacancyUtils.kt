package com.example.jobsearch.utils

import android.content.Context
import com.example.domain.entities.auxiliary_entities.Experience
import com.example.jobsearch.R

object VacancyUtils {

    fun formatVacanciesCount(count: Int): String {
        val lastDigit = count % 10
        val lastTwoDigit = count % 100
        return when {
            lastTwoDigit in 11..19 -> "вакансий"
            lastDigit == 1 -> "вакансия"
            lastDigit in 2..4 -> "вакансии"
            else -> "вакансий"
        }
    }

    fun formatSalary(short: String?, full: String?): String = short ?: full ?: ""

    fun formatDate(context: Context, publishedDate: String?): String =
        "${context.getString(R.string.vacancies_date_publication)} $publishedDate"

    fun formatExperience(experience: Experience?): String = experience?.previewText ?: ""

    fun getFavoriteIconResource(isFavorite: Boolean?): Int {
        return if (isFavorite == true) R.drawable.ic_favourites_true else R.drawable.ic_favourites
    }

}
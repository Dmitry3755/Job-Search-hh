package com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entities.Vacancies

class VacancyDiffCallback(
    private val oldList: List<Vacancies>,
    private val newList: List<Vacancies>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
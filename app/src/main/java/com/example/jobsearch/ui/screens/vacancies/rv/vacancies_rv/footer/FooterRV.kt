package com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.footer

import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Vacancies
import com.example.jobsearch.R
import com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.VacanciesAdapterRV
import com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.VacancyDiffCallback
import com.example.jobsearch.view_models.VacanciesViewModel
import com.example.jobsearch.utils.VacancyUtils

class FooterRV(view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var vacanciesALotOfButton: Button
    var view = view
    val context = view.context

    private fun initializeView() {
        vacanciesALotOfButton = view.findViewById(R.id.lot_of_vacancies_button)
    }

    fun bindFooter(
        holder: FooterRV,
        vacanciesViewModel: VacanciesViewModel,
        vacancies: MutableList<Vacancies>,
        vacanciesAdapterRV: VacanciesAdapterRV
    ) {
        initializeView()
        holder.apply {
            vacanciesALotOfButton.text =
                "${context.getString(R.string.vacancies_another)} ${vacanciesViewModel.vacancies.value!!.size - 3} ${
                    VacancyUtils.formatVacanciesCount(vacanciesViewModel.vacancies.value!!.size - 3)
                }"
            (itemView.layoutParams as RecyclerView.LayoutParams).apply {
                bottomMargin = 150
            }
            holder.vacanciesALotOfButton.setOnClickListener {
                val diffCallback =
                    VacancyDiffCallback(vacancies, vacanciesViewModel.vacancies.value!!)
                val diffResult = DiffUtil.calculateDiff(diffCallback)
                vacancies.clear()
                vacancies.addAll(vacanciesViewModel.vacancies.value!!)
                diffResult.dispatchUpdatesTo(vacanciesAdapterRV)
                vacanciesAdapterRV.switchToNewHeader(true)
                vacanciesALotOfButtonOn(false)
            }
        }
    }

    fun vacanciesALotOfButtonOn(state : Boolean) {
        vacanciesALotOfButton.isVisible = state
    }
}
package com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.header

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Vacancies
import com.example.jobsearch.R
import com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.VacanciesAdapterRV
import com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.VacancyDiffCallback
import com.example.jobsearch.ui.screens.view_models.VacanciesViewModel
import com.google.android.material.textfield.TextInputEditText

class FilteredHeaderRV(view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var filteredVacanciesView: View
    private lateinit var vacanciesSearchEditText: TextInputEditText
    var view = view

    private fun initializeView() {
        filteredVacanciesView = view.findViewById(R.id.header_recycler_view_without_offers)
    }

    @SuppressLint("ClickableViewAccessibility")
    fun bindHeader(
        holder: FilteredHeaderRV,
        vacancies: MutableList<Vacancies>,
        vacanciesAdapterRV: VacanciesAdapterRV,
        vacanciesViewModel: VacanciesViewModel
    ) {
        initializeView()
        holder.filteredVacanciesView.apply {
            view.findViewById<TextView>(R.id.count_vacancies_text_view).text =
                "${vacanciesViewModel.vacancies.value!!.size}" + " вакансий"
            vacanciesSearchEditText = view.findViewById(R.id.vacancies_search_edit_text)
        }
        vacanciesSearchEditText.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableLeft = vacanciesSearchEditText.compoundDrawables[0]
                drawableLeft?.let {
                    if (event.rawX <= (vacanciesSearchEditText.left + (drawableLeft.intrinsicWidth + drawableLeft.bounds.width()))) {
                        handleLeftDrawableClick(vacanciesAdapterRV,vacancies, vacanciesViewModel)
                        return@setOnTouchListener true
                    }
                }
            }
            return@setOnTouchListener false
        }
    }

    private fun handleLeftDrawableClick(
        vacanciesAdapterRV: VacanciesAdapterRV,
        vacancies : MutableList<Vacancies>,
        vacanciesViewModel: VacanciesViewModel
    ) {
        val diffCallback =
            VacancyDiffCallback(vacanciesViewModel.vacancies.value!!, vacanciesViewModel.vacancies.value!!.take(3))
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        vacancies.clear()
        vacancies.addAll(vacanciesViewModel.vacancies.value!!.take(3))
        diffResult.dispatchUpdatesTo(vacanciesAdapterRV)
        vacanciesAdapterRV.switchToNewHeader(false)
        vacanciesAdapterRV.footerRV.vacanciesALotOfButtonOn(true)
    }
}
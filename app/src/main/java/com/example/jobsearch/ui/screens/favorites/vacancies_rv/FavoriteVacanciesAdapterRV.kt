package com.example.jobsearch.ui.screens.favorites.vacancies_rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Vacancies
import com.example.jobsearch.R
import com.example.jobsearch.utils.PeopleUtils
import com.example.jobsearch.utils.VacancyUtils

class FavoriteVacanciesAdapterRV(private val vacancies: List<Vacancies>) :
    RecyclerView.Adapter<FavoriteVacanciesAdapterRV.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val context = view.context
        val vacanciesWatchingItNowTextView: TextView =
            view.findViewById(R.id.vacancies_watching_it_now_text_view)
        val vacanciesPostTextView: TextView = view.findViewById(R.id.vacancies_post_text_view)
        val vacanciesSalaryTextView: TextView = view.findViewById(R.id.vacancies_salary_text_view)
        val vacanciesCountryTextView: TextView = view.findViewById(R.id.vacancies_country_text_view)
        val vacanciesCompanyTextView: TextView = view.findViewById(R.id.vacancies_company_text_view)
        val vacanciesExperienceTextView: TextView =
            view.findViewById(R.id.vacancies_experience_text_view)
        val vacanciesDataTextView: TextView = view.findViewById(R.id.vacancies_data_text_view)
        val vacanciesFavoriteImageView: ImageView =
            view.findViewById(R.id.vacancies_favorite_image_view)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_vacancy, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vacancy = vacancies[position]
        holder.apply {
            vacanciesWatchingItNowTextView.text =
                PeopleUtils.formatWatchingPeopleCount(vacancy.lookingNumber)
            vacanciesPostTextView.text = vacancy.title
            vacanciesSalaryTextView.text =
                VacancyUtils.formatSalary(vacancy.salary.short, vacancy.salary.full)
            vacanciesCountryTextView.text = vacancy.address?.town ?: ""
            vacanciesCompanyTextView.text = vacancy.company
            vacanciesExperienceTextView.text = VacancyUtils.formatExperience(vacancy.experience)
            vacanciesDataTextView.text = VacancyUtils.formatDate(context, vacancy.publishedDate)
            vacanciesFavoriteImageView.setImageResource(VacancyUtils.getFavoriteIconResource(vacancy.isFavorite))
        }
    }

    override fun getItemCount() = vacancies.size
}
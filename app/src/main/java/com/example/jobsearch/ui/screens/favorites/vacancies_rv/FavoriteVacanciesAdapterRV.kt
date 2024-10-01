package com.example.jobsearch.ui.screens.favorites.vacancies_rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Vacancies
import com.example.jobsearch.R

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
        holder.vacanciesWatchingItNowTextView.text = lookingPeopleCount(position)
        holder.vacanciesPostTextView.text = vacancies[position].title
        holder.vacanciesSalaryTextView.text =
            vacancies[position].salary.short ?: vacancies[position].salary.full
        holder.vacanciesCountryTextView.text = vacancies[position].address!!.town ?: ""
        holder.vacanciesCompanyTextView.text = vacancies[position].company
        holder.vacanciesExperienceTextView.text =
            vacancies[position].experience!!.previewText ?: ""
        holder.vacanciesDataTextView.text =
            holder.context.getString(R.string.vacancies_date_publication) + " " + vacancies[position].publishedDate
        if (vacancies[position].isFavorite!!) {
            holder.vacanciesFavoriteImageView.setImageResource(R.drawable.ic_favourites_true)

        }
    }

    override fun getItemCount() = vacancies.size

    private fun lookingPeopleCount(position: Int): String {
        return if (vacancies[position].lookingNumber != null) {
            "Сейчас просматривает " + vacancies[position].lookingNumber + " человек"
        } else {
            ""
        }
    }
}
package com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Offers
import com.example.domain.entities.Vacancies
import com.example.jobsearch.R
import com.example.jobsearch.ui.screens.vacancies.rv.offers_rv.OffersAdapterRV
import com.example.jobsearch.ui.screens.vacancies.rv.offers_rv.SpaceOffersDecoration

class VacanciesAdapterRV(private val vacancies: List<Vacancies>, private val offers: List<Offers>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val HEADER_POSITION = 0
    private val ITEM_POSITION = 1

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val headerConstraintLayout: ConstraintLayout =
            view.findViewById(R.id.header_recycler_view)
        val headerRecyclerView: RecyclerView =
            view.findViewById(R.id.vacancies_offers_recycler_view)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            HEADER_POSITION
        } else {
            ITEM_POSITION
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADER_POSITION) {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.view_recycler_view_header, viewGroup, false)
            HeaderViewHolder(view)
        } else {
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.view_vacancy, viewGroup, false)
            ItemViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            val itemPosition = position - 1
            holder.vacanciesWatchingItNowTextView.text = lookingPeopleCount(itemPosition)
            holder.vacanciesPostTextView.text = vacancies[itemPosition].title
            holder.vacanciesSalaryTextView.text =
                vacancies[itemPosition].salary.short ?: vacancies[itemPosition].salary.full
            holder.vacanciesCountryTextView.text = vacancies[itemPosition].address!!.town ?: ""
            holder.vacanciesCompanyTextView.text = vacancies[itemPosition].company
            holder.vacanciesExperienceTextView.text =
                vacancies[itemPosition].experience!!.previewText ?: ""
            holder.vacanciesDataTextView.text = vacancies[itemPosition].publishedDate
            if (vacancies[itemPosition].isFavorite!!) {
                holder.vacanciesFavoriteImageView.setImageResource(R.drawable.ic_favourites_true)
            }
        } else if (holder is HeaderViewHolder) {
            holder.headerConstraintLayout
            holder.headerRecyclerView.layoutManager =
                LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
            holder.headerRecyclerView.addItemDecoration(
                SpaceOffersDecoration(
                    holder.itemView.resources.getDimensionPixelSize(
                        R.dimen.spacer_8
                    )
                )
            )
            val offersAdapterRV = OffersAdapterRV(offers)
            holder.headerRecyclerView.adapter = offersAdapterRV
        }
    }

    override fun getItemCount() = vacancies.size + 1

    private fun lookingPeopleCount(position: Int): String {
        return if (vacancies[position].lookingNumber != null) {
            "Сейчас просматривает " + vacancies[position].lookingNumber + " человек"
        } else {
            ""
        }
    }

}
package com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Offers
import com.example.domain.entities.Vacancies
import com.example.jobsearch.R
import com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.footer.FooterRV
import com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.header.FilteredHeaderRV
import com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.header.OffersHeaderRV
import com.example.jobsearch.ui.screens.view_models.VacanciesViewModel
import com.example.jobsearch.utils.VacancyUtils

class VacanciesAdapterRV(
    private val recyclerView: RecyclerView,
    private val vacancies: MutableList<Vacancies>,
    private val offers: List<Offers>?,
    private val vacanciesViewModel: VacanciesViewModel
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isNewHeader: Boolean = false

    private lateinit var offersHeaderRV: OffersHeaderRV
    private lateinit var filteredHeaderRV: FilteredHeaderRV
    lateinit var footerRV: FooterRV

    companion object {
        private const val HEADER_POSITION = 0
        private const val FOOTER_POSITION = 2
        private const val ITEM_POSITION = 1
        private const val NEW_HEADER_POSITION = 3
    }

    override fun getItemViewType(position: Int): Int =
        when {
            isNewHeader && position == HEADER_POSITION -> NEW_HEADER_POSITION
            position == HEADER_POSITION -> HEADER_POSITION
            position == vacancies.size + 1 -> FOOTER_POSITION
            else -> ITEM_POSITION
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return when (viewType) {
            HEADER_POSITION -> {
                offersHeaderRV =
                    OffersHeaderRV(
                        inflater.inflate(
                            R.layout.view_recycler_view_header_with_offers,
                            viewGroup,
                            false
                        )
                    )
                offersHeaderRV
            }
            NEW_HEADER_POSITION -> {
                filteredHeaderRV = FilteredHeaderRV(
                    inflater.inflate(
                        R.layout.view_recycler_view_header_without_offers,
                        viewGroup,
                        false
                    )
                )
                filteredHeaderRV
            }
            FOOTER_POSITION -> {
                footerRV = FooterRV(
                    inflater.inflate(
                        R.layout.view_recycler_view_footer,
                        viewGroup,
                        false
                    )
                )
                footerRV
            }

            else -> ItemViewHolder(inflater.inflate(R.layout.view_vacancy, viewGroup, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> bindItem(holder, position - 1)
            is OffersHeaderRV -> offersHeaderRV.bindHeader(holder, offers!!)
            is FooterRV -> footerRV.bindFooter(
                holder,
                vacanciesViewModel,
                vacancies,
                this@VacanciesAdapterRV
            )
            is FilteredHeaderRV -> filteredHeaderRV.bindHeader(holder,vacancies, this@VacanciesAdapterRV, vacanciesViewModel)
        }
    }

    override fun getItemCount() = vacancies.size + 2

    private fun bindItem(holder: ItemViewHolder, position: Int) {
        val vacancy = vacancies[position]
        holder.apply {
            vacanciesWatchingItNowTextView.text =
                VacancyUtils.formatWatchingPeopleCount(vacancy.lookingNumber)
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

    fun switchToNewHeader(state: Boolean) {
        isNewHeader = state
        notifyItemChanged(0)
        recyclerView.scrollToPosition(0)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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
}
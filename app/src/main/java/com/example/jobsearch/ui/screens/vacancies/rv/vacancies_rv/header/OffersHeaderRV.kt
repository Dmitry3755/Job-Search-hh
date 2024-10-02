package com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.header

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Offers
import com.example.jobsearch.R
import com.example.jobsearch.ui.screens.vacancies.rv.offers_rv.OffersAdapterRV
import com.example.jobsearch.utils.decoration.RightSpaceDecoration

class OffersHeaderRV(view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var headerRecyclerView: RecyclerView
    private lateinit var titleTextView: TextView
    private lateinit var constraintLayout : ConstraintLayout
    var view = view
    val constraintSet = ConstraintSet()

    private fun initializeView() {
        headerRecyclerView = view.findViewById(R.id.vacancies_offers_recycler_view)
        titleTextView = view.findViewById(R.id.vacancies_title_text_view)
        constraintLayout = view.findViewById(R.id.header_recycler_view_with_offers)
    }

    fun bindHeader(holder: OffersHeaderRV, offers: List<Offers>) {
        initializeView()
        if(offers.isNotEmpty()) {
            holder.headerRecyclerView.apply {
                layoutManager =
                    LinearLayoutManager(
                        holder.itemView.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                addItemDecoration(
                    RightSpaceDecoration(
                        holder.itemView.resources.getDimensionPixelSize(
                            R.dimen.spacer_8
                        )
                    )
                )
                adapter = offers?.let { OffersAdapterRV(it) }
            }
        }
        else {
            constraintSet.clone(constraintLayout)
            constraintSet.connect(
                R.id.vacancies_title_text_view,
                ConstraintSet.TOP,
                R.id.vacancies_search_edit_text,
                ConstraintSet.BOTTOM,
                16
            )
            constraintSet.connect(
                R.id.vacancies_title_text_view,
                ConstraintSet.START,
                R.id.header_recycler_view_with_offers,
                ConstraintSet.START,
                0
            )
            constraintSet.applyTo(constraintLayout)
            holder.headerRecyclerView.isVisible = false
        }
    }
}
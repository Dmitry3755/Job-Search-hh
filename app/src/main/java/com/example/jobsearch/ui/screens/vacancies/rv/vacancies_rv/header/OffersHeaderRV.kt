package com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.header

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Offers
import com.example.jobsearch.R
import com.example.jobsearch.ui.screens.vacancies.rv.offers_rv.OffersAdapterRV
import com.example.jobsearch.utils.decoration.RightSpaceDecoration

class OffersHeaderRV(view: View) : RecyclerView.ViewHolder(view) {
    private lateinit var headerRecyclerView: RecyclerView
    var view = view

    private fun initializeView() {
        headerRecyclerView = view.findViewById(R.id.vacancies_offers_recycler_view)
    }

    fun bindHeader(holder: OffersHeaderRV, offers: List<Offers>) {
        initializeView()
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
}
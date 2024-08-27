package com.example.jobsearch.ui.screens.vacancies.rv.offers_rv

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Offers
import com.example.jobsearch.R

class OffersAdapterRV(private val offers: List<Offers>) :
    RecyclerView.Adapter<OffersAdapterRV.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val offersIconImageView: ImageView =
            view.findViewById(R.id.offers_icon_image_view)
        val offersDescriptionTextView : TextView = view.findViewById(R.id.offers_description_text_view)
        val offersButtonTextTextView : TextView = view.findViewById(R.id.offers_button_text_text_view)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_offers, viewGroup, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        when (offers[position].id) {
            "near_vacancies" -> viewHolder.offersIconImageView.setImageResource(R.drawable.ic_near_vacancies)
            "level_up_resume" -> viewHolder.offersIconImageView.setImageResource(R.drawable.ic_level_up_resume)
            "temporary_job" -> viewHolder.offersIconImageView.setImageResource(R.drawable.ic_temporary_job)
        }
        viewHolder.offersDescriptionTextView.text = offers[position].title
        if(offers[position].button != null) {
            viewHolder.offersButtonTextTextView.visibility = View.VISIBLE
            viewHolder.offersButtonTextTextView.text = offers[position].button!!.text
        }
    }

    override fun getItemCount() = offers.size - 1

}
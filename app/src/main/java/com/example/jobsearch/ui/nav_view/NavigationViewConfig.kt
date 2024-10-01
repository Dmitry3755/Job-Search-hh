package com.example.jobsearch.ui.nav_view

import android.content.Context
import com.example.jobsearch.R
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView

object NavigationViewConfig {
    lateinit var bottomNavView: BottomNavigationView
    lateinit var badge: BadgeDrawable

    fun setBadge(context: Context, count: Int) {
        badge = bottomNavView.getOrCreateBadge(R.id.favorites_vacancies)
        badge.backgroundColor = context.getColor(R.color.red)
        badge.number = count
    }
}


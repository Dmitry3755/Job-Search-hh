package com.example.jobsearch.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.jobsearch.R
import com.example.jobsearch.ui.screens.view_models.AppEmailViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class JobSearchActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var daggerViewModelFactory: ViewModelProvider.Factory
    private val appEmailViewModel by viewModels<AppEmailViewModel> {
        daggerViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_job_search_layout)
    }
}
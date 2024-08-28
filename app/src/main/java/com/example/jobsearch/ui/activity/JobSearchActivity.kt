package com.example.jobsearch.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.jobsearch.R
import com.example.jobsearch.databinding.ActJobSearchLayoutBinding
import com.example.jobsearch.ui.screens.view_models.AppEmailViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class JobSearchActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var daggerViewModelFactory: ViewModelProvider.Factory
    private val appEmailViewModel by viewModels<AppEmailViewModel> {
        daggerViewModelFactory
    }
    private lateinit var binding: ActJobSearchLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActJobSearchLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navFragment.navController

        binding.includeBottomNavigationView.navView.setupWithNavController(navController)
    }
}
package com.example.jobsearch.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.jobsearch.R
import com.example.jobsearch.databinding.ActJobSearchLayoutBinding
import com.example.jobsearch.ui.nav_view.NavigationViewConfig
import com.example.jobsearch.view_models.AppEmailViewModel
import com.example.jobsearch.utils.NetworkMonitor
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class JobSearchActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor
    @Inject
    lateinit var daggerViewModelFactory: ViewModelProvider.Factory
    private val appEmailViewModel by viewModels<AppEmailViewModel> {
        daggerViewModelFactory
    }
    private lateinit var binding: ActJobSearchLayoutBinding
    private lateinit var navFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActJobSearchLayoutBinding.inflate(layoutInflater)
        navigationInitialize()
        setContentView(binding.root)
        networkMonitor.registerNetworkCallback()
    }

    override fun onDestroy() {
        super.onDestroy()
        networkMonitor.unregisterNetworkCallback()
    }

    private fun navigationInitialize() {
        navFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navFragment.navController
        NavigationViewConfig.bottomNavView = binding.includeBottomNavigationView.navView
        NavigationViewConfig.bottomNavView.setupWithNavController(navController)
    }
}
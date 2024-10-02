package com.example.jobsearch.ui.screens.favorites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entities.Data
import com.example.jobsearch.R
import com.example.jobsearch.databinding.FmtFavoritesBinding
import com.example.jobsearch.ui.base.BaseFragment
import com.example.jobsearch.ui.nav_view.NavigationViewConfig
import com.example.jobsearch.ui.screens.favorites.vacancies_rv.FavoriteVacanciesAdapterRV
import com.example.jobsearch.utils.NetworkMonitor
import com.example.jobsearch.view_models.DataViewModel
import com.example.jobsearch.view_models.VacanciesViewModel
import com.example.jobsearch.utils.VacancyUtils
import com.example.jobsearch.utils.decoration.BottomSpaceDecoration
import javax.inject.Inject

class FavoritesFragment : BaseFragment() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    private val vacanciesViewModel by viewModels<VacanciesViewModel> {
        daggerViewModelFactory
    }
    private val dataViewModel by viewModels<DataViewModel> {
        daggerViewModelFactory
    }
    private lateinit var binding: FmtFavoritesBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (networkMonitor.networkState.value!!) {
            true -> dataViewModel.loadNetworkData()
            false -> dataViewModel.loadLocalData()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FmtFavoritesBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.let { bind ->
            initializeVacanciesRV()

            dataViewModel.data.observe(viewLifecycleOwner) {
                NavigationViewConfig.setBadge(
                    requireContext(),
                    vacanciesViewModel.favoritesVacancies.value!!.size
                )
                vacanciesInit(it)
                NavigationViewConfig.setBadge(
                    requireContext(),
                    vacanciesViewModel.favoritesVacancies.value!!.size
                )
                binding.favoritesVacanciesRecyclerView.adapter =
                    FavoriteVacanciesAdapterRV(vacanciesViewModel.favoritesVacancies.value!!)
                bind.countVacanciesTextView.text =
                    "${vacanciesViewModel.favoritesVacancies.value!!.size} ${
                        VacancyUtils.formatVacanciesCount(vacanciesViewModel.favoritesVacancies.value!!.size)
                    }"
            }
        }
    }

    private fun vacanciesInit(data: Data) {
        vacanciesViewModel.vacancies.value = data.vacancies
        vacanciesViewModel.getFavoritesVacancies()
    }

    private fun initializeVacanciesRV() {
        binding.favoritesVacanciesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.favoritesVacanciesRecyclerView.addItemDecoration(
            BottomSpaceDecoration(
                resources.getDimensionPixelSize(
                    R.dimen.spacer_8
                )
            )
        )
    }
}
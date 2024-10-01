package com.example.jobsearch.ui.screens.vacancies

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entities.Data
import com.example.jobsearch.R
import com.example.jobsearch.databinding.FmtVacanciesBinding
import com.example.jobsearch.databinding.ViewRecyclerViewFooterBinding
import com.example.jobsearch.databinding.ViewRecyclerViewHeaderWithoutOffersBinding
import com.example.jobsearch.ui.base.BaseFragment
import com.example.jobsearch.ui.nav_view.NavigationViewConfig
import com.example.jobsearch.ui.screens.favorites.vacancies_rv.FavoriteVacanciesAdapterRV
import com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.VacanciesAdapterRV
import com.example.jobsearch.ui.screens.view_models.DataViewModel
import com.example.jobsearch.ui.screens.view_models.VacanciesViewModel
import com.example.jobsearch.utils.decoration.BottomSpaceDecoration

class VacanciesFragment : BaseFragment() {

    private val dataViewModel by viewModels<DataViewModel> {
        daggerViewModelFactory
    }
    private val vacanciesViewModel by viewModels<VacanciesViewModel> {
        daggerViewModelFactory
    }
    private lateinit var binding: FmtVacanciesBinding
    private lateinit var bindingFooterRV: ViewRecyclerViewFooterBinding
    private lateinit var bindingHeaderWithoutOffers: ViewRecyclerViewHeaderWithoutOffersBinding
    private lateinit var vacanciesAdapterRV: VacanciesAdapterRV

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataViewModel.loadData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ViewRecyclerViewFooterBinding.inflate(inflater, container, false).also {
            bindingFooterRV = it
        }
        ViewRecyclerViewHeaderWithoutOffersBinding.inflate(inflater, container, false).also {
            bindingHeaderWithoutOffers = it
        }
        return FmtVacanciesBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.let { bind ->
            initializeVacanciesRV()
            dataViewModel.data.observe(viewLifecycleOwner) {
                vacanciesInit(it)
                NavigationViewConfig.setBadge(
                    requireContext(),
                    vacanciesViewModel.favoritesVacancies.value!!.size
                )
                bind.vacanciesRecyclerView.adapter =
                    dataViewModel.data.value?.let {
                        vacanciesAdapterRV = VacanciesAdapterRV(
                            bind.vacanciesRecyclerView,
                            vacanciesViewModel.vacancies.value!!.take(3).toMutableList(),
                            it.offers,
                            vacanciesViewModel
                        )
                        vacanciesAdapterRV
                    }!!
            }
        }
    }

    private fun initializeVacanciesRV() {
        binding.vacanciesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.vacanciesRecyclerView.addItemDecoration(
            BottomSpaceDecoration(
                resources.getDimensionPixelSize(
                    R.dimen.spacer_8
                )
            )
        )
    }

    private fun vacanciesInit(data: Data) {
        vacanciesViewModel.vacancies.value = data.vacancies
        vacanciesViewModel.getFavoritesVacancies()
    }
}
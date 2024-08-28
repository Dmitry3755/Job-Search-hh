package com.example.jobsearch.ui.screens.vacancies

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginBottom
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobsearch.R
import com.example.jobsearch.databinding.FmtVacanciesBinding
import com.example.jobsearch.databinding.ViewRecyclerViewFooterBinding
import com.example.jobsearch.ui.base.BaseFragment
import com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.SpaceVacanciesDecoration
import com.example.jobsearch.ui.screens.vacancies.rv.vacancies_rv.VacanciesAdapterRV
import com.example.jobsearch.ui.screens.view_models.DataViewModel
import javax.inject.Inject

class VacanciesFragment : BaseFragment() {

    @Inject
    lateinit var daggerViewModelFactory: ViewModelProvider.Factory
    private val dataViewModel by viewModels<DataViewModel> {
        daggerViewModelFactory
    }
    private lateinit var binding: FmtVacanciesBinding
    private lateinit var bindingFooterRV: ViewRecyclerViewFooterBinding

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
        return FmtVacanciesBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.let { bind ->

            initializeVacanciesRV()

            dataViewModel.data.observe(viewLifecycleOwner) {
                bind.vacanciesRecyclerView.adapter =
                    dataViewModel.data.value?.let { VacanciesAdapterRV(it.vacancies, it.offers) }!!
            }
        }
    }

    private fun initializeButton() {
        bindingFooterRV.vacanciesALotOfButton.setOnClickListener {

        }
    }

    private fun initializeVacanciesRV() {
        binding.vacanciesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.vacanciesRecyclerView.addItemDecoration(
            SpaceVacanciesDecoration(
                resources.getDimensionPixelSize(
                    R.dimen.spacer_8
                )
            )
        )
    }

}
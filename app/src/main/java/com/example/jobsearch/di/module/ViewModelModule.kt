package com.example.jobsearch.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jobsearch.di.key.ViewModelKey
import com.example.jobsearch.di.viewmodel.DaggerViewModelFactory
import com.example.jobsearch.ui.screens.view_models.AppEmailViewModel
import com.example.jobsearch.ui.screens.view_models.DataViewModel
import com.example.jobsearch.ui.screens.view_models.VacanciesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DataViewModel::class)
    abstract fun bindDataViewModel(dataViewModelViewModel: DataViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AppEmailViewModel::class)
    abstract fun bindAppDataViewModel(appEmailViewModel: AppEmailViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(VacanciesViewModel::class)
    abstract fun bindVacanciesViewModel(vacanciesViewModel: VacanciesViewModel) : ViewModel
}
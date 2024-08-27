package com.example.jobsearch.di.module

import com.example.jobsearch.di.scope.FragmentScope
import com.example.jobsearch.ui.screens.sign_in.SignInFragment
import com.example.jobsearch.ui.screens.vacancies.VacanciesFragment
import com.example.jobsearch.ui.screens.verify_code.VerifyCodeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun provideVacanciesFragment() : VacanciesFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideSingInFragment() : SignInFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideVerifyCodeFragment() : VerifyCodeFragment


}
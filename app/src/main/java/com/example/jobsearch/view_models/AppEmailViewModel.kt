package com.example.jobsearch.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jobsearch.utils.EmailVerify
import javax.inject.Inject

class AppEmailViewModel @Inject constructor(): ViewModel() {
    var email : MutableLiveData<String> = MutableLiveData("")

    fun emailVerify() : Boolean  = EmailVerify(email.value.toString())
}
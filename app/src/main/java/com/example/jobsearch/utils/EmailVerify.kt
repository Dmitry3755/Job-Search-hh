package com.example.jobsearch.utils

import androidx.core.util.PatternsCompat

fun EmailVerify(email: String): Boolean = PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()


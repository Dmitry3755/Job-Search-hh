package com.example.jobsearch.ui.screens.sign_in

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.jobsearch.R
import com.example.jobsearch.databinding.FmtSignInBinding
import com.example.jobsearch.ui.screens.view_models.AppEmailViewModel
import com.example.jobsearch.ui.base.BaseFragment
import javax.inject.Inject

class SignInFragment : BaseFragment() {

    @Inject
    lateinit var daggerViewModelFactory: ViewModelProvider.Factory
    private lateinit var appEmailViewModel: Lazy<AppEmailViewModel>
    private lateinit var binding: FmtSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        appEmailViewModel = activity?.viewModels<AppEmailViewModel> { daggerViewModelFactory }!!
        return FmtSignInBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.let { bind ->
            addTextListener()
            bind.searchJobView.singInContinueButton.setOnClickListener {
                onClickButtonContinue()
            }
        }
    }

    private fun addTextListener() =
        binding.searchJobView.singInEmailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) =
                appEmailViewModel.value.email.postValue(binding.searchJobView.singInEmailEditText.text.toString())

            override fun afterTextChanged(p0: Editable?) = isErrorEmailValidation(false)
        })

    private fun onClickButtonContinue() =
        when (appEmailViewModel.value.emailVerify()) {
            true -> navigateToVerifyCodeFragment()
            false -> isErrorEmailValidation(true)
        }

    private fun navigateToVerifyCodeFragment() {
        appEmailViewModel.value.email.postValue(binding.searchJobView.singInEmailEditText.text.toString())
        Navigation.findNavController(binding.root)
            .navigate(SignInFragmentDirections.actionSignInFragmentToVerifyCodeFragment())
    }

    private fun isErrorEmailValidation(isError: Boolean) {
        when (isError) {
            true -> {
                binding.searchJobView.signInEmailTextInputLayout.helperText = getString(
                    R.string.error
                )
                binding.searchJobView.singInEmailEditText.setBackgroundDrawable(
                    AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.error_outline
                    )
                )
            }

            false -> {
                binding.searchJobView.singInEmailEditText.setBackgroundDrawable(
                    AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.bg_text_input_edit_text
                    )
                )
                binding.searchJobView.signInEmailTextInputLayout.helperText = ""
            }
        }

    }
}
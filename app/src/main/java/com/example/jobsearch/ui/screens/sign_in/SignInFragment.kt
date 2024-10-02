package com.example.jobsearch.ui.screens.sign_in

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.Navigation
import com.example.jobsearch.R
import com.example.jobsearch.databinding.FmtSignInBinding
import com.example.jobsearch.ui.base.BaseFragment
import com.example.jobsearch.view_models.AppEmailViewModel

class SignInFragment : BaseFragment() {

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
            buttonContinueNonActive()
            addTextListener()
        }
    }

    private fun addTextListener() =
        binding.searchJobView.singInEmailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) =
                appEmailViewModel.value.email.postValue(binding.searchJobView.singInEmailEditText.text.toString())

            override fun afterTextChanged(p0: Editable?) {
                isErrorEmailValidation(false)
                onClickButtonContinueActive()
            }
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

    private fun buttonContinueNonActive() {
        binding.searchJobView.singInContinueButton.setTextColor(resources.getColor(R.color.gray4))
        binding.searchJobView.singInContinueButton.setBackgroundResource(R.drawable.bg_system_button_non_active)
    }

    private fun buttonContinueIsActive() {
        binding.searchJobView.singInContinueButton.setTextColor(resources.getColor(R.color.white))
        binding.searchJobView.singInContinueButton.setBackgroundResource(R.drawable.bg_system_button_is_active)
    }

    private fun onClickButtonContinueActive() =
        when (binding.searchJobView.singInEmailEditText.text.toString() != "") {
            true -> {
                buttonContinueIsActive()
                binding.searchJobView.singInContinueButton.setOnClickListener {
                    onClickButtonContinue()
                }
            }

            false -> buttonContinueNonActive()
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
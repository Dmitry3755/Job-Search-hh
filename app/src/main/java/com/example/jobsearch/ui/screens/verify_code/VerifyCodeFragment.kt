package com.example.jobsearch.ui.screens.verify_code

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.jobsearch.R
import com.example.jobsearch.databinding.FmtVerifyCodeBinding
import com.example.jobsearch.ui.base.BaseFragment
import com.example.jobsearch.ui.screens.view_models.AppEmailViewModel
import javax.inject.Inject

class VerifyCodeFragment : BaseFragment() {

    @Inject
    lateinit var daggerViewModelFactory: ViewModelProvider.Factory
    private lateinit var appEmailViewModel: Lazy<AppEmailViewModel>
    private lateinit var binding: FmtVerifyCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        appEmailViewModel = activity?.viewModels<AppEmailViewModel> { daggerViewModelFactory }!!
        return FmtVerifyCodeBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.let { bind ->
            initializeEmailTextView()
            setAddTextChangeListener()

            bind.verifyCodeConfirmButton.setOnClickListener {
                navigateToVacanciesFragment()
            }
        }
    }

    private fun navigateToVacanciesFragment() =
        Navigation.findNavController(binding.root)
            .navigate(VerifyCodeFragmentDirections.actionNavigationVerifyCodeToVacanciesFragment())

    @SuppressLint("SetTextI18n")
    private fun initializeEmailTextView() {
        binding.verifyCodeEmailTextView.text =
            getString(R.string.enter_code_send_code_on) + " " + appEmailViewModel.value.email.value
    }

    private fun setAddTextChangeListener() {
        binding.verifyCodeCellsView.verifyCodeEditText1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){}
            override fun afterTextChanged(p0: Editable?) {

            }
        })
        binding.verifyCodeCellsView.verifyCodeEditText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){}
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.verifyCodeCellsView.verifyCodeEditText3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){}
            override fun afterTextChanged(p0: Editable?) {}
        })
    }
}
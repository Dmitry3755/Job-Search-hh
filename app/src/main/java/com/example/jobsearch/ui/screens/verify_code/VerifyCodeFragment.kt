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
    private var codeList = arrayOf("", "", "", "")

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
            buttonContinueNonActive()
            initializeEmailTextView()
            setAddTextChangeListener()
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

    private fun buttonContinueNonActive() {
        binding.verifyCodeConfirmButton.setOnClickListener {}
        binding.verifyCodeConfirmButton.setTextColor(resources.getColor(R.color.gray4))
        binding.verifyCodeConfirmButton.setBackgroundResource(R.drawable.bg_system_button_non_active)
    }

    private fun buttonContinueIsActive() {
        binding.verifyCodeConfirmButton.setOnClickListener { navigateToVacanciesFragment() }
        binding.verifyCodeConfirmButton.setTextColor(resources.getColor(R.color.white))
        binding.verifyCodeConfirmButton.setBackgroundResource(R.drawable.bg_system_button_is_active)
    }

    private fun setAddTextChangeListener() {
        binding.verifyCodeCellsView.verifyCodeEditText1.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                codeList[0] = binding.verifyCodeCellsView.verifyCodeEditText1.text.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                when (binding.verifyCodeCellsView.verifyCodeEditText1.text.toString() != "") {
                    true -> {
                        binding.verifyCodeCellsView.verifyCodeEditText2.requestFocus()
                        verifyCodeValid()
                    }

                    false -> buttonContinueNonActive()
                }
            }
        })
        binding.verifyCodeCellsView.verifyCodeEditText2.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                codeList[1] = binding.verifyCodeCellsView.verifyCodeEditText2.text.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                when (binding.verifyCodeCellsView.verifyCodeEditText2.text.toString() != "") {
                    true -> {
                        binding.verifyCodeCellsView.verifyCodeEditText3.requestFocus()
                        verifyCodeValid()
                    }

                    false -> buttonContinueNonActive()
                }
            }
        })
        binding.verifyCodeCellsView.verifyCodeEditText3.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                codeList[2] = binding.verifyCodeCellsView.verifyCodeEditText3.text.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                when (binding.verifyCodeCellsView.verifyCodeEditText3.text.toString() != "") {
                    true -> {
                        binding.verifyCodeCellsView.verifyCodeEditText4.requestFocus()
                        verifyCodeValid()
                    }

                    false -> buttonContinueNonActive()
                }
            }
        })
        binding.verifyCodeCellsView.verifyCodeEditText4.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                codeList[3] = binding.verifyCodeCellsView.verifyCodeEditText4.text.toString()
                when (binding.verifyCodeCellsView.verifyCodeEditText4.text.toString() != "") {
                    true -> verifyCodeValid()
                    false -> buttonContinueNonActive()
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun verifyCodeValid() {
        var i = 0
        for (number in codeList) {
            if (number != "") i++
        }
        if (i == 4) buttonContinueIsActive()

    }
}
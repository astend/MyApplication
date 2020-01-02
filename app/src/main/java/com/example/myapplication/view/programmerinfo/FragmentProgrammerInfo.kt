package com.example.myapplication.view.programmerinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentProgrammerInfoBinding


class FragmentProgrammerInfo: Fragment() {

  private lateinit var viewModel: ProgrammerFragmentVM

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_programmer_info, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProviders.of(this).get(ProgrammerFragmentVM::class.java)

    val binding = DataBindingUtil.setContentView<FragmentProgrammerInfoBinding>(
      activity!!,
      R.layout.fragment_programmer_info
    )
    binding.programmer = viewModel.programmer
  }

}

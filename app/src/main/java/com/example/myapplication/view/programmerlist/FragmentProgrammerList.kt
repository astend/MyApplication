package com.example.myapplication.view.programmerlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_programmer_list.*

class FragmentProgrammerList: Fragment() {

  private val adapter = ProgrammerListAdapter()
  private lateinit var viewModel: FragmentProgrammerListVM

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_programmer_list, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProviders.of(this).get(FragmentProgrammerListVM::class.java)

    viewModel.programmers.observe(viewLifecycleOwner,
      Observer { list ->
        pbProgrammers.visibility = View.GONE

        if (list == null) return@Observer

        adapter.updateList(list)
      })

    pbProgrammers.visibility = View.VISIBLE
    viewModel.mockLoadProgrammers()
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    rvProgrammers.layoutManager = LinearLayoutManager(context!!)
    rvProgrammers.adapter = adapter
  }
}
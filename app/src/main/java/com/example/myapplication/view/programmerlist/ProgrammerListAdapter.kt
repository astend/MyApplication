package com.example.myapplication.view.programmerlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemProgrammerInfoBinding
import com.example.myapplication.databinding.ItemProgrammerPhoneBinding
import com.example.myapplication.model.Programmer

/**
 * Created on 02.01.20.
 */
class ProgrammerListAdapter : RecyclerView.Adapter<ProgrammerListAdapter.ProgrammerHolder>() {

  private var programmers = listOf<Programmer>()

  class ProgrammerHolder(val binding: ItemProgrammerInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(programmer: Programmer) {
      binding.programmer = programmer
      binding.vsPhoneNumber.setOnInflateListener { stub, inflated ->
        val programmerPhoneBinding: ItemProgrammerPhoneBinding = DataBindingUtil.bind(inflated)!!
        programmerPhoneBinding.programmer = programmer
      }
      binding.executePendingBindings()
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammerHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding: ItemProgrammerInfoBinding =
      DataBindingUtil.inflate(inflater, R.layout.item_programmer_info, parent, false)
    return ProgrammerHolder(binding)
  }

  override fun getItemCount(): Int {
    return programmers.size
  }

  override fun onBindViewHolder(holder: ProgrammerHolder, position: Int) {
    val programmer = programmers[position]
    holder.bind(programmer)

    if (programmer.phoneNumber != null && !holder.binding.vsPhoneNumber.isInflated)
      holder.binding.vsPhoneNumber.viewStub?.inflate()
  }

  fun updateList(programmers: List<Programmer>) {
    this.programmers = programmers
    notifyDataSetChanged()
  }
}
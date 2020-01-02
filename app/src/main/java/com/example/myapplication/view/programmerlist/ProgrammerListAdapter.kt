package com.example.myapplication.view.programmerlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Programmer

/**
 * Created on 02.01.20.
 */
class ProgrammerListAdapter: RecyclerView.Adapter<ProgrammerListAdapter.ViewHolder>() {

  private var programmers = listOf<Programmer>()

  class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val age: TextView = itemView.findViewById(R.id.tvAge)
    val name: TextView = itemView.findViewById(R.id.tvName)
    val skills: TextView = itemView.findViewById(R.id.tvSkills)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_programmer_info, parent, false)
    return ViewHolder(itemView)
  }

  override fun getItemCount(): Int {
    return programmers.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val programmer = programmers[position]
    holder.name.text = programmer.name
    holder.age.text = programmer.age.toString()
    holder.skills.text = programmer.skillsToString()
  }

  fun updateList(programmers: List<Programmer>) {
    this.programmers = programmers
    notifyDataSetChanged()
  }
}
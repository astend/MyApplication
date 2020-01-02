package com.example.myapplication.view.programmerinfo

import com.example.myapplication.model.Programmer
import com.example.myapplication.model.ProgrammingLanguage
import com.example.myapplication.mvvm.BaseViewModel

class ProgrammerFragmentVM: BaseViewModel() {

  val programmer: Programmer = Programmer("Ivan", 23, listOf(ProgrammingLanguage.C_PLUSPLUS, ProgrammingLanguage.JAVA))

}

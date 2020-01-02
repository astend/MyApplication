package com.example.myapplication.model

/**
 * Created on 02.01.20.
 */
class Programmer {

  var name: String = ""
    private set
  var age: Int = -1
    private set
  var skills: List<ProgrammingLanguage> = listOf()
    private set

  constructor(name: String) {
    this.name = name
  }

  constructor(name: String, age: Int) : this(name) {
    this.age = age
  }

  constructor(name: String, age: Int, skills: List<ProgrammingLanguage>) : this(name, age) {
    this.skills = skills
  }

  fun skillsToString(): String {
    return if (skills.isEmpty()) "Don't have skills"
    else {
      val skillsText = StringBuilder()
      skills.forEach { skillsText.append(it.langName).append(", ") }
      skillsText.toString().dropLast(2)
    }
  }

}
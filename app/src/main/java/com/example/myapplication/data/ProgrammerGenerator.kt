package com.example.myapplication.data

import com.example.myapplication.model.Programmer
import com.example.myapplication.model.ProgrammingLanguage
import kotlin.random.Random

/**
 * Created on 02.01.20.
 */
object ProgrammerGenerator {

  private val maleNames = listOf(
    "James", "John", "Robert", "Michael", "William",
    "David", "Richard", "Joseph", "Thomas", "Charles", "Christopher", "Daniel", "Matthew",
    "Anthony", "Donald", "Mark", "Paul", "Steven", "Andrew", "Kenneth", "Joshua", "George", "Kevin",
    "Brian", "Edward", "Ronald", "Timothy", "Jason", "Jeffrey", "Ryan", "Jacob", "Gary", "Nicholas",
    "Eric", "Stephen", "Jonathan", "Larry", "Justin", "Scott", "Brandon", "Frank", "Benjamin",
    "Gregory", "Samuel", "Raymond", "Patrick", "Alexander", "Jack", "Dennis", "Jerry", "Tyler",
    "Aaron", "Jose", "Henry", "Douglas", "Adam", "Peter", "Nathan", "Zachary", "Walter", "Kyle",
    "Harold", "Carl", "Jeremy", "Keith", "Roger", "Gerald", "Ethan", "Arthur", "Terry", "Christian",
    "Sean", "Lawrence", "Austin", "Joe", "Noah", "Jesse", "Albert", "Bryan", "Billy", "Bruce",
    "Willie", "Jordan", "Dylan", "Alan", "Ralph", "Gabriel", "Roy", "Juan", "Wayne", "Eugene",
    "Logan", "Randy", "Louis", "Russell", "Vincent", "Philip", "Bobby", "Johnny", "Bradley"
  )

  private val femaleNames = listOf(
    "Mary", "Patricia", "Jennifer", "Linda", "Elizabeth", "Barbara",
    "Susan", "Jessica", "Sarah", "Karen", "Nancy", "Margaret", "Lisa", "Betty", "Dorothy", "Sandra",
    "Ashley", "Kimberly", "Donna", "Emily", "Michelle", "Carol", "Amanda", "Melissa", "Deborah",
    "Stephanie", "Rebecca", "Laura", "Sharon", "Cynthia", "Kathleen", "Helen", "Amy", "Shirley",
    "Angela", "Anna", "Brenda", "Pamela", "Nicole", "Ruth", "Katherine", "Samantha", "Christine",
    "Emma", "Catherine", "Debra", "Virginia", "Rachel", "Carolyn", "Janet", "Maria", "Heather",
    "Diane", "Julie", "Joyce", "Victoria", "Kelly", "Christina", "Joan", "Evelyn", "Lauren",
    "Judith", "Olivia", "Frances", "Martha", "Cheryl", "Megan", "Andrea", "Hannah", "Jacqueline",
    "Ann", "Jean", "Alice", "Kathryn", "Gloria", "Teresa", "Doris", "Sara", "Janice", "Julia",
    "Marie", "Madison", "Grace", "Judy", "Theresa", "Beverly", "Denise", "Marilyn", "Amber",
    "Danielle", "Abigail", "Brittany", "Rose", "Diana", "Natalie", "Sophia", "Alexis", "Lori",
    "Kayla", "Jane"
  )

  private fun generateNames(count: Int): List<String> {
    val numbers = mutableListOf<Int>()
    for (i in 0 until maleNames.size + femaleNames.size)
      numbers.add(i)
    numbers.shuffle()

    val names = mutableListOf<String>()

    for (i in 0 until count) {
      if (numbers[i] > maleNames.size - 1)
        names.add(femaleNames[numbers[i] - maleNames.size])
      else
        names.add(maleNames[numbers[i]])
    }

    return names
  }

  fun generateProgrammers(count: Int): List<Programmer> {
    val names = generateNames(count)
    val programmerList = mutableListOf<Programmer>()

    val random = Random(System.currentTimeMillis())

    names.forEach {
      val age = random.nextInt(18, 50)
      val maxSkillCount = age / 10 + 1
      val skillsCount = random.nextInt(1, maxSkillCount)
      val programmer = Programmer(it, age, generateSkills(skillsCount))

      if (random.nextBoolean())
        programmer.phoneNumber = generatePhoneNumber(random)

      programmerList.add(programmer)
    }

    return programmerList
  }

  private fun generateSkills(count: Int): List<ProgrammingLanguage> {
    val skills = mutableListOf<ProgrammingLanguage>()
    if (count < 1)
      return skills

    val progLangs = ProgrammingLanguage.values().toList().shuffled()

    for (i in 0 until count)
      skills.add(progLangs[i])

    return skills
  }

  private fun generatePhoneNumber(random: Random):String {
    var phone = "+380"
    for (i in 0 until 9)
      phone += random.nextInt(0, 10).toString()
    return phone
  }
}
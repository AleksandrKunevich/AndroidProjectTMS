package com.bignerdranch.android.androidprojecttms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.androidprojecttms.school.Discipline
import com.bignerdranch.android.androidprojecttms.school.Mark
import com.bignerdranch.android.androidprojecttms.school.Student
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val students: MutableList<Student> = mutableListOf()
        val disciplines: MutableList<Discipline> = mutableListOf()
        students.add(Student("Petya", 101))
        students.add(Student("Kolya", 102))
        students.add(Student("Inna", 103))
        students.add(Student("Vika", 104))
        students.add(Student("Tanya", 105))
        students.add(Student("Serge", 106))
        students.add(Student("Anna", 107))
        disciplines.add(Discipline("Mathematica", 111))
        disciplines.add(Discipline("Russian", 222))
        disciplines.add(Discipline("Physic", 333))
        disciplines.add(Discipline("English", 444))
        disciplines.add(Discipline("Biology", 555))
        val mark: MutableList<Mark> = mutableListOf()
        students.forEach { _student ->
            disciplines.forEach {
                mark.add(Mark(Random.nextInt(10) + 1, _student, it))
            }
        }

        val averageMarkStudent: MutableMap<Int, Double> = mutableMapOf()
        val averageMarkDiscipline: MutableMap<Int, Double> = mutableMapOf()
        var averageGeneral = 0.0
        val marksStudents: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        mark.forEach {
            averageGeneral += it.value
            if (averageMarkStudent[it.studentId] != null) {
                averageMarkStudent[it.studentId] =
                    (averageMarkStudent[it.studentId]!! + it.value.toDouble())
            } else {
                averageMarkStudent[it.studentId] = it.value.toDouble()
            }
            if (averageMarkDiscipline[it.disciplineId] != null) {
                averageMarkDiscipline[it.disciplineId] =
                    (averageMarkDiscipline[it.disciplineId]!! + it.value.toDouble())
            } else {
                averageMarkDiscipline[it.disciplineId] = it.value.toDouble()
            }
            if (marksStudents[it.studentId] != null) {
                marksStudents[it.studentId]!!.add(it.value)
            } else {
                marksStudents[it.studentId] = mutableListOf(it.value)
            }
        }
        averageGeneral /= mark.size
        averageMarkStudent.forEach {
            averageMarkStudent[it.key] = averageMarkStudent[it.key]!! / disciplines.size
        }
        averageMarkDiscipline.forEach {
            averageMarkDiscipline[it.key] = averageMarkDiscipline[it.key]!! / disciplines.size
        }
        averageMarkStudent.forEach {
            println("${nameStudent(it.key, students)} = ${it.value}")
        }
        averageMarkDiscipline.forEach {
            println("${titleDiscipline(it.key, disciplines)} = ${it.value}")
        }
        println("Average class = $averageGeneral")

        marksStudents.forEach { markIt ->
            var excellent = 0
            var good = 0
            markIt.value.forEach {
                if (it in 9..10) {
                    excellent++
                }
                if (it in 6..10) {
                    good++
                }
            }
            when {
                excellent == disciplines.size -> {
                    println(
                        "Excellent student ${
                            nameStudent(
                                markIt.key,
                                students
                            )
                        } marks=${marksStudents[markIt.key]}"
                    )
                }
                good == disciplines.size -> {
                    println(
                        "Good student ${
                            nameStudent(
                                markIt.key,
                                students
                            )
                        } marks=${marksStudents[markIt.key]}"
                    )
                }
                (good + 1) == disciplines.size -> {
                    println(
                        "Very close to be good student ${
                            nameStudent(
                                markIt.key,
                                students
                            )
                        } marks=${marksStudents[markIt.key]}"
                    )
                }
            }
        }
    }
}

fun main() {
    val discount = Discount(
        "Project",
        "Good project",
        1,
        "https://im0-tub-by.yandex.net/i?id=eaa2b044794b726227846dda9669ffe9&n=13",
        "https://github.com/AleksandrKunevich/AndroidProjectTMS",
        DiscountType.RangeAmount(3, 9)
    )
    println(discount)
    val discount2 = discount.copy()
    println("Сравнение (==): ${discount == discount2}")
    discount2.discountType = DiscountType.FlatAmount(5)
    println(discount)
    println(discount2)
    val discount3 = discount2.copy()
    discount3.discountType = DiscountType.NoDiscount
    println(discount3)
    println(discount.discountType.calculate(5))
    println(discount2.discountType.calculate(5))
    println(discount3.discountType.calculate(5))

}

fun nameStudent(id: Int, students: MutableList<Student>): String {
    students.forEach {
        if (it.id == id) return it.name
    }
    return "No student"
}

fun titleDiscipline(id: Int, disciplines: MutableList<Discipline>): String {
    disciplines.forEach {
        if (it.id == id) return it.title
    }
    return "No discipline"
}


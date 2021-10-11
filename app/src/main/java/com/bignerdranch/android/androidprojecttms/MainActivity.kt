package com.bignerdranch.android.androidprojecttms

import android.os.Bundle
import android.util.Log
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
        val mark: MutableList<Mark> = mutableListOf()
        val averageMarkStudent: MutableMap<Int, Double> = mutableMapOf()
        val averageMarkDiscipline: MutableMap<Int, Double> = mutableMapOf()
        var averageGeneral = 0.0
        val marksStudents: MutableMap<Int, MutableList<Int>> = mutableMapOf()

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

        // Назначаем оценки всем ученикам по всем предметам
        students.forEach { _student ->
            disciplines.forEach {
                mark.add(Mark(Random.nextInt(10) + 1, _student, it))
            }
        }

        // Определяем и печатаем средние значения оценок
        mark.forEach {
            averageGeneral += it.value

            val currentSum = averageMarkStudent.getOrDefault(it.studentId, 0)
            val newSum = currentSum.toDouble() + it.value.toDouble()
            averageMarkStudent[it.studentId] = newSum

            val currentDisciplineSum =
                averageMarkDiscipline.getOrPut(it.disciplineId, { 0.toDouble() })
            val newDisciplineSum = currentDisciplineSum + it.value.toDouble()
            averageMarkDiscipline[it.disciplineId] = newDisciplineSum

            val marks = marksStudents.getOrElse(it.studentId, { mutableListOf() })
            marks.add(it.value)
            marksStudents[it.studentId] = marks
        }
        averageGeneral /= mark.size
        averageMarkStudent.forEach { (key, value) ->
            averageMarkStudent[key] = value / disciplines.size
        }
        averageMarkDiscipline.forEach {
            averageMarkDiscipline[it.key] = averageMarkDiscipline[it.key]!! / students.size
        }
        averageMarkStudent.forEach {
            Log.v("Средняя оценка студента ${nameStudent(it.key, students)}", "${it.value}")
        }
        averageMarkDiscipline.forEach {
            Log.w("Средняя по предмету ${titleDiscipline(it.key, disciplines)}", "${it.value}")
        }
        Log.e("Средняя оценка класса", "$averageGeneral")

        // Определяем отличников, хорошистов и тех кому не хватило 1 оценки до хорошиста
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
                    Log.d(
                        "Excellent student",
                        "${nameStudent(markIt.key, students)} marks=${marksStudents[markIt.key]}"
                    )
                }
                good == disciplines.size -> {
                    Log.i(
                        "Good student",
                        "${nameStudent(markIt.key, students)} marks=${marksStudents[markIt.key]}"
                    )
                }
                (good + 1) == disciplines.size -> {
                    Log.wtf(
                        "Very close to be good student",
                        "${nameStudent(markIt.key, students)} marks=${marksStudents[markIt.key]}"
                    )
                }
            }
        }
    }
}

// Фунцкия определяет имя студента по Id
fun nameStudent(id: Int, students: MutableList<Student>): String {
    students.forEach {
        if (it.id == id) return it.name
    }
    return "No student"
}

// Функция определяем дисциплину по Id
fun titleDiscipline(id: Int, disciplines: MutableList<Discipline>): String {
    disciplines.forEach {
        if (it.id == id) return it.title
    }
    return "No discipline"
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
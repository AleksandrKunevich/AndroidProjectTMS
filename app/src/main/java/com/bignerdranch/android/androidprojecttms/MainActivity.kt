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

    }
}

fun main() {
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
            mark.add(Mark(Random(10).nextInt(), _student, it))
        }
    }
}

//    val discount = Discount(
//        "Project",
//        "Good project",
//        1,
//        "https://im0-tub-by.yandex.net/i?id=eaa2b044794b726227846dda9669ffe9&n=13",
//        "https://github.com/AleksandrKunevich/AndroidProjectTMS",
//        DiscountType.RangeAmount(3, 9)
//    )
//    println(discount)
//    val discount2 = discount.copy()
//    println("Сравнение (==): ${discount == discount2}")
//    discount2.discountType = DiscountType.FlatAmount(5)
//    println(discount)
//    println(discount2)
//    val discount3 = discount2.copy()
//    discount3.discountType = DiscountType.NoDiscount
//    println(discount3)
//    println(discount.discountType.calculate(5))
//    println(discount2.discountType.calculate(5))
//    println(discount3.discountType.calculate(5))

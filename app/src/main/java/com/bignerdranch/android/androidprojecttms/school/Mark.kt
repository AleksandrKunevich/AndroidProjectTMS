package com.bignerdranch.android.androidprojecttms.school

class Mark(val value: Int, student: Student, discipline: Discipline) {
    val studentId = student.id
    val disciplineId = discipline.id
}
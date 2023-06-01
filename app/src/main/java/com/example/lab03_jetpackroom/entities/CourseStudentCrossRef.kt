package com.example.lab03_jetpackroom.entities

import androidx.room.Entity

@Entity (primaryKeys = ["courseId", "studentId"])
data class CourseStudentCrossRef (
    val courseId: Int,
    val studentId: Int
)
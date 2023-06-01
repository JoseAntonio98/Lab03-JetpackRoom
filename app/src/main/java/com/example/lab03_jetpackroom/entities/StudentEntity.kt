package com.example.lab03_jetpackroom.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "students")
data class StudentEntity (
    @PrimaryKey()
    @ColumnInfo(name = "studentId")
    var studentId: Int,
    @ColumnInfo(name = "studentName")
    var name: String,
    @ColumnInfo(name = "studentLastName")
    var lastname: String,
)
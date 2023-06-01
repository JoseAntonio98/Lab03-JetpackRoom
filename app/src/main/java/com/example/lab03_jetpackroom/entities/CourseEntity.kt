package com.example.lab03_jetpackroom.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "courses")
class CourseEntity {
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "courseId")
    var courseId: Int = 0
    @ColumnInfo(name = "courseName")
    var name: String = ""

    constructor( name: String ) {
        this.name = name
    }
}
package com.example.lab03_jetpackroom.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab03_jetpackroom.entities.StudentEntity
import com.example.lab03_jetpackroom.entities.CourseEntity
import com.example.lab03_jetpackroom.entities.CourseStudentCrossRef

@Database (
    entities = [StudentEntity::class, CourseEntity::class, CourseStudentCrossRef::class],
    version = 4
)
abstract class AppDataBase : RoomDatabase () {
    abstract fun studentDao () : StudentDao
    abstract fun courseDao () : CourseDao
    abstract fun courseWithStudentsDao () : CourseWithStudentsDao

}
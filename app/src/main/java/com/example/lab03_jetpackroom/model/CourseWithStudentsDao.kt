package com.example.lab03_jetpackroom.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.lab03_jetpackroom.entities.CourseStudentCrossRef
import com.example.lab03_jetpackroom.entities.CourseWithStudents

@Dao
interface CourseWithStudentsDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourseStudentsCrossRef (crossRef: CourseStudentCrossRef)

    @Transaction
    @Query ("select * from courses")
    fun getAllStudentsofCourse () : List<CourseWithStudents>
}
package com.example.lab03_jetpackroom.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lab03_jetpackroom.entities.CourseEntity

@Dao
interface CourseDao {
    @Insert
    suspend fun insert (course: CourseEntity)
}
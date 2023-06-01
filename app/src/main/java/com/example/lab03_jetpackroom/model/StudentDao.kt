package com.example.lab03_jetpackroom.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lab03_jetpackroom.entities.StudentEntity

@Dao
interface StudentDao {

    @Insert
    suspend fun insertAll (students: List<StudentEntity>)

}
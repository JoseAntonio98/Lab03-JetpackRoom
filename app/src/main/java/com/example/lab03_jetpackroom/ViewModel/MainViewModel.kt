package com.example.lab03_jetpackroom.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lab03_jetpackroom.entities.CourseEntity
import com.example.lab03_jetpackroom.entities.CourseStudentCrossRef
import com.example.lab03_jetpackroom.entities.CourseWithStudents
import com.example.lab03_jetpackroom.entities.StudentEntity
import com.example.lab03_jetpackroom.model.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    fun insertAllStudents (students: List<StudentEntity>){
        repository.insertAllStudents(students)
    }

    fun insertCourse (course : CourseEntity) {
        repository.insertCourse(course)
    }

    fun insertCourseStudentsCrossRef (crossRef: CourseStudentCrossRef) {
        repository.insertCourseStudentsCrossRef(crossRef)

    }

    fun getAllStudentsofCourse ()  {
        repository.getAllStudentsofCourse()
    }

    val allStudents: LiveData<List<CourseWithStudents>> = repository.allStudents
}
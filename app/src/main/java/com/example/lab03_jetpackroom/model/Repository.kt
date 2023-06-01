package com.example.lab03_jetpackroom.model

import androidx.lifecycle.MutableLiveData
import com.example.lab03_jetpackroom.entities.CourseEntity
import com.example.lab03_jetpackroom.entities.CourseStudentCrossRef
import com.example.lab03_jetpackroom.entities.CourseWithStudents
import com.example.lab03_jetpackroom.entities.StudentEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository (
    private val studentDao : StudentDao,
    private val courseDao : CourseDao,
    private val courseWithStudentsDao : CourseWithStudentsDao
) {

    val allStudents = MutableLiveData<List<CourseWithStudents>>()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertAllStudents (students: List<StudentEntity>){
        coroutineScope.launch(Dispatchers.IO) {
            studentDao.insertAll(students)
        }
    }

    fun insertCourse (course : CourseEntity) {
        coroutineScope.launch(Dispatchers.IO) {
            courseDao.insert(course)
        }
    }

    fun insertCourseStudentsCrossRef (crossRef: CourseStudentCrossRef) {
        coroutineScope.launch(Dispatchers.IO) {
            courseWithStudentsDao.insertCourseStudentsCrossRef(crossRef)
        }
    }

    fun getAllStudentsofCourse ()  {
        coroutineScope.launch(Dispatchers.IO) {
            allStudents.postValue(courseWithStudentsDao.getAllStudentsofCourse())
        }
    }
}
package com.example.lab03_jetpackroom.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab03_jetpackroom.ViewModel.MainViewModel
import com.example.lab03_jetpackroom.entities.CourseWithStudents
import com.example.lab03_jetpackroom.ui.theme.PrimaryColor
import com.example.lab03_jetpackroom.ui.theme.SecondaryColor

@Composable
fun ViewList (
    viewModel: MainViewModel
){
    //val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
       viewModel.getAllStudentsofCourse()
    }

    val listCourseWithStudents : List<CourseWithStudents> by viewModel.allStudents.observeAsState(initial = listOf())

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(14.dp, 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth()
        ) {
            Text(
                fontSize = 24.sp,
                color = PrimaryColor,
                text = "List of Courses with Students",
                modifier = Modifier.weight(1f)
            )
        }

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .fillMaxSize()
                .background(SecondaryColor)
                .padding(8.dp, 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (listCourseWithStudents.isEmpty()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "No courses registered yet",
                        color = PrimaryColor,
                        fontSize = 18.sp)
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(all = 4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listCourseWithStudents) {
                    Card(courseWithStudents = it)
                }
            }
        }
    }

}

@Composable
fun Card (courseWithStudents: CourseWithStudents) {
    Row (
      modifier = Modifier
          .clip(RoundedCornerShape(16.dp))
          .background(color = Color(245, 245, 245))
          .padding(12.dp, 8.dp)
          .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = courseWithStudents.course.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = PrimaryColor
            )
            courseWithStudents.students.forEach {
                Column() {
                    Row {
                        Text(text = "Student ${it.studentId}")
                        Text(text = it.name)
                        Text(text = it.lastname)
                    }
                }
            }
        }
    }
}
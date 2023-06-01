package com.example.lab03_jetpackroom.model

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideAppDatabase(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context,
        AppDataBase::class.java,
        "appDatabase").build()

    @Provides
    fun provideStudentDao(
        appDb: AppDataBase
    ) = appDb.studentDao()

    @Provides
    fun provideCourseDao(
        appDb: AppDataBase
    ) = appDb.courseDao()

    @Provides
    fun provideCourseWithStudentsDao(
        appDb: AppDataBase
    ) = appDb.courseWithStudentsDao()

    @Provides
    fun provideAppRepository(
        studentDao: StudentDao,
        courseDao: CourseDao,
        courseWithStudentsDao: CourseWithStudentsDao
    ) : Repository = Repository(studentDao, courseDao, courseWithStudentsDao)
}
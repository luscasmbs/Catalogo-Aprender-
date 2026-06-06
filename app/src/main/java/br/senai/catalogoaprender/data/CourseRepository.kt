package br.senai.catalogoaprender.data

import androidx.compose.runtime.mutableStateListOf
import br.senai.catalogoaprender.model.DataCourse

object CourseRepository {
    val courses = mutableStateListOf<DataCourse>()

    fun addCourse(course: DataCourse) {
        courses.add(course)
    }

    fun clearCourses() {
        courses.clear()
    }
}
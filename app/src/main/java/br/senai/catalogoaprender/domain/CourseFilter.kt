package br.senai.catalogoaprender.domain

import br.senai.catalogoaprender.model.Category
import br.senai.catalogoaprender.model.DataCourse

fun filterCourses(
    courses: List<DataCourse>,
    searchText: String,
    selectedCategory: Category?
): List<DataCourse> {
    return courses.filter { course ->
        val matchesSearch =
            searchText.isBlank() ||
                    course.completename.contains(searchText, ignoreCase = true) ||
                    course.shortname.contains(searchText, ignoreCase = true) ||
                    course.shortdescription.contains(searchText, ignoreCase = true) ||
                    course.longdescription.contains(searchText, ignoreCase = true) ||
                    course.type.displayname.contains(searchText, ignoreCase = true) ||
                    course.level.name.contains(searchText, ignoreCase = true) ||
                    course.availability.displayname.contains(searchText, ignoreCase = true)

        val matchesCategory =
            selectedCategory == null || course.type == selectedCategory

        matchesSearch && matchesCategory
    }
}
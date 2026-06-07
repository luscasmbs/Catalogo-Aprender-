package br.senai.catalogoaprender.navigation

object AppRoutes {
    const val CATALOG = "Catalog"
    const val COURSE_REGISTER = "CourseRegister"
    const val DETAILS = "Details/{courseId}"

    fun detailsRoute(courseId: Int): String {
        return "Details/$courseId"
    }
}
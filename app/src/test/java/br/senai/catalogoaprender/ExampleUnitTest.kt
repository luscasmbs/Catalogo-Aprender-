package br.senai.catalogoaprender

import br.senai.catalogoaprender.data.CourseRepository
import br.senai.catalogoaprender.domain.filterCourses
import br.senai.catalogoaprender.model.Category
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun listaInicialTemDozeCursos() {
        val cursos = CourseRepository.courses

        assertEquals(12, cursos.size)
    }

    @Test
    fun buscaVaziaRetornaTodosOsCursos() {
        val resultado = filterCourses(
            courses = CourseRepository.courses,
            searchText = "",
            selectedCategory = null
        )

        assertEquals(12, resultado.size)
    }

    @Test
    fun buscaPorNomeRetornaCursoCorreto() {
        val resultado = filterCourses(
            courses = CourseRepository.courses,
            searchText = "Android",
            selectedCategory = null
        )

        assertTrue(resultado.isNotEmpty())
        assertTrue(
            resultado.any { course ->
                course.completename.contains("Android", ignoreCase = true) ||
                        course.shortname.contains("Android", ignoreCase = true) ||
                        course.type.displayname.contains("Android", ignoreCase = true)
            }
        )
    }

    @Test
    fun buscaPorCategoriaRetornaCursosDaCategoria() {
        val resultado = filterCourses(
            courses = CourseRepository.courses,
            searchText = "Design",
            selectedCategory = null
        )

        assertTrue(resultado.isNotEmpty())
        assertTrue(
            resultado.all { course ->
                course.type == Category.DESIGN
            }
        )
    }

    @Test
    fun filtroPorCategoriaRetornaSomenteCategoriaSelecionada() {
        val resultado = filterCourses(
            courses = CourseRepository.courses,
            searchText = "",
            selectedCategory = Category.PROGRAMACAO
        )

        assertTrue(resultado.isNotEmpty())
        assertTrue(
            resultado.all { course ->
                course.type == Category.PROGRAMACAO
            }
        )
    }

    @Test
    fun buscaInexistenteRetornaListaVazia() {
        val resultado = filterCourses(
            courses = CourseRepository.courses,
            searchText = "curso inexistente qualquer",
            selectedCategory = null
        )

        assertTrue(resultado.isEmpty())
    }

    @Test
    fun buscaEFiltroFuncionamJuntos() {
        val resultado = filterCourses(
            courses = CourseRepository.courses,
            searchText = "Kotlin",
            selectedCategory = Category.PROGRAMACAO
        )

        assertTrue(resultado.isNotEmpty())
        assertTrue(
            resultado.all { course ->
                course.type == Category.PROGRAMACAO
            }
        )
    }
}

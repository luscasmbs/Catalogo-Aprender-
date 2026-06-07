package br.senai.catalogoaprender

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import br.senai.catalogoaprender.data.CourseRepository
import br.senai.catalogoaprender.domain.filterCourses
import br.senai.catalogoaprender.model.Category
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        assertEquals("br.senai.catalogoaprender", appContext.packageName)
    }

    @Test
    fun repositoryPossuiCursosLocais() {
        val cursos = CourseRepository.courses

        assertTrue(cursos.isNotEmpty())
        assertEquals(12, cursos.size)
    }

    @Test
    fun buscaAndroidRetornaResultado() {
        val resultado = filterCourses(
            courses = CourseRepository.courses,
            searchText = "Android",
            selectedCategory = null
        )

        assertTrue(resultado.isNotEmpty())
    }

    @Test
    fun filtroProgramacaoRetornaSomenteProgramacao() {
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
    fun buscaInexistenteRetornaVazio() {
        val resultado = filterCourses(
            courses = CourseRepository.courses,
            searchText = "texto que nao existe no catalogo",
            selectedCategory = null
        )

        assertTrue(resultado.isEmpty())
    }
}
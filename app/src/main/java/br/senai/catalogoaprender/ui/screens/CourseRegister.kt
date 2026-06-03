package br.senai.catalogoaprender.ui.screens

import ValidationCourseResult
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.model.Availability
import br.senai.catalogoaprender.model.Category
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.model.Level

import br.senai.catalogoaprender.ui.components.RegisterComponents.CourseFormSection
import br.senai.catalogoaprender.ui.components.RegisterComponents.CoursePreviewCard
import br.senai.catalogoaprender.ui.components.RegisterComponents.CursoViewHeader
import br.senai.catalogoaprender.ui.components.RegisterComponents.FormActions
import br.senai.catalogoaprender.ui.components.RegisterComponents.StatusCard

import br.senai.catalogoaprender.ui.theme.CatalogoAprenderTheme

private fun emptyCourse() = DataCourse(
    id = 0,
    completename = "",
    shortname = "",
    type = Category.VAZIO,
    level = Level.VAZIO,
    worktime = 0,
    shortdescription = "",
    longdescription = "",
    availability = Availability.VAZIO,
    percentageprogress = 0.0
)

@Composable
fun CadastroCursos(modifier: Modifier = Modifier) {
    var course by remember { mutableStateOf(emptyCourse()) }
    var statusMessage by remember {
        mutableStateOf("Preencha os dados para gerar a visualização do curso.")
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { }) {
                        Text(
                            "Home"
                        )
                    }
                    IconButton(onClick = { /* Handle Edit */ }) {
                        Text("Edit")
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { /* Handle FAB */ }) {
                    }
                }
            )
        }

    ){ innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            CursoViewHeader()
            CourseFormSection(
                course = course,
                onid = { course = course.copy(id = it) },
                oncompletename = { course = course.copy(completename = it) },
                onshortname = { course = course.copy(shortname = it) },
                ontype = { course = course.copy(type = Category.valueOf(it)) },
                onLevel = { course = course.copy(level = Level.valueOf(it)) },
                onworktime = { course = course.copy(worktime = it) },
                onshortdescription = { course = course.copy(shortdescription = it) },
                onlongdescription = { course = course.copy(longdescription = it) },
                onavailability = { course = course.copy(availability = Availability.valueOf(it)) },
                onpercentageprogress = { course = course.copy(percentageprogress = it) }
            )
            CoursePreviewCard(course = course)
            StatusCard(mensage = statusMessage)
            FormActions(
                onClickClear = {
                    course = emptyCourse()
                    statusMessage = "Formulário limpo."
                },
                onValidatorClick = {
                    val result = ValidationCourseResult(course)
                    statusMessage = result.message
                },
                onLoadExampleClick = {
                    course = DataCourse.examplemodel()
                    statusMessage = "Exemplo carregado para análise."
                }
            )
            Spacer(
                modifier = Modifier
                    .height(24.dp)
                    .navigationBarsPadding()
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenPreview() {
    CatalogoAprenderTheme {
        CadastroCursos()
    }
}
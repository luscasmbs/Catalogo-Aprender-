package br.senai.catalogoaprender.ui.screens

import ValidationCourseResult
import android.R.id.message
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.senai.catalogoaprender.model.Availability
import br.senai.catalogoaprender.model.Category
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.model.LevelEnum
import br.senai.catalogoaprender.ui.components.RegisterComponents.CoursePreviewCard
import br.senai.catalogoaprender.ui.components.RegisterComponents.CourseTextField
import br.senai.catalogoaprender.ui.components.RegisterComponents.CursoViewHeader
import br.senai.catalogoaprender.ui.components.RegisterComponents.FormActions
import br.senai.catalogoaprender.ui.components.RegisterComponents.StatusCard
import br.senai.catalogoaprender.R.drawable.registerico
import br.senai.catalogoaprender.R.drawable.unmarkmainlogo
import br.senai.catalogoaprender.data.CourseRepository


private fun emptyCourse() = DataCourse(
    id = 0,
    completename = "",
    shortname = "",
    type = Category.VAZIO,
    level = LevelEnum.VAZIO,
    worktime = 0,
    shortdescription = "",
    longdescription = "",
    availability = Availability.VAZIO,
    percentageprogress = 0.0
)

@Composable
fun CadastroCursos(navController: NavController, modifier: Modifier = Modifier) {
    var course by remember { mutableStateOf(emptyCourse()) }
    var statusMessage by remember {
        mutableStateOf("Preencha os dados para gerar a visualização do curso.")
    }


    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(80.dp),
                    containerColor = Color(0xFFffffff),
                actions = {
                    Column(
                        modifier = Modifier
                            .padding(start = 70.dp),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,

                    ) {
                        Button(
                            onClick = {navController.navigate("Catalog")},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFffffff)
                            ),
                            modifier = Modifier
                                .width(70.dp)
                                .height(40.dp)
                        ) {
                        Image(
                            painter = painterResource(id = unmarkmainlogo),
                            contentDescription = "Icone desmarcado da tela de inicio"
                        )
                        }
                        Text(
                            text = "Inicio",
                            color = Color(0xFFb4b0aa)
                        )
                    }
                    Column(
                        modifier = Modifier.padding(start = 100.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF1E3352)
                            ),
                            modifier = Modifier
                                .width(70.dp)
                                .height(40.dp)
                        ) {
                            Image(
                                painter = painterResource(id = registerico),
                                contentDescription = "Icone do botão de cadastro",
                                modifier = Modifier
                            )
                        }
                        Text(
                            "Cadastrar",
                            color = Color(0xFF1E3352)

                        )
                    }


                },

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
            CourseTextField(
                course = course,
                oncompletename = { course = course.copy(completename = it) },
                onshortname = { course = course.copy(shortname = it) },
                ontype = { course = course.copy(type = Category.valueOf(it)) },
                onLevel = { course = course.copy(level = LevelEnum.valueOf(it)) },
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
                    course = DataCourse(
                        id = 0,
                        completename = "",
                        shortname = "",
                        type = Category.VAZIO,
                        level = LevelEnum.VAZIO,
                        worktime = 0,
                        shortdescription = "",
                        longdescription = "",
                        availability = Availability.VAZIO,
                        percentageprogress = 0.0
                    )
                },
                onValidatorClick = {
                    val result = ValidationCourseResult(course)

                    statusMessage = result.message


                    if (result.valid) {
                        val newCourse = course.copy(
                            id = CourseRepository.courses.size + 1
                        )

                        CourseRepository.addCourse(newCourse)

                        navController.navigate("Catalog")
                    }
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
    CadastroCursos(navController = rememberNavController())
}
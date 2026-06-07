package br.senai.catalogoaprender.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.senai.catalogoaprender.R.drawable.mainlogo
import br.senai.catalogoaprender.R.drawable.unmarkregisterlogo
import br.senai.catalogoaprender.data.CourseRepository
import br.senai.catalogoaprender.domain.filterCourses
import br.senai.catalogoaprender.model.Category
import br.senai.catalogoaprender.ui.components.CatalogComponents.BarSearch
import br.senai.catalogoaprender.ui.components.CatalogComponents.CourseCard
import br.senai.catalogoaprender.ui.components.CatalogComponents.SearchHeader
import br.senai.catalogoaprender.ui.theme.Blue30
import br.senai.catalogoaprender.ui.theme.White10

@Composable
fun CatalogScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var searchText by rememberSaveable { mutableStateOf("") }
    var selectedCategory by rememberSaveable { mutableStateOf<Category?>(null) }
    var selectedCourseId by rememberSaveable { mutableStateOf<Int?>(null) }

    val courses = CourseRepository.courses

    val categoriesWithCourses = courses
        .map { course -> course.type }
        .filter { category -> category != Category.VAZIO }
        .distinct()

    val courseFilter = filterCourses(
        courses = courses,
        searchText = searchText,
        selectedCategory = selectedCategory
    )

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(80.dp),
                containerColor = Color.White,
                actions = {
                    Column(
                        modifier = Modifier.padding(start = 70.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Blue30
                            ),
                            modifier = Modifier
                                .width(70.dp)
                                .height(40.dp)
                        ) {
                            Image(
                                painter = painterResource(id = mainlogo),
                                contentDescription = "Ícone da tela de início"
                            )
                        }

                        Text(
                            text = "Início",
                            color = Blue30
                        )
                    }

                    Column(
                        modifier = Modifier.padding(start = 100.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {
                                navController.navigate("CourseRegister")
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White
                            ),
                            modifier = Modifier
                                .width(70.dp)
                                .height(40.dp)
                        ) {
                            Image(
                                painter = painterResource(id = unmarkregisterlogo),
                                contentDescription = "Ícone do botão de cadastro"
                            )
                        }

                        Text(
                            text = "Cadastrar",
                            color = Color(0xFFB4B0AA)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(White10)
        ) {
            SearchHeader()

            BarSearch(
                value = searchText,
                onValueChange = { text ->
                    searchText = text
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = selectedCategory == null,
                    onClick = {
                        selectedCategory = null
                    },
                    label = {
                        Text(text = "Todos")
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Blue30,
                        selectedLabelColor = Color.White,
                        containerColor = Color.White,
                        labelColor = Blue30
                    )
                )

                categoriesWithCourses.forEach { category ->
                    FilterChip(
                        selected = selectedCategory == category,
                        onClick = {
                            selectedCategory = category
                        },
                        label = {
                            Text(text = category.displayname)
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Blue30,
                            selectedLabelColor = Color.White,
                            containerColor = Color.White,
                            labelColor = Blue30
                        )
                    )
                }
            }

            if (courseFilter.isEmpty()) {
                Text(
                    text = "Nenhum curso encontrado",
                    color = Blue30,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp)
                )

                Text(
                    text = "Ajuste a busca ou altere o filtro selecionado.",
                    color = Blue30,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            } else {
                Text(
                    text = "Cursos exibidos: ${courseFilter.size}",
                    color = Blue30,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                LazyColumn {
                    items(
                        items = courseFilter,
                        key = { course -> course.id }
                    ) { course ->
                        CourseCard(
                            course = course,
                            select = selectedCourseId == course.id,
                            onclick = {
                                selectedCourseId = course.id
                                navController.navigate("Details/${course.id}")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun CatalogScreenView() {
    CatalogScreen(navController = rememberNavController())
}
package br.senai.catalogoaprender.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import br.senai.catalogoaprender.ui.components.CatalogComponents.BarSearch
import br.senai.catalogoaprender.ui.components.CatalogComponents.SearchHeader

@Composable
fun CatalogScreen(navController: NavController, modifier: Modifier = Modifier) {
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
                            onClick = {

                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF1E3352)
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
                            color = Color(0xFF1E3352)
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
                .background(Color(0xFFF5F2EE))
        ) {
            SearchHeader()

            BarSearch()



            {
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
private fun CatalogScreenView() {
    CatalogScreen(navController = rememberNavController())
}
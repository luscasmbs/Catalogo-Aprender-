package br.senai.catalogoaprender.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.R.drawable.registerico
import br.senai.catalogoaprender.R.drawable.unmarkmainlogo
import br.senai.catalogoaprender.ui.components.BarSearch
import br.senai.catalogoaprender.ui.components.SearchHeader

@Composable
fun CatalogScreen(modifier: Modifier = Modifier){
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
                            onClick = {},
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
    ){

        innerPadding ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .background(Color(0xFF0d1b2a))
        ){
            SearchHeader()
            BarSearch()
            Spacer(modifier = Modifier.height(20.dp))
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFf5f2ee))
                .padding(innerPadding)
        ) {

        }


    }
}

@Composable
@Preview(showBackground = true)
private fun CatalogScreenView(){
CatalogScreen()
}
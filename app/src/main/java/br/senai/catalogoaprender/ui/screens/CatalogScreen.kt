package br.senai.catalogoaprender.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.senai.catalogoaprender.ui.components.BarSearch
import br.senai.catalogoaprender.ui.components.SearchHeader

@Composable
fun CatalogScreen(modifier: Modifier = Modifier){
    Scaffold{ innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .background(Color(0xFF0d1b2a))
        ){
            SearchHeader()
            BarSearch()
        }

    }
}

@Composable
@Preview(showBackground = true)
private fun CatalogScreenView(){
CatalogScreen()
}
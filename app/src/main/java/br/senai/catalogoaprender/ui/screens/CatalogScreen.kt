package br.senai.catalogoaprender.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.ui.components.BarSearch
import br.senai.catalogoaprender.ui.components.SearchHeader

@Composable
fun CatalogScreen(modifier: Modifier = Modifier){
    Scaffold{ innerPadding ->
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
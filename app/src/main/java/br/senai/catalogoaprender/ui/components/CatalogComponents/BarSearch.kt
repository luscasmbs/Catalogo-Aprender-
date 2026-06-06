package br.senai.catalogoaprender.ui.components.CatalogComponents

    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.OutlinedTextField
    import androidx.compose.material3.OutlinedTextFieldDefaults
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import br.senai.catalogoaprender.ui.theme.Blue10
    import br.senai.catalogoaprender.ui.theme.Blue30
    import br.senai.catalogoaprender.ui.theme.LightBlue
    import br.senai.catalogoaprender.ui.theme.Orange10

@Composable
    fun BarSearch(
        modifier: Modifier = Modifier,
        onSearchText: (String) -> Unit = {}
    ){
        var busca by remember { mutableStateOf("") }

        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Blue10),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = busca,
                onValueChange = { searchTex ->
                    busca = searchTex
                    onSearchText(searchTex)
                }  ,
                shape = RoundedCornerShape(10.dp),
                modifier = modifier
                    .fillMaxWidth(0.9f),
                label ={
                    Text(text = "Busca", color = LightBlue)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Blue30,
                    focusedBorderColor = Orange10,
                    unfocusedContainerColor = Blue30,
                    focusedContainerColor = Blue30,
                    focusedTextColor = LightBlue,
                    unfocusedTextColor = LightBlue
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
        }


    }

    @Composable
    @Preview(showBackground = true)
    private fun BarSearchView() {
        BarSearch()
    }
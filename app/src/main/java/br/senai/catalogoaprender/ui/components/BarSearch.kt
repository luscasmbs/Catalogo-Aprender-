    package br.senai.catalogoaprender.ui.components

    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.width
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

    @Composable
    fun BarSearch(
        modifier: Modifier = Modifier,
        onSearchTex: (String) -> Unit = {}
    ){
        var busca by remember { mutableStateOf("") }

        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0d1b2a)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = busca,
                onValueChange = { searchTex ->
                    busca = searchTex
                    onSearchTex(searchTex)
                }  ,
                shape = RoundedCornerShape(10.dp),
                modifier = modifier
                    .fillMaxWidth(0.9f),
                label ={
                    Text(text = "Busca", color = Color(0xFF4a7fa5))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFF1e3352),
                    focusedBorderColor = Color(0xFFe27d5d),
                    unfocusedContainerColor = Color(0xFF1e3352),
                    focusedContainerColor = Color(0xFF1e3352),
                    focusedTextColor = Color(0xFF4a7fa5),
                    unfocusedTextColor = Color(0xFF4a7fa5)
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
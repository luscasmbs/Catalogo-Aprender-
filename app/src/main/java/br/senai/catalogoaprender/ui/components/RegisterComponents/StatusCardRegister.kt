package br.senai.catalogoaprender.ui.components.RegisterComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.ui.theme.CatalogoAprenderTheme

@Composable
fun StatusCard(
    mensage: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
        border = BorderStroke(1.5.dp, Color(0xFFF1835E))
    ) {
        Text(
            text = mensage,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF6B635A),
            modifier = Modifier.padding(14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StatusCardPreview() {
    CatalogoAprenderTheme {
        StatusCard(mensage = "Preencha os dados para gerar a visualização do curso.")
    }
}
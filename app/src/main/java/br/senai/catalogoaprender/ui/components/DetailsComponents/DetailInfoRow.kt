package br.senai.catalogoaprender.ui.components.DetailsComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.ui.theme.Blue10
import br.senai.catalogoaprender.ui.theme.Gray20

@Composable
fun DetailInfoRow(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = Blue10
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = Gray20
        )
    }
}
package br.senai.catalogoaprender.ui.components.DetailsComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.ui.theme.Blue10
import br.senai.catalogoaprender.ui.theme.Gray60
import br.senai.catalogoaprender.ui.theme.LightBlue

@Composable
fun DetailsProgress(
    progress: Double,
    modifier: Modifier = Modifier
) {
    val progressFloat = progress.toFloat().coerceIn(0f, 1f)
    val percent = (progressFloat * 100).toInt()

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Progresso",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Blue10
            )

            Text(
                text = "$percent%",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Blue10
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LinearProgressIndicator(
            progress = { progressFloat },
            modifier = Modifier.fillMaxWidth(),
            color = LightBlue,
            trackColor = Gray60
        )
    }
}
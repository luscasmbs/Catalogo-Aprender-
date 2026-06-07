package br.senai.catalogoaprender.ui.components.DetailsComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.ui.theme.Blue10
import br.senai.catalogoaprender.ui.theme.Gray40
import br.senai.catalogoaprender.ui.theme.Gray60
import br.senai.catalogoaprender.ui.theme.White

@Composable
fun DetailsNotFoundCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 20.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        border = BorderStroke(0.5.dp, Gray60)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Curso não encontrado",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Blue10
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Não foi possível encontrar um curso com esse identificador.",
                style = MaterialTheme.typography.bodyMedium,
                color = Gray40
            )
        }
    }
}
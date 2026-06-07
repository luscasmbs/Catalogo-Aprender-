package br.senai.catalogoaprender.ui.components.DetailsComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.ui.theme.Blue30
import br.senai.catalogoaprender.ui.theme.White

@Composable
fun DetailsBackButton(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onBackClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 20.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue30,
            contentColor = White
        )
    ) {
        Text(
            text = "Voltar",
            fontWeight = FontWeight.Bold
        )
    }
}
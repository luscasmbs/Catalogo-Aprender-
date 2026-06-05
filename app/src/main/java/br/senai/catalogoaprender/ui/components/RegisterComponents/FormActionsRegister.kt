package br.senai.catalogoaprender.ui.components.RegisterComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.ui.theme.Blue30
import br.senai.catalogoaprender.ui.theme.Blue60
import br.senai.catalogoaprender.ui.theme.CatalogoAprenderTheme
import br.senai.catalogoaprender.ui.theme.Green20
import br.senai.catalogoaprender.ui.theme.Green50
import br.senai.catalogoaprender.ui.theme.Orange30
import br.senai.catalogoaprender.ui.theme.White

@Composable
fun FormActions(
    onClickClear: () -> Unit,
    onValidatorClick: () -> Unit,
    onLoadExampleClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = onClickClear,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue30,
                    contentColor = Blue60
                )
            ) {
                Text(text = "Limpar")
            }
            Button(
                onClick = onValidatorClick,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange30,
                    contentColor = White
                )
            ) {
                Text(text = "Cadastrar")
            }
        }

        Button(
            onClick = onLoadExampleClick,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Green50,
                contentColor = Green20
            )
        ) {
            Text(text = "Carregar exemplo")
        }
    }
}

@Preview
@Composable
private fun FormActionsPreview() {
    CatalogoAprenderTheme {
        FormActions(
            onClickClear = {},
            onValidatorClick = {},
            onLoadExampleClick = {}
        )
    }
}
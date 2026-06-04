package br.senai.catalogoaprender.ui.components.RegisterComponents


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.catalogoaprender.R.drawable.logo

@Composable
fun CursoViewHeader(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(174.dp)
                .background(Color(0xFF0d1b2a))
        ) {
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = logo),
                    contentDescription = "Logo do app",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                Text(
                    text = "APRENDER+",
                    modifier = Modifier.padding(start = 12.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(0xFF5cacd0),
                    fontSize = 13.sp
                )
            }

            Text(
                text = "Cadastro Aprender+",
                modifier = Modifier
                    .padding(top = 84.dp)
                    .padding(start = 12.dp),
                color = Color(0xFFF4F5F0),
                style = MaterialTheme.typography.labelSmall,
                fontSize = 23.sp
            )

            Text(
                text = "Monte a apresentação inicial de um curso técnico.",
                modifier = Modifier
                    .padding(top = 119.dp)
                    .padding(start = 12.dp),
                color = Color(0xFF5cacd0),
                style = MaterialTheme.typography.labelSmall,
                fontSize = 13.sp
            )
        }
    }
}

@Preview
@Composable
private fun HeaderPreview() {
        CursoViewHeader()

}

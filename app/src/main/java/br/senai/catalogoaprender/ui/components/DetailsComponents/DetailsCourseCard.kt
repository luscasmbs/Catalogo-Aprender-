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
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.ui.theme.Blue10
import br.senai.catalogoaprender.ui.theme.Blue30
import br.senai.catalogoaprender.ui.theme.Gray20
import br.senai.catalogoaprender.ui.theme.Gray60
import br.senai.catalogoaprender.ui.theme.Orange20
import br.senai.catalogoaprender.ui.theme.White

@Composable
fun DetailsCourseCard(
    course: DataCourse,
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
                text = "INFORMAÇÕES DO CURSO",
                style = MaterialTheme.typography.labelSmall,
                color = Orange20
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = course.completename,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Blue10
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = course.shortname,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = Blue30
            )

            Spacer(modifier = Modifier.height(16.dp))

            DetailInfoRow("Categoria", course.type.displayname)
            DetailInfoRow("Nível", course.level.name)
            DetailInfoRow("Carga horária", "${course.worktime}h")
            DetailInfoRow("Status", course.availability.displayname)

            Spacer(modifier = Modifier.height(16.dp))

            DetailsProgress(progress = course.percentageprogress)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Descrição completa",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Blue10
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = course.longdescription,
                style = MaterialTheme.typography.bodyMedium,
                color = Gray20
            )
        }
    }
}
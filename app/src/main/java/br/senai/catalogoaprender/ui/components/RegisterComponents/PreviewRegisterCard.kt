package br.senai.catalogoaprender.ui.components.RegisterComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.ui.theme.CatalogoAprenderTheme

@Composable
fun CoursePreviewCard(
    course: DataCourse,
    modifier: Modifier = Modifier
) {
    val completename = course.completename.ifBlank { "Nome completo não informado" }
    val shortname = course.shortname.ifBlank { "Nome breve não informado" }
    val type = course.type.name.ifBlank { "Categoria pendente" }
    val level = course.level.name.ifBlank { "Nível pendente" }
    val worktime = if (course.worktime <= 0) "Carga horária pendente" else "${course.worktime}hrs"
    val shortdescription = course.shortdescription.ifBlank { "Descrição ainda não preenchida" }
    val availability = course.availability.name.ifBlank { "Disponibilidade pendente" }
    val progress = "${(course.percentageprogress * 100).toInt()}%"

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0D1B2A)),
        border = BorderStroke(0.5.dp, Color(0xFF7E8897))
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Pré-visualização do curso",
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFFF1835E),
                fontSize = 13.sp,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Text(
                text = shortname,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF0EDE8)
            )

            Text(
                text = completename,
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF304C61),
                modifier = Modifier.padding(top = 2.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Linha 1: Categoria + Nível
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                InfoChip(text = type, modifier = Modifier.weight(1f))
                InfoChip(text = level, modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Linha 2: Carga Horária + Disponibilidade + Progresso
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                InfoChip(text = worktime, modifier = Modifier.weight(1f))
                InfoChip(text = availability, modifier = Modifier.weight(1f))
                InfoChip(text = progress, modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = shortdescription,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF6A8EA0),
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Composable
private fun InfoChip(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF1E3352))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            fontSize = 11.sp,
            color = Color(0xFF4A7FA5),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
private fun CoursePreviewCardPreview() {
    CatalogoAprenderTheme {
        CoursePreviewCard(course = DataCourse.examplemodel())
    }
}
package br.senai.catalogoaprender.ui.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.ui.components.RegisterComponents.InfoChip

@Composable
fun CourseCard(
    course: DataCourse,
    select: Boolean,
    onclick: () -> Unit,
    modifier: Modifier = Modifier
){
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
                text = course.shortname,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF0EDE8)
            )

            Text(
                text = course.completename,
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF304C61),
                modifier = Modifier.padding(top = 2.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                InfoChip(text = course.type.toString(), modifier = Modifier.weight(1f))
                InfoChip(text = course.level.toString(), modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                InfoChip(text = course.worktime.toString(), modifier = Modifier.weight(1f))
                InfoChip(text = course.availability.toString(), modifier = Modifier.weight(1f))
                InfoChip(text = course.availability.toString(), modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = course.shortdescription,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF6A8EA0),
                fontStyle = FontStyle.Italic
            )
        }
    }
}


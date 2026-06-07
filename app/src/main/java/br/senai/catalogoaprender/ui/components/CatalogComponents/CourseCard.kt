package br.senai.catalogoaprender.ui.components.CatalogComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.model.DataCourse.Companion.examplemodel
import br.senai.catalogoaprender.model.LevelEnum
import br.senai.catalogoaprender.ui.components.RegisterComponents.InfoChip
import br.senai.catalogoaprender.ui.theme.Black30
import br.senai.catalogoaprender.ui.theme.Blue10
import br.senai.catalogoaprender.ui.theme.Blue30
import br.senai.catalogoaprender.ui.theme.Blue90
import br.senai.catalogoaprender.ui.theme.Gray20
import br.senai.catalogoaprender.ui.theme.Gray30
import br.senai.catalogoaprender.ui.theme.Gray40
import br.senai.catalogoaprender.ui.theme.Gray60
import br.senai.catalogoaprender.ui.theme.LightBlue
import br.senai.catalogoaprender.ui.theme.White
import br.senai.catalogoaprender.ui.theme.White20
import br.senai.catalogoaprender.ui.theme.White100

@Composable
fun CourseCard(
    course: DataCourse,
    select: Boolean,
    onclick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .padding(horizontal = 16.dp)
            .clickable { onclick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (select) Blue10 else White
        ),
        border = BorderStroke(
            width = if (select) 1.5.dp else 0.5.dp,
            color = if (select) White20 else Gray20
        )
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (select) Blue30 else Blue90)
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = course.type.displayname,
                        fontSize = 11.sp,
                        color = LightBlue,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Text(
                    text = "${course.worktime}h",
                    fontSize = 11.sp,
                    color = if (select) Gray30 else Gray40,
                    maxLines = 1
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = course.shortname,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = if (select) White100 else Black30,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = course.completename,
                style = MaterialTheme.typography.labelSmall,
                color = if (select) Gray30 else Gray40,
                modifier = Modifier.padding(top = 2.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                InfoChip(
                    text = course.level.displayName()
                )

                InfoChip(
                    text = course.availability.displayname
                )

                Spacer(modifier = Modifier.weight(1f))

                LinearProgressIndicator(
                    progress = { course.percentageprogress.toFloat() },
                    modifier = Modifier
                        .width(80.dp)
                        .padding(top = 8.dp),
                    color = LightBlue,
                    trackColor = if (select) Blue30 else Gray60
                )

                Text(
                    text = "${(course.percentageprogress * 100).toInt()}%",
                    color = if (select) Gray30 else Gray40,
                    fontSize = 12.sp
                )
            }
        }
    }
}

private fun LevelEnum.displayName(): String {
    return when (this) {
        LevelEnum.BASICO -> "Básico"
        LevelEnum.INTERMEDIARIO -> "Intermediário"
        LevelEnum.AVANCACO -> "Avançado"
        LevelEnum.VAZIO -> "Vazio"
    }
}

@Preview
@Composable
private fun CourseCardPreview() {
    CourseCard(
        course = examplemodel(),
        select = true,
        onclick = {}
    )
}
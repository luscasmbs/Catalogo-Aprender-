package br.senai.catalogoaprender.ui.components.CatalogComponents


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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.model.DataCourse.Companion.examplemodel
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
import kotlinx.coroutines.selects.select

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
        colors = CardDefaults.cardColors(containerColor = White),
        border = BorderStroke(0.5.dp, Gray20)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp)
        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Blue90)
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(
                    text = course.type.toString(),
                    fontSize = 11.sp,
                    color = LightBlue,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Text(
                text = ("${course.worktime.toString()}h"),
                fontSize = 11.sp,
                color = Gray40,
                maxLines = 1,
            )

        }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = course.shortname,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Black30
            )

            Text(
                text = course.completename,
                style = MaterialTheme.typography.labelSmall,
                color = Gray40,
                modifier = Modifier.padding(top = 2.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                InfoChip(
                    text = course.type.toString()
                )

                InfoChip(
                    text = course.level.toString()
                )

                Spacer(modifier = Modifier.weight(1f))

                LinearProgressIndicator(
                    progress = { course.percentageprogress.toFloat() },
                    modifier = Modifier
                        .width(80.dp)
                        .padding(top = 8.dp),
                    color = LightBlue,
                    trackColor = Gray60

                )

                Text(
                    text = "${(course.percentageprogress*100).toInt()}%",
                    color = Gray40,
                    fontSize = 12.sp,

                )
            }



        }
    }
}

@Preview
@Composable
private fun CourseCardPreview(){
    CourseCard(
        course = examplemodel(),
        select = false,
        onclick = {}

    )
}
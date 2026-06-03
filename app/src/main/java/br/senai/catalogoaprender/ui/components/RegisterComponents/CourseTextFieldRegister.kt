package br.senai.catalogoaprender.ui.components.RegisterComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.catalogoaprender.model.Availability
import br.senai.catalogoaprender.model.Category
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.model.Level
import br.senai.catalogoaprender.ui.theme.CatalogoAprenderTheme

@Composable
fun CourseTextField(
    course: DataCourse,
    oncompletename: (String) -> Unit,
    onshortname: (String) -> Unit,
    ontype: (String) -> Unit,
    onLevel: (String) -> Unit,
    onworktime: (Int) -> Unit,
    onshortdescription: (String) -> Unit,
    onlongdescription: (String) -> Unit,
    onavailability: (String) -> Unit,
    onpercentageprogress: (Double) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .padding(horizontal = 16.dp)
            .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(16.dp))
            .border(0.5.dp, Color(0xFFE8E4DF), shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {
        Text(
            text = "DADOS DO CURSO",
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xFFC5C1BC),
            fontSize = 13.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            value = course.completename,
            onValueChange = oncompletename,
            placeholder = { Text("Nome completo do curso", color = Color(0xFF9E9890)) },
            singleLine = true,
            colors = courseTextFieldColors(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            value = course.shortname,
            onValueChange = onshortname,
            placeholder = { Text("Nome breve", color = Color(0xFF9E9890)) },
            singleLine = true,
            colors = courseTextFieldColors(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            if (maxWidth < 360.dp) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    CategoryField(course.type.name, ontype, Modifier.fillMaxWidth())
                    LevelField(course.level.name, onLevel, Modifier.fillMaxWidth())
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CategoryField(course.type.name, ontype, Modifier.weight(1f))
                    LevelField(course.level.name, onLevel, Modifier.weight(1f))
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            if (maxWidth < 360.dp) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    WorktimeField(course.worktime.toString(), { it.toIntOrNull()?.let(onworktime) }, Modifier.fillMaxWidth())
                    AvailabilityField(course.availability.name, onavailability, Modifier.fillMaxWidth())
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    WorktimeField(course.worktime.toString(), { it.toIntOrNull()?.let(onworktime) }, Modifier.weight(1f))
                    AvailabilityField(course.availability.name, onavailability, Modifier.weight(1f))
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            value = course.shortdescription,
            onValueChange = onshortdescription,
            placeholder = { Text("Descrição curta (máx. 120 caracteres)", color = Color(0xFF9E9890)) },
            maxLines = 3,
            colors = courseTextFieldColors(),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            value = course.longdescription,
            onValueChange = onlongdescription,
            placeholder = { Text("Descrição longa", color = Color(0xFF9E9890)) },
            maxLines = 5,
            colors = courseTextFieldColors(),
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            value = course.percentageprogress.toString(),
            onValueChange = { it.toDoubleOrNull()?.let(onpercentageprogress) },
            placeholder = { Text("Progresso (0.0 a 1.0)", color = Color(0xFF9E9890)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            colors = courseTextFieldColors(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
private fun CategoryField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        shape = RoundedCornerShape(16.dp),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text("Categoria", color = Color(0xFF9E9890)) },
        singleLine = true,
        colors = courseTextFieldColors(),
        modifier = modifier
    )
}

@Composable
private fun LevelField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        shape = RoundedCornerShape(16.dp),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text("Nível", color = Color(0xFF9E9890)) },
        singleLine = true,
        colors = courseTextFieldColors(),
        modifier = modifier
    )
}

@Composable
private fun WorktimeField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        shape = RoundedCornerShape(16.dp),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text("Carga horária (h)", color = Color(0xFF9E9890)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = courseTextFieldColors(),
        modifier = modifier
    )
}

@Composable
private fun AvailabilityField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        shape = RoundedCornerShape(16.dp),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text("Disponibilidade", color = Color(0xFF9E9890)) },
        singleLine = true,
        colors = courseTextFieldColors(),
        modifier = modifier
    )
}

@Composable
private fun courseTextFieldColors() = OutlinedTextFieldDefaults.colors(
    unfocusedBorderColor = Color(0xFFEFEBE7),
    focusedBorderColor = Color(0xFF36414E),
    unfocusedContainerColor = Color(0xFFf8f6f3),
    focusedContainerColor = Color(0xFFf0ede8),
    focusedTextColor = Color(0xFF1A1714),
    unfocusedTextColor = Color(0xFF1A1714),
    unfocusedPlaceholderColor = Color(0xFFB4B0AA),
    focusedPlaceholderColor = Color(0xFF9E9890),
)


@Preview(showBackground = true)
@Composable
private fun CourseTextFieldPreview() {
    CatalogoAprenderTheme {
        CourseTextField(
            course = DataCourse.examplemodel(),
            oncompletename = {},
            onshortname = {},
            ontype = {},
            onLevel = {},
            onworktime = {},
            onshortdescription = {},
            onlongdescription = {},
            onavailability = {},
            onpercentageprogress = {}
        )
    }
}
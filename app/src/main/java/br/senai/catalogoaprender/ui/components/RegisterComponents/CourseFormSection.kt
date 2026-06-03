package br.senai.catalogoaprender.ui.components.RegisterComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.model.Availability
import br.senai.catalogoaprender.model.Category
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.model.Level

@Composable
fun CourseFormSection(
    course: DataCourse,
    onid: (Int) -> Unit,
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
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFf8f4f0))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                OutlinedTextField(
                    value = course.id.toString(),
                    onValueChange = { value ->
                        value.toIntOrNull()?.let { onid(it) }
                    },
                    label = { Text("ID") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = course.completename,
                    onValueChange = oncompletename,
                    label = { Text("Nome Completo") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = course.shortname,
                    onValueChange = onshortname,
                    label = { Text("Nome Curto") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = course.type.name,
                    onValueChange = ontype,
                    label = { Text("Categoria") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = course.level.name,
                    onValueChange = onLevel,
                    label = { Text("Nível") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = course.worktime.toString(),
                    onValueChange = { value ->
                        value.toIntOrNull()?.let { onworktime(it) }
                    },
                    label = { Text("Carga Horária (horas)") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = course.shortdescription,
                    onValueChange = onshortdescription,
                    label = { Text("Descrição Curta") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = course.longdescription,
                    onValueChange = onlongdescription,
                    label = { Text("Descrição Longa") },
                    minLines = 3,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = course.availability.name,
                    onValueChange = onavailability,
                    label = { Text("Disponibilidade") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = course.percentageprogress.toString(),
                    onValueChange = { value ->
                        value.toDoubleOrNull()?.let { onpercentageprogress(it) }
                    },
                    label = { Text("Percentual de Progresso (0.0 a 1.0)") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FormPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFf8f4f0))
    ) {
        CourseFormSection(
            course = DataCourse.examplemodel(),
            onid = {},
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
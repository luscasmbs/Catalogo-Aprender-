package br.senai.catalogoaprender.ui.components.RegisterComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.catalogoaprender.model.Availability
import br.senai.catalogoaprender.model.Category
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.model.LevelEnum
import br.senai.catalogoaprender.ui.theme.CatalogoAprenderTheme
import br.senai.catalogoaprender.ui.theme.Gray40
import br.senai.catalogoaprender.ui.theme.Gray50
import br.senai.catalogoaprender.ui.theme.Gray60
import br.senai.catalogoaprender.ui.theme.White

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
            .background(White, shape = RoundedCornerShape(16.dp))
            .border(0.5.dp, Gray60, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "DADOS DO CURSO",
            style = MaterialTheme.typography.labelSmall,
            color = Gray50,
            fontSize = 13.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            value = course.completename,
            onValueChange = oncompletename,
            placeholder = { Text("Nome completo do curso", color = Gray40) },
            singleLine = true,
            colors = courseTextFieldColors(),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            value = course.shortname,
            onValueChange = onshortname,
            placeholder = { Text("Nome breve", color = Gray40) },
            singleLine = true,
            colors = courseTextFieldColors(),
            modifier = Modifier.fillMaxWidth()
        )

        CategoryDropdown(
            selected = course.type,
            onSelected = { category ->
                ontype(category.name)
            },
            modifier = Modifier.fillMaxWidth()
        )

        LevelDropdown(
            selected = course.level,
            onSelected = { level ->
                onLevel(level.name)
            },
            modifier = Modifier.fillMaxWidth()
        )

        WorktimeField(
            value = if (course.worktime == 0) "" else course.worktime.toString(),
            onValueChange = { value ->
                onworktime(value.toIntOrNull() ?: 0)
            },
            modifier = Modifier.fillMaxWidth()
        )

        AvailabilityDropdown(
            selected = course.availability,
            onSelected = { availability ->
                onavailability(availability.name)
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            value = course.shortdescription,
            onValueChange = onshortdescription,
            placeholder = { Text("Descrição curta (máx. 120 caracteres)", color = Gray40) },
            maxLines = 3,
            colors = courseTextFieldColors(),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            value = course.longdescription,
            onValueChange = onlongdescription,
            placeholder = { Text("Descrição longa", color = Gray40) },
            maxLines = 5,
            colors = courseTextFieldColors(),
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        )

        OutlinedTextField(
            shape = RoundedCornerShape(16.dp),
            value = if (course.percentageprogress == 0.0) "" else ((course.percentageprogress * 100).toInt()).toString(),
            onValueChange = { value ->
                val progress = value.toDoubleOrNull() ?: 0.0
                onpercentageprogress(progress / 100)
            },
            placeholder = { Text("Progresso (0 a 100)", color = Gray40) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            colors = courseTextFieldColors(),
            modifier = Modifier.fillMaxWidth()
        )
    }
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
        placeholder = { Text("Carga horária (h)", color = Gray40) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = courseTextFieldColors(),
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CategoryDropdown(
    selected: Category,
    onSelected: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = if (selected == Category.VAZIO) "" else selected.displayname,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text("Categoria", color = Gray40) },
            shape = RoundedCornerShape(16.dp),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = courseTextFieldColors(),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            Category.entries
                .filter { category -> category != Category.VAZIO }
                .forEach { category ->
                    DropdownMenuItem(
                        text = {
                            Text(text = category.displayname)
                        },
                        onClick = {
                            onSelected(category)
                            expanded = false
                        }
                    )
                }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LevelDropdown(
    selected: LevelEnum,
    onSelected: (LevelEnum) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = if (selected == LevelEnum.VAZIO) "" else selected.name,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text("Nível", color = Gray40) },
            shape = RoundedCornerShape(16.dp),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = courseTextFieldColors(),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            LevelEnum.entries
                .filter { level -> level != LevelEnum.VAZIO }
                .forEach { level ->
                    DropdownMenuItem(
                        text = {
                            Text(text = level.name)
                        },
                        onClick = {
                            onSelected(level)
                            expanded = false
                        }
                    )
                }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AvailabilityDropdown(
    selected: Availability,
    onSelected: (Availability) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = if (selected == Availability.VAZIO) "" else selected.displayname,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text("Disponibilidade", color = Gray40) },
            shape = RoundedCornerShape(16.dp),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = courseTextFieldColors(),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            Availability.entries
                .filter { availability -> availability != Availability.VAZIO }
                .forEach { availability ->
                    DropdownMenuItem(
                        text = {
                            Text(text = availability.displayname)
                        },
                        onClick = {
                            onSelected(availability)
                            expanded = false
                        }
                    )
                }
        }
    }
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
    focusedPlaceholderColor = Gray40,
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
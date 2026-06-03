package br.senai.catalogoaprender.ui.components

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.model.Availability
import br.senai.catalogoaprender.model.Category
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.model.Level
import br.senai.catalogoaprender.ui.screens.CatalogScreen

@Composable
fun CatalogScreen(modifier: Modifier = Modifier, course: DataCourse){
    Scaffold{ innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .background(Color(0xFF0d1b2a)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(
                modifier = modifier
                    .fillMaxWidth(0.98f)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = course.completename,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = course.shortdescription,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "${course.type} • ${course.worktime}h • ${course.level}",
                        style = MaterialTheme.typography.labelMedium
                    )


                }

        }

    }
    }
}

@Composable
@Preview(showBackground = true)
private fun CatalogScreenPreview() {
    CatalogScreen(
        course = DataCourse(
            id = 1,
            completename = "Análise e Desenvolvimento de Sistemas",
            shortname = "ADS",
            type = Category.PROGRAMACAO,
            level = Level.INTERMEDIARIO,
            worktime = 1300,
            shortdescription = "Curso de ADS",
            longdescription = "Descrição completa",
            availability = Availability.DISPONIVEL,
            percentageprogress = 0.20
        )
    )
}
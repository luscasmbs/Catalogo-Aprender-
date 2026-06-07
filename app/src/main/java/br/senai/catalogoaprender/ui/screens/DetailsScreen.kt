package br.senai.catalogoaprender.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.catalogoaprender.data.CourseRepository
import br.senai.catalogoaprender.ui.components.DetailsComponents.DetailsBackButton
import br.senai.catalogoaprender.ui.components.DetailsComponents.DetailsCourseCard
import br.senai.catalogoaprender.ui.components.DetailsComponents.DetailsHeader
import br.senai.catalogoaprender.ui.components.DetailsComponents.DetailsNotFoundCard
import br.senai.catalogoaprender.ui.theme.White10

@Composable
fun DetailsScreen(
    courseId: Int,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val course = CourseRepository.courses.firstOrNull { it.id == courseId }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White10)
            .verticalScroll(rememberScrollState())
    ) {
        DetailsHeader()

        if (course == null) {
            DetailsNotFoundCard()
        } else {
            DetailsCourseCard(course = course)
        }

        DetailsBackButton(
            onBackClick = onBackClick
        )

        Spacer(
            modifier = Modifier
                .height(24.dp)
                .navigationBarsPadding()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailsScreenPreview() {
    DetailsScreen(
        courseId = 1,
        onBackClick = {}
    )
}
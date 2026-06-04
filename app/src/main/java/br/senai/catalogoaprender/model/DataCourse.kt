package br.senai.catalogoaprender.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.Int
import kotlin.String

data class DataCourse(
    val id: Int,
    val completename: String,
    val shortname: String,
    val type: Category,
    val level: Level,
    val worktime: Int,
    val shortdescription: String,
    val longdescription: String,
    val availability: Availability,
    val percentageprogress: Double
){
    companion object{
        fun examplemodel(): DataCourse{
            return DataCourse(
                id = 1,
                completename = "Curso Técnico em Análise e Desenvolvimento de Sistemas",
                shortname = "ADS",
                type = Category.PROGRAMACAO,
                level = Level.INTERMEDIARIO,
                worktime = 1300,
                shortdescription = "Formação técnica para criar apps e sites.",
                longdescription = "colocar dps",
                availability = Availability.DISPONIVEL,
                percentageprogress = 0.90
            )
        }
    }
}



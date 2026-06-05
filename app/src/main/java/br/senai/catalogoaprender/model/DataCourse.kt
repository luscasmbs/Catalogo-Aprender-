package br.senai.catalogoaprender.model

import kotlin.Int
import kotlin.String

data class DataCourse(
    val id: Int,
    val completename: String,
    val shortname: String,
    val type: Category,
    val level: LevelEnum,
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
                level = LevelEnum.INTERMEDIARIO,
                worktime = 1300,
                shortdescription = "Formação técnica para criar apps e sites.",
                longdescription = "colocar dps",
                availability = Availability.DISPONIVEL,
                percentageprogress = 0.90
            )
        }
    }
}



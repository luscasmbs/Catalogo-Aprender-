package br.senai.catalogoaprender.data

import androidx.compose.runtime.mutableStateListOf
import br.senai.catalogoaprender.model.Availability
import br.senai.catalogoaprender.model.Category
import br.senai.catalogoaprender.model.DataCourse
import br.senai.catalogoaprender.model.LevelEnum

object CourseRepository {
    val courses = mutableStateListOf(
        DataCourse(
            id = 1,
            completename = "Curso Técnico em Análise e Desenvolvimento de Sistemas",
            shortname = "ADS",
            type = Category.PROGRAMACAO,
            level = LevelEnum.INTERMEDIARIO,
            worktime = 1300,
            shortdescription = "Formação técnica para criar apps, sistemas e sites.",
            longdescription = "Curso voltado ao desenvolvimento de sistemas, lógica de programação, banco de dados, aplicativos e soluções digitais para o mercado de tecnologia.",
            availability = Availability.DISPONIVEL,
            percentageprogress = 0.90
        ),
        DataCourse(
            id = 2,
            completename = "Curso de Desenvolvimento Android com Kotlin",
            shortname = "Android Kotlin",
            type = Category.ANDROID,
            level = LevelEnum.INTERMEDIARIO,
            worktime = 240,
            shortdescription = "Aprenda a criar aplicativos Android modernos.",
            longdescription = "Curso focado em desenvolvimento mobile com Kotlin, Jetpack Compose, navegação, estado, listas, componentes visuais e boas práticas de interface.",
            availability = Availability.DISPONIVEL,
            percentageprogress = 0.65
        ),
        DataCourse(
            id = 3,
            completename = "Curso Básico de Lógica de Programação",
            shortname = "Lógica",
            type = Category.PROGRAMACAO,
            level = LevelEnum.BASICO,
            worktime = 160,
            shortdescription = "Base essencial para começar a programar.",
            longdescription = "Curso introdutório com foco em algoritmos, variáveis, condições, repetições, funções e resolução de problemas usando raciocínio lógico.",
            availability = Availability.DISPONIVEL,
            percentageprogress = 0.40
        ),
        DataCourse(
            id = 4,
            completename = "Curso de Design de Interfaces Digitais",
            shortname = "UI Design",
            type = Category.DESIGN,
            level = LevelEnum.BASICO,
            worktime = 180,
            shortdescription = "Crie interfaces bonitas, claras e funcionais.",
            longdescription = "Curso voltado à criação de interfaces digitais, hierarquia visual, cores, tipografia, espaçamentos, componentes e experiência do usuário.",
            availability = Availability.DISPONIVEL,
            percentageprogress = 0.55
        ),
        DataCourse(
            id = 5,
            completename = "Curso de Gestão de Projetos Ágeis",
            shortname = "Gestão Ágil",
            type = Category.GESTAO,
            level = LevelEnum.INTERMEDIARIO,
            worktime = 200,
            shortdescription = "Organize projetos com métodos ágeis.",
            longdescription = "Curso sobre planejamento, organização de tarefas, Scrum, Kanban, entregas incrementais, gestão de equipe e acompanhamento de resultados.",
            availability = Availability.EM_BREVE,
            percentageprogress = 0.20
        ),
        DataCourse(
            id = 6,
            completename = "Curso de Banco de Dados para Iniciantes",
            shortname = "Banco de Dados",
            type = Category.DADOS,
            level = LevelEnum.BASICO,
            worktime = 220,
            shortdescription = "Aprenda a modelar e consultar dados.",
            longdescription = "Curso introdutório sobre modelagem de dados, tabelas, relacionamentos, SQL, consultas, filtros, ordenações e estruturação de informações.",
            availability = Availability.DISPONIVEL,
            percentageprogress = 0.75
        ),
        DataCourse(
            id = 7,
            completename = "Curso de Qualidade de Software",
            shortname = "QA Software",
            type = Category.QUALIDADE,
            level = LevelEnum.INTERMEDIARIO,
            worktime = 180,
            shortdescription = "Teste sistemas e melhore produtos digitais.",
            longdescription = "Curso sobre testes manuais, testes automatizados, casos de teste, documentação de bugs, validação de requisitos e qualidade em software.",
            availability = Availability.DISPONIVEL,
            percentageprogress = 0.50
        ),
        DataCourse(
            id = 8,
            completename = "Curso Avançado de Programação Kotlin",
            shortname = "Kotlin Pro",
            type = Category.PROGRAMACAO,
            level = LevelEnum.AVANCACO,
            worktime = 300,
            shortdescription = "Aprofunde seus conhecimentos em Kotlin.",
            longdescription = "Curso avançado com foco em recursos modernos da linguagem Kotlin, organização de código, funções, classes, coleções, null safety e boas práticas.",
            availability = Availability.EM_BREVE,
            percentageprogress = 0.15
        ),
        DataCourse(
            id = 9,
            completename = "Curso de Prototipação com Figma",
            shortname = "Figma",
            type = Category.DESIGN,
            level = LevelEnum.BASICO,
            worktime = 120,
            shortdescription = "Monte protótipos navegáveis de aplicativos.",
            longdescription = "Curso prático para criação de telas, componentes, estilos, fluxos navegáveis, protótipos interativos e apresentação de soluções digitais.",
            availability = Availability.DISPONIVEL,
            percentageprogress = 0.60
        ),
        DataCourse(
            id = 10,
            completename = "Curso de Análise de Dados com Planilhas",
            shortname = "Dados",
            type = Category.DADOS,
            level = LevelEnum.BASICO,
            worktime = 140,
            shortdescription = "Organize e interprete dados com planilhas.",
            longdescription = "Curso voltado ao uso de planilhas para análise de dados, fórmulas, gráficos, tabelas, filtros e interpretação de informações.",
            availability = Availability.DISPONIVEL,
            percentageprogress = 0.35
        ),
        DataCourse(
            id = 11,
            completename = "Curso de Testes em Aplicativos Mobile",
            shortname = "Testes Mobile",
            type = Category.QUALIDADE,
            level = LevelEnum.INTERMEDIARIO,
            worktime = 160,
            shortdescription = "Valide aplicativos Android com boas práticas.",
            longdescription = "Curso focado em testes para aplicativos móveis, validação de telas, fluxos de navegação, testes de entrada, comportamento esperado e prevenção de erros.",
            availability = Availability.INDISPONIVEL,
            percentageprogress = 0.10
        ),
        DataCourse(
            id = 12,
            completename = "Curso de Administração para Negócios Digitais",
            shortname = "Negócios Digitais",
            type = Category.GESTAO,
            level = LevelEnum.BASICO,
            worktime = 200,
            shortdescription = "Aprenda gestão aplicada a produtos digitais.",
            longdescription = "Curso sobre organização de negócios digitais, análise de mercado, planejamento, atendimento ao cliente, produtividade e tomada de decisão.",
            availability = Availability.DISPONIVEL,
            percentageprogress = 0.80
        )
    )

    fun addCourse(course: DataCourse) {
        courses.add(course)
    }

    fun clearCourses() {
        courses.clear()
    }
}
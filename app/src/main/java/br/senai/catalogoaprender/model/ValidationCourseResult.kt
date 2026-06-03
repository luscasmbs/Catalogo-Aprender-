import br.senai.catalogoaprender.model.DataCourse

data class ValidationCourseResult(
    val course: DataCourse
) {
    private val emptyFields: Boolean
        get() = course.completename.isBlank() &&
                course.shortname.isBlank() &&
                course.worktime == 0 &&
                course.shortdescription.isBlank()

    val messages: List<String>
        get() {
            val errors = mutableListOf<String>()

            if (course.completename.length < 10) {
                errors.add("O nome completo deve ter no mínimo 10 caracteres.")
            }

            if (course.shortname.isBlank()) {
                errors.add("O nome breve é obrigatório.")
            } else if (course.shortname.length > 20) {
                errors.add("O nome breve deve ter no máximo 20 caracteres.")
            }


            if (course.worktime <= 0) {
                errors.add("A carga horária deve ser um número inteiro positivo.")
            }

            if (course.shortdescription.isBlank()) {
                errors.add("A descrição curta é obrigatória.")
            } else if (course.shortdescription.length > 120) {
                errors.add("A descrição curta deve ter no máximo 120 caracteres.")
            }

            return errors
        }

    val valid: Boolean
        get() = messages.isEmpty()

    val message: String
        get() = when {
            emptyFields -> "Preencha os dados para gerar a visualização do curso."
            valid -> "Cadastro visual válido para apresentação."
            messages.size == 1 -> messages.first()
            else -> "Existem múltiplas pendências no cadastro."
        }
}
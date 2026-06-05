package br.senai.catalogoaprender.model


enum class Availability(val displayname: String){
    DISPONIVEL("Disponível"),
    EM_BREVE("Em breve"),
    VAZIO("Vazio"),

    INDISPONIVEL("Indisponível")
}
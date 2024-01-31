package totheking.traveljournals.travel.dto

import totheking.traveljournals.travel.domain.Travel


data class CreateRequest(
        val title: String,
        val description: String,
        val represent: String,
) {
    fun toEntity(): Travel {
        return Travel(
                title = title,
                description = description,
                represent = represent
        )
    }
}

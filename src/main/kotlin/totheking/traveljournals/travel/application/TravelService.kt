package totheking.traveljournals.travel.application

import org.springframework.stereotype.Service
import totheking.traveljournals.travel.domain.TravelRepository
import totheking.traveljournals.travel.dto.TravelDto

@Service
class TravelService(val db: TravelRepository) {
    fun list(): List<TravelDto> = db.findAll().map {
        TravelDto(it.id, it.title, it.description)
    }

    fun delete(id: Long) = db.deleteById(id)
}
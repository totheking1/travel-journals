package totheking.traveljournals.travel.application

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import totheking.traveljournals.travel.domain.Travel
import totheking.traveljournals.travel.domain.repository.TravelRepository
import totheking.traveljournals.travel.dto.TravelDto
import totheking.traveljournals.travel.dtos.CreateRequest
import totheking.traveljournals.travel.dtos.CreateResponse


@Service
@Transactional(readOnly = true)
class TravelService(val travelRepository: TravelRepository) {

    fun list(): List<TravelDto> = travelRepository.findAll().map {
        TravelDto(it.id, it.title, it.description)
    }

    @Transactional
    fun delete(id: Long) = travelRepository.deleteById(id)

    @Transactional
    fun createTravel(createRequest: CreateRequest): CreateResponse{
        val travel: Travel = travelRepository.save(createRequest.toEntity())
        return getTravelResponse(travel)
    }

    private fun getTravelResponse(travel: Travel): CreateResponse {
        return CreateResponse(travel.id)
    }

}
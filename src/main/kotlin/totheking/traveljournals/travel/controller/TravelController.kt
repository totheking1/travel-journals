package totheking.traveljournals.travel.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import totheking.traveljournals.travel.service.TravelService
import totheking.traveljournals.travel.dto.TravelDto
import totheking.traveljournals.travel.dto.CreateRequest
import totheking.traveljournals.travel.dto.CreateResponse
import java.net.URI


@RestController
@RequestMapping("/travels")
class TravelController(val travelService: TravelService) {

    @GetMapping
    fun list(): List<TravelDto> = travelService.list()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        travelService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PostMapping
    fun createTravel(@RequestBody createRequest: CreateRequest): ResponseEntity<CreateResponse> {
        val travel: CreateResponse = travelService.createTravel(createRequest)
        return ResponseEntity.created(URI.create("/travel/" + travel.id)).body(travel)
    }

}

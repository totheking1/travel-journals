package totheking.traveljournals.travel.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import totheking.traveljournals.travel.application.TravelService
import totheking.traveljournals.travel.dto.TravelDto


@RestController
@RequestMapping("/travels")
class TravelController(val service: TravelService) {
    @GetMapping
    fun list(): List<TravelDto> = service.list()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}

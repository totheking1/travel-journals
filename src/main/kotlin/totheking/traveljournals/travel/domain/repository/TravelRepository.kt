package totheking.traveljournals.travel.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import totheking.traveljournals.travel.domain.Travel

interface TravelRepository : JpaRepository<Travel, Long>
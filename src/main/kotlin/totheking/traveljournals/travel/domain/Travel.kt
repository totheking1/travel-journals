package totheking.traveljournals.travel.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Travel (
    @Id @GeneratedValue var id: Long? = null,
    var title: String,
    var description: String,
)

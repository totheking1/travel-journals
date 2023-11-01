package totheking.traveljournals.travel.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Entity
class Travel (
    @Id @GeneratedValue var id: Long? = null,
    var title: String,
    var description: String,
//    @CreatedBy var createdBy: String,
//    @CreatedDate var createdDate: LocalDateTime = LocalDateTime.now(),
//    @LastModifiedBy var modifiedBy: String,
//    @LastModifiedDate var modifiedDate: LocalDateTime,
)

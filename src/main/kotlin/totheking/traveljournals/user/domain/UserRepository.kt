package totheking.traveljournals.user.domain

import org.springframework.data.jpa.repository.JpaRepository
import totheking.traveljournals.user.domain.User

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}

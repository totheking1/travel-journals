package totheking.traveljournals.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import totheking.traveljournals.user.domain.User
import totheking.traveljournals.user.domain.UserRepository

@Service
@Transactional
class UserCommandHandler(val userRepository: UserRepository) {
    fun findByEmail(email: String) : User = userRepository.findByEmail(email) ?: throw IllegalArgumentException("failed to find $email user.")
}

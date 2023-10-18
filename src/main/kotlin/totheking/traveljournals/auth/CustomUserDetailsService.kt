package totheking.traveljournals.auth

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import totheking.traveljournals.user.application.UserCommandHandler

class CustomUserDetailsService(private val userCommandHandler: UserCommandHandler) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        return userCommandHandler.findByEmail(username ?: throw IllegalArgumentException())
            .let { CustomUserDetails.from(it) }
    }
}

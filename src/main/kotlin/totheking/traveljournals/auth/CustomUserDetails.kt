package totheking.traveljournals.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import totheking.traveljournals.user.domain.User

class CustomUserDetails private constructor(
    private val userEmail: String,
    private val userPassword: String
) : UserDetails {
    companion object {
        fun from(user: User): CustomUserDetails {
            return with(user) {
                CustomUserDetails(email, password)
            }
        }
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf()
    }

    override fun getPassword(): String {
        return userPassword
    }

    override fun getUsername(): String {
        return userEmail
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}

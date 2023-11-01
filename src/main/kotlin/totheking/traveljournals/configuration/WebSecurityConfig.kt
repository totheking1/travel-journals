package totheking.traveljournals.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.SecurityFilterChain
import totheking.traveljournals.auth.CustomUserDetailsService
import totheking.traveljournals.user.application.UserCommandHandler

@EnableWebSecurity
@Configuration
class WebSecurityConfig {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf {
                disable()
            }
            formLogin { }
            httpBasic { }
            authorizeHttpRequests {
                authorize(anyRequest, permitAll)
            }
        }
        return http.build()
    }

    @Bean
    fun userDetailsService(userCommandHandler: UserCommandHandler): UserDetailsService = CustomUserDetailsService(userCommandHandler)
}

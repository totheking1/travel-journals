package totheking.traveljournals.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig: WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        val allowedOrigins = arrayOf("http://localhost:3000")
        registry.addMapping("/**")
            .allowedMethods("*")
            .allowedOriginPatterns(*allowedOrigins)
            .allowCredentials(true)
    }
}

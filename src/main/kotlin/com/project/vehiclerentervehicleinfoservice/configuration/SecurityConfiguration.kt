package com.project.vehiclerentervehicleinfoservice.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfiguration {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { csrf -> csrf.disable() }
            .authorizeHttpRequests { authorize ->
                authorize

                    .requestMatchers("/actuator/**").permitAll()
                    .requestMatchers("/health").permitAll()
                    .requestMatchers(HttpMethod.OPTIONS).permitAll()

                    .requestMatchers(HttpMethod.GET, "/api/v1/brands").permitAll()


                    .anyRequest().authenticated()
            }
            .oauth2ResourceServer { oauth2 ->
                oauth2
                    .jwt(Customizer.withDefaults())
            }

        return http.build()
    }
}
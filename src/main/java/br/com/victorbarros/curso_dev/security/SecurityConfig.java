package br.com.victorbarros.curso_dev.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> {
          auth.requestMatchers("/cursos/{id}/active").permitAll();
          auth.requestMatchers("/cursos/{id}").permitAll();
          auth.requestMatchers("/cursos/").permitAll();
          auth.requestMatchers("/cursos/").permitAll();
          auth.anyRequest().authenticated();
        });

    return http.build();
  }
}

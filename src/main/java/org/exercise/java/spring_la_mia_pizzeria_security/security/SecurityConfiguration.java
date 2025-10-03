package org.exercise.java.spring_la_mia_pizzeria_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // filter chain with new syntax using lambda expressions
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/pizzas/create").hasAuthority("ADMIN")
                .requestMatchers("/pizzas/edit", "/pizzas/edit/**").hasAuthority("ADMIN")
                .requestMatchers("/offers/create").hasAuthority("ADMIN")
                .requestMatchers("/offers/edit", "/offers/edit/**").hasAuthority("ADMIN")
                .requestMatchers("/ingredients/create").hasAuthority("ADMIN")
                .requestMatchers("/ingredients/edit", "/ingredients/edit/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/**").hasAuthority("ADMIN")
                .requestMatchers("/pizzas", "/pizzas/**").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/**").permitAll())

                .formLogin(Customizer.withDefaults())
                .cors(cors -> cors.disable()) // disabilita CORS
                .csrf(csrf -> csrf.disable()); // disabilita CSRF

        return http.build();
    }

    // userDetailsService
    @Bean
    UserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService();
    }

    // password encoder
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // auth provider
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService());
        // authProvider.setUserDetailsService)(;
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}

package uz.pdp.apppcmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecuritySetting {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails superAdmin = User.builder()
                .username("superAdmin")
                .password(passwordEncoder().encode("superAdmin"))
                .roles("superAdmin")
                .build();
        UserDetails moderator = User.builder()
                .username("moderator")
                .password(passwordEncoder().encode("moderator"))
                .roles("moderator")
                .build();
        UserDetails operator = User.builder()
                .username("operator")
                .password(passwordEncoder().encode("operator"))
                .roles("operator")
                .build();
        return new InMemoryUserDetailsManager(superAdmin, moderator, operator);}
        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();

    }
}

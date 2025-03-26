//package com.luv2code.springboot.demo.clinicapi;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DemoSecurityConfig {
////    @Bean
////    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
////        UserDetails john= User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
////
////        UserDetails mary= User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE","MANAGER").build();
////
////        UserDetails suzan=User.builder().username("suzan").password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();
////
////        return new InMemoryUserDetailsManager(john, mary, suzan);
////    }
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id = ?");
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id = ?");
//        return jdbcUserDetailsManager;
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests(configurer ->
//                configurer.requestMatchers(HttpMethod.GET, "/patients").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/doctors").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.POST, "/patients").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.POST, "/workers").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/nurses").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/appointments").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/allappointment").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                );
//        http.httpBasic(Customizer.withDefaults());
//        http.csrf(csrf->csrf.disable());
//return http.build();
//    }
//
//}

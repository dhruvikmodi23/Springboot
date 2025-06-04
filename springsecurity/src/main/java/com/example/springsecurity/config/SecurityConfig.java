package com.example.springsecurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public AuthenticationProvider authProvider(){

        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();

        provider.setUserDetailsService( userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
         return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //with lambda
         http.csrf(customizer -> customizer.disable());
         http.authorizeHttpRequests(req -> req.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // not need to form login when stateless.


        //without lambda
//       Customizer<CsrfConfigurer<HttpSecurity>> custCsrf= new Customizer<CsrfConfigurer<HttpSecurity>>() {
//           @Override
//           public void customize(CsrfConfigurer<HttpSecurity> Configurer) {
//               Configurer.disable();
//           }
//       };
//        http.csrf(custCsrf);
//        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp = new Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//            @Override
//            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry Registry) {
//                  Registry.anyRequest().authenticated();
//            }
//        } ;
//        http.authorizeHttpRequests(custHttp);

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailService(){
//
//        UserDetails user = User.
//                                withDefaultPasswordEncoder().
//                                username("dhruvik").
//                                password("abc").
//                                roles("admin").
//                                build();
//
//        UserDetails user1 = User.
//                withDefaultPasswordEncoder().
//                username("dhruvik1").
//                password("abc").
//                roles("admin").
//                build();
//
//       return new InMemoryUserDetailsManager(user,user1);
//    }
}

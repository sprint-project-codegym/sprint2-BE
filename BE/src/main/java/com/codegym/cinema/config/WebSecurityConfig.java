package com.codegym.cinema.config;
import com.codegym.cinema.accessdenied.CustomAccessDeniedHandler;
import com.codegym.cinema.jwt.JwtAuthenticationEntryPoint;
import com.codegym.cinema.jwt.JwtFilter;
import com.codegym.cinema.service.impl.CustomAuthenticationFilter;
import com.codegym.cinema.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

                .antMatchers("/login/", "/", "/register","/detail-movie/*").permitAll().and()
                .authorizeRequests().antMatchers("/admin", "/admin/*", "/admin/**")
                .access("hasRole('ROLE_ADMIN')").and().
                authorizeRequests().antMatchers("/employee", "/employee/*", "/employee/**")
                .access("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_ADMIN')").and().
                authorizeRequests().antMatchers("/user", "/user/*", "/user/**","detail-movie/**")
                .access("hasAnyRole('ROLE_MEMBER','ROLE_EMPLOYEE', 'ROLE_ADMIN')").and()
                .exceptionHandling().accessDeniedPage("/403")
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().cors();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/api/login/").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilter(customAuthenticationFilter);
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

}

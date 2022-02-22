package vn.codegym.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import vn.codegym.security.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/");
        http
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/employee").hasRole("EMP")
                .antMatchers("/employee/**", "/employee").hasRole("ADMIN")
                .antMatchers("/employee/view/*").hasAnyRole("EMP", "ADMIN")
                .anyRequest().authenticated();
        http.authorizeRequests().and().rememberMe()
                .tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60 * 60 * 24);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }
}


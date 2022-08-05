package ru.skipp.autopartstore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.skipp.autopartstore.model.Role;
import ru.skipp.autopartstore.model.User;
import ru.skipp.autopartstore.repository.UserRepository;
import ru.skipp.autopartstore.AuthUser;
import ru.skipp.autopartstore.services.UserService;

import java.util.Optional;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);
//    public static final PasswordEncoder PASSWORD_ENCODER = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    private final UserRepository userRepository;
//
//    public WebSecurityConfig(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(email -> {
//            log.debug("Authenticating '{}'", email);
//            Optional<User> optionalUser = userRepository.findByEmailIgnoreCase(email);
//            return new AuthUser(optionalUser.orElseThrow(
//                    () -> new UsernameNotFoundException("User '" + email + "' was not found")));
//        }
//        ).passwordEncoder(PASSWORD_ENCODER);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration", "/static/**", "/activate/*").permitAll()
                    .antMatchers("/api/account/register").anonymous()
                    .antMatchers("/api/account").hasRole(Role.USER.name())
                    .antMatchers("/api/**").hasRole(Role.ADMIN.name())
                    .antMatchers("/user").hasRole(Role.ADMIN.name())
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login").permitAll()
                .and()
                    .rememberMe()
                .and()
                    .logout().permitAll();
//                .and().httpBasic()
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }
}

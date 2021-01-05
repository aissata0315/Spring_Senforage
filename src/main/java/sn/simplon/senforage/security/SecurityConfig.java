package sn.simplon.senforage.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.Filter;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder passwordEncoder = passwordEncoder();
      /*  System.out.println("=============================================");
        System.out.println("Mot de passe "+passwordEncoder.encode("passer"));
        System.out.println("=============================================");

       */

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email as principal, password as credentials, etat from user where email= ?")
                .authoritiesByUsernameQuery("Select u.email as principal, r.nom as role from user u, role r, user_role ur where u.id = ur.idu and r.id = ur.idr and u.email = ?")
                .rolePrefix("ROLE_")
                .passwordEncoder(passwordEncoder);
    }
    @Override
    protected void configure(HttpSecurity http) {

        try {
            http.formLogin().loginPage("/login");
            http.authorizeRequests().antMatchers("/Village/**").hasRole("USER");
            http.authorizeRequests().antMatchers("/Client/**").hasRole("USER");
           // http.authorizeRequests().antMatchers("/Client/**").hasRole("USER");
           // http.authorizeRequests().antMatchers("/Client/**").hasRole("ADMIN");
            http.authorizeRequests().antMatchers("/User/**", "/Role/**").hasRole("SUPERADMIN");
            http.exceptionHandling().accessDeniedPage("/Admin/403");
            http.authorizeRequests().antMatchers("/**").permitAll();
            http.csrf().disable();

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

   @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder password = new BCryptPasswordEncoder();
        return password;
    }




}
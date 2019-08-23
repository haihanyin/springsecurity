package p.hh.spsec.at.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CheatcodeAuthenticationProvider cheatcodeAuthenticationProvider;

    CheatcodeProcessingFilter cheatcodeProcessingFilter(AuthenticationManager authenticationManager) {
        CheatcodeProcessingFilter cheatcodeProcessingFilter = new CheatcodeProcessingFilter();
        cheatcodeProcessingFilter.setAuthenticationManager(authenticationManager);
        return cheatcodeProcessingFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin**").authenticated()
                .anyRequest().permitAll();
        http.addFilterBefore(cheatcodeProcessingFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(cheatcodeAuthenticationProvider);
    }
}

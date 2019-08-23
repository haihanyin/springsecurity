package p.hh.spsec.at.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheatcodeProcessingFilter extends AbstractAuthenticationProcessingFilter {

    public CheatcodeProcessingFilter() {
        super(new AntPathRequestMatcher("/admin**"));
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        System.out.println("CheatcodeProcessingFilter.attemptAuthentication");
        String cheatcode = request.getParameter("cheatcode");
        return new CheatcodeToken(cheatcode);
    }
}

package p.hh.spsec.at.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CheatcodeAuthenticationProvider implements AuthenticationProvider {

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if("whosyourdaddy".equals(authentication.getCredentials())) {
            authentication.setAuthenticated(true);
            // can also return a different authenticated authentication here
            return authentication;
        }
        return authentication;
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(CheatcodeToken.class);
    }
}

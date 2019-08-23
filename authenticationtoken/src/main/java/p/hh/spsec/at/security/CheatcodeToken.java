package p.hh.spsec.at.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CheatcodeToken extends AbstractAuthenticationToken {

    private String cheatcode;

    public CheatcodeToken(String cheatcode) {
        super(null);
        this.cheatcode = cheatcode;
    }

    public Object getCredentials() {
        return cheatcode;
    }

    public Object getPrincipal() {
        return null;
    }
}

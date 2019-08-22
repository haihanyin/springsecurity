package p.hh.spsec.hsi.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class MySecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public MySecurityInitializer() {
        super(SecurityConfig.class);
    }
}

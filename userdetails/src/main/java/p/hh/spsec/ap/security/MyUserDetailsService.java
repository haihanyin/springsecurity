package p.hh.spsec.ap.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class MyUserDetailsService implements UserDetailsService {

    private static Map<String, UserDetails> userDetailsMap = new HashMap<String, UserDetails>();

    public MyUserDetailsService() {
        userDetailsMap.put("haihan", new MyUserDetails("haihan"));
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userDetailsMap.get(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException(username);
        }
        return userDetails;
    }
}

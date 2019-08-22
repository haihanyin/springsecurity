package p.hh.spsec.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String greeting() {
        return "Hello, I am User";
    }
}

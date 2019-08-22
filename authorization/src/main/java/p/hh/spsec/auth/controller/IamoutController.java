package p.hh.spsec.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IamoutController {

    @RequestMapping(value = "/iamout", method = RequestMethod.GET)
    @ResponseBody
    public String greeting() {
        return "Hello, I am out";
    }
}

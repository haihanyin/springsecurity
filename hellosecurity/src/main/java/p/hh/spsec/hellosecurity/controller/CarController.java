package p.hh.spsec.hellosecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    public CarController() {
        System.out.println("car controller is created");
    }

    @RequestMapping(value = "/mycar", method = RequestMethod.GET)
    @ResponseBody
    public String mycar() {
        return "Lexus";
    }

}

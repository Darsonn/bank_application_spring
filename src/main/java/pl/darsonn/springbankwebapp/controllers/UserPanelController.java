package pl.darsonn.springbankwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserPanelController {
    @RequestMapping(value = "userpanel", method = RequestMethod.GET)
    public String showUserPanel(@RequestParam String uid) {
        return "userpanel";
    }
}

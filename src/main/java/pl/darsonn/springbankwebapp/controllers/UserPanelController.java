package pl.darsonn.springbankwebapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserPanelController {
    @ExceptionHandler(Throwable.class)
    public String BlockAttemptsWithoutLoginIn() {
        return "redirect:/login";
    }

    @RequestMapping(value = "userpanel", method = RequestMethod.GET)
    public String showUserPanel(@RequestParam String uid) {
        return "userpanel";
    }
}

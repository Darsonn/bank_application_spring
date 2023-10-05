package pl.darsonn.springbankwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.darsonn.springbankwebapp.services.LoginService;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPanel(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showUserPanel(ModelMap model, @RequestParam String uid, @RequestParam String password) {
        boolean isValidUser = loginService.validateUser(uid, password);

        if(!isValidUser) {
            model.put("errorMessage", "Błędne dane!");
            return "login";
        }
        model.put("uid", uid);
        model.put("password", password);

        return "userpanel";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        e.printStackTrace();
        return "error";
    }

}

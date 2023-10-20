package pl.darsonn.springbankwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.darsonn.springbankwebapp.services.LoginService;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPanel(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public String validate(ModelMap model, @RequestParam String uid, @RequestParam String password, RedirectAttributes redirectAttributes) {
        boolean isValidUser = loginService.validateUser(uid, password);

        if(!isValidUser) {
            //model.put("errorMessage", "Błędne dane!");
            return "login";
        }
        model.put("uid", uid);
        model.put("password", password);

        redirectAttributes.addAttribute("uid", uid);
        return "redirect:userpanel";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        e.printStackTrace();
        return "error";
    }
}

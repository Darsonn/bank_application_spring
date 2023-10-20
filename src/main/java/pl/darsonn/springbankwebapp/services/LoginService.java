package pl.darsonn.springbankwebapp.services;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
    public boolean validateUser(String uid, String password) {
        return uid.equals("12345") && password.equalsIgnoreCase("haslo");
    }
}

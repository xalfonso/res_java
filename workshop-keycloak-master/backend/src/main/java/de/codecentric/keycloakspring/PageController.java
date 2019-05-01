package de.codecentric.keycloakspring;

import org.keycloak.KeycloakPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:8081" }, maxAge = 3000)
@RestController
public class PageController {

    @RequestMapping("/user")
    public String user(Model model, KeycloakPrincipal principal) {
        return "usercontent";
    }

    @RequestMapping(value = "/admin")
    public String admin(Model model, KeycloakPrincipal principal) {
        return "admincontent";
    }
}

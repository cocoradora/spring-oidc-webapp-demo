package dev.cocoradora.spring.auth.oidc.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller public class WebController {

    @GetMapping(path = "/") public String index() {
        return "external";
    }

    @GetMapping(path = "/customers") public String customers(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "customers";
    }
}

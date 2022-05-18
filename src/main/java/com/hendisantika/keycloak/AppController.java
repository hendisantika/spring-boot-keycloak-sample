package com.hendisantika.keycloak;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-keycloak-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 15/04/18
 * Time: 05.41
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AppController {

    @GetMapping(value = "/")
    public String getHome() {
        return "index";
    }

    @GetMapping(value = "/user")
    public String getUser(Principal principal, Model model) {
        System.out.println("principal = " + principal);
        model.addAttribute("user", principal.getName());
        return "user";
    }

    @GetMapping(value = "/admin")
    public String getAdmin(Principal principal, Model model) {
        model.addAttribute("admin", principal.getName());
        System.out.println("principal = " + principal);
        return "admin";
    }

    @GetMapping(value = "/logout")
    public String handleLogout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }

}


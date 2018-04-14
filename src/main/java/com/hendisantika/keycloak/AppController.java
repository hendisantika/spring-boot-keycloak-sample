package com.hendisantika.keycloak;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(Principal principal, Model model) {
        model.addAttribute("user", principal.getName());
        return "user";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdmin(Principal principal, Model model) {
        model.addAttribute("admin", principal.getName());
        return "admin";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String handleLogout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }

}


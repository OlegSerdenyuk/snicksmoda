package ua.com.snicksmoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.snicksmoda.entity.Client;
import ua.com.snicksmoda.entity.Role;
import ua.com.snicksmoda.service.ClientService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/main_page")
    String mainPage() {
        return "mainPage";
    }

    @RequestMapping("/admin")
    String admin() {
        return "admin";
    }


    @RequestMapping("/registration")
    ModelAndView registration(@RequestParam("password") String password) {
        ModelAndView modelAndView = new ModelAndView("admin");
        String passWord = passwordEncoder.encode(password);
        Client admin = new Client(passWord, Role.ADMIN);
        if (!clientService.saveClient(admin)) {
            modelAndView.addObject("message", "Admin, уже вошёл в систему!");
            return modelAndView;
        } else {
            modelAndView.addObject("message", "Войдите, что бы продолжить.");
            return modelAndView;
        }
    }
}

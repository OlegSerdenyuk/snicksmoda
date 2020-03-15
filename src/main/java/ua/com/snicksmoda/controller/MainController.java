package ua.com.snicksmoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.com.snicksmoda.entity.Client;
import ua.com.snicksmoda.entity.Role;
import ua.com.snicksmoda.service.BasketService;
import ua.com.snicksmoda.service.ClientService;
import ua.com.snicksmoda.service.StuffService;

@Controller
public class MainController {

    @Autowired
    private ClientService clientService;

    @Autowired
    BasketService basketService;

    @Autowired
    StuffService stuffService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/main_page")
    String mainPage() {
        return "main_page";
    }

    @RequestMapping("/admin")
    String admin() {
        return "admin";
    }

    @RequestMapping("/category")
    String category() {
        return "category";
    }

    @RequestMapping("/mens_clothing")
    String mensClothing() {
        return "mens_clothing";
    }

    @RequestMapping("/womens_clothing")
    String womensClothing() {
        return "womens_clothing";
    }

    @RequestMapping("/baby_clothing")
    String babyClothing() {
        return "baby_clothing";
    }

    @RequestMapping("/delivery_payment")
    String deliveryPayment() {
        return "delivery_payment";
    }

    @RequestMapping("/contact")
    String contact() {
        return "contact";
    }

    @RequestMapping("/info_snicksmoda")
    String infoSnicksmoda() {
        return "info_snicksmoda";
    }

    @RequestMapping("/info_mens_clothing")
    String infoMensClothing() {
        return "info_mens_clothing";
    }

    @RequestMapping("/info_womens_clothing")
    String infoWomensClothing() {
        return "info_womens_clothing";
    }

    @RequestMapping("/info_baby_clothing")
    String infoBabyClothing() {
        return "info_baby_clothing";
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

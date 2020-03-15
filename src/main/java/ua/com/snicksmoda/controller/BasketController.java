package ua.com.snicksmoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.com.snicksmoda.service.BasketService;
import ua.com.snicksmoda.service.ClientService;

@RestController
public class BasketController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private BasketService basketService;

    @RequestMapping("/basket")
    ModelAndView getBasketInfo() {
        ModelAndView modelAndView = new ModelAndView("basket");
        return modelAndView.addObject("basket", basketService.countOfStuffInBasket(getEmailCurrentClient()));
    }

    private String getEmailCurrentClient() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

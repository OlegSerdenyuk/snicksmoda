package ua.com.snicksmoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.com.snicksmoda.entity.Category;
import ua.com.snicksmoda.entity.Stuff;
import ua.com.snicksmoda.service.CategoryService;
import ua.com.snicksmoda.service.StuffService;

@Controller
public class StuffController {

    @Autowired
    private StuffService stuffService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/add_stuff")
    String addStuff() {
        return "add_stuff";
    }

    @RequestMapping("/save_stuff")
    ModelAndView saveStuff(@RequestParam("name") String name, @RequestParam("category") Category category, @RequestParam("description") String description, @RequestParam("price") Long price, @RequestParam("urlPhoto") String urlPhoto) {
    ModelAndView modelAndView = new ModelAndView("/");
    Stuff stuff = new Stuff(name, category, description, price, urlPhoto);
    stuffService.saveStuff(stuff);
    return modelAndView;
    }
}

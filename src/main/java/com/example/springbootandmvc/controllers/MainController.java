package com.example.springbootandmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.Path;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String getHome() {
        return "home.html"; //under resources/static
    }

    @RequestMapping("/dynamic-home")
    public String getDynamicHome(Model page) {
        page.addAttribute("username", "Katy");
        page.addAttribute("color", "red");
        return "dynamic_home.html"; //under resources/templates
    }

    @RequestMapping("/colorable-home")
    public String getColorableHomeQuery(@RequestParam(required = false) String color,
                                        @RequestParam(required = false) String name,
                                        Model page) {
        if (color == null) {
            color = "blue";
        }
        if (name == null) {
            name = "d3fault-n4me";
        }
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "dynamic_home.html";
    }

    @RequestMapping("/colorable-home/{color}/{name}")
    public String getColorableHomePath(@PathVariable String color,
                                       @PathVariable String name,
                                       Model page) {
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "dynamic_home.html";
    }

}

package org.skillsoft.ssspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    public GreetingController(MessageProperties properties){
        this.properties = properties;
    }

    private final MessageProperties properties;

    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model) {
        String message = properties.getGreeting() + " -- " + name;
        model.addAttribute("greetingMessage", message);
        return "homePage";

    }
}

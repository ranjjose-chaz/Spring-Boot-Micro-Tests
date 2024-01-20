package org.skillsoft.ssspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/hello")
    public String helloMsg() {
        return "helloPage";
    }

    @GetMapping("/start")
    public String startPage() {
        return "startPage";
    }




}

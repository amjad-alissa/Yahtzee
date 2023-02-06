package de.adesso.alissa.yahtzee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @GetMapping("/")
    public String getIndexView() {
        return "index";
    }

    @GetMapping("/rules")
    public String getRulesView() {
        return "rules";
    }

    @GetMapping("/more")
    public String getMoreView() {
        return "more";
    }
}

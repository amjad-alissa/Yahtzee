package de.adesso.alissa.yahtzee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The Main controller for the game.
 */
@Controller
public class MainController {

    /**
     * Gets index view.
     *
     * @param model the model
     * @return the view index
     */
    @GetMapping("/")
    public String getIndexView(Model model) {
        return "index";
    }

    /**
     * Gets rules view.
     *
     * @return the view rules
     */
    @GetMapping("/rules")
    public String getRulesView() {
        return "rules";
    }

    /**
     * Gets more view.
     *
     * @return the view more
     */
    @GetMapping("/more")
    public String getMoreView() {
        return "more";
    }
}

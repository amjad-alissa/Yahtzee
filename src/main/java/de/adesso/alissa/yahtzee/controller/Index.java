package de.adesso.alissa.yahtzee.controller;

import de.adesso.alissa.yahtzee.elements.Table;
import de.adesso.alissa.yahtzee.game.RandomShuffel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Index {

    Table table = new Table();
    RandomShuffel randomShuffel = new RandomShuffel();

    @GetMapping("/")
    public String getIndexView(Model model) {
        randomShuffel.generateRadomShuffel();
        model.addAttribute("upperSection", table.getUpperSection());
        model.addAttribute("lowerSection", table.getLowerSection());
        model.addAttribute("radomDices", randomShuffel.getRandomDices());

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

    @GetMapping("/randomShuffel")
    public String getRandomShuffel(Model model) {
        return getIndexView(model);
    }



    @PostMapping("/randomShuffel")
    public String getRandomShuffel(Model model, @RequestParam boolean[] selectedDices) {
        randomShuffel.updateSelectedDices(selectedDices);
        return getIndexView(model);
    }
}

package de.adesso.alissa.yahtzee.controller;

import de.adesso.alissa.yahtzee.elements.Table;
import de.adesso.alissa.yahtzee.elements.TableRow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

@Controller
public class Index {

    @GetMapping("/")
    public String getIndexView(Model model, @ModelAttribute ArrayList<TableRow> upperSection,
                               @ModelAttribute ArrayList<TableRow> lowerSection) {
        Table table = new Table();
        model.addAttribute("upperSection", table.getUpperSection());
        model.addAttribute("lowerSection", table.getLowerSection());
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

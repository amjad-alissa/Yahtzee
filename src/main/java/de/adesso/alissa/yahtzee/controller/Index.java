package de.adesso.alissa.yahtzee.controller;

import de.adesso.alissa.yahtzee.game.business.PointsCalculator;
import de.adesso.alissa.yahtzee.game.elements.DiceSet;
import de.adesso.alissa.yahtzee.game.business.ResponseData;
import de.adesso.alissa.yahtzee.game.elements.Table;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Index {

    private final Table table = new Table();
    private final DiceSet diceSet = DiceSet.getInstance();

    private final PointsCalculator pointsCalculator = PointsCalculator.getInstance();

    @GetMapping("/")
    public String getIndexView(Model model) {
        model.addAttribute("upperSection", table.getUpperSection());
        model.addAttribute("lowerSection", table.getLowerSection());
        model.addAttribute("iconSources", diceSet.getDiceSourceImages());

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

    @GetMapping("/player/randomShuffel")
    public @ResponseBody ResponseData getRandomShuffel(@RequestParam boolean[] selectedDices) {
        ResponseData responseData = new ResponseData();
        diceSet.updateSelectedDices(selectedDices);

        responseData.setDiceSourceImages(diceSet.getDiceSourceImages());
        responseData.setPointsUpperSection(pointsCalculator.calculateResultsForUpperSection(diceSet.getDiceValues()));
        responseData.setPointsLowerSection(pointsCalculator.calculateResultsForLowerSection(diceSet.getDiceValues()));

        return responseData;
    }
}

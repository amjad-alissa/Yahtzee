package de.adesso.alissa.yahtzee.controller;

import de.adesso.alissa.yahtzee.game.elements.ResultElement;
import de.adesso.alissa.yahtzee.game.elements.ScoreElement;
import de.adesso.alissa.yahtzee.game.elements.Scoreboard;
import de.adesso.alissa.yahtzee.game.elements.DiceSetResponse;
import de.adesso.alissa.yahtzee.service.YahtzeeGameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The controller which serves as the starting point for handling all game events.
 */
@Controller
public class GameController {
    private static final YahtzeeGameService YAHTZEE_GAME_SERVICE = YahtzeeGameService.getInstance();

    /**
     * Initialize players with the provided names.
     *
     * @param model        the model
     * @param playersNames the players' names
     * @return the view game (which is ignored see ajax request)
     */
    @PostMapping("/initializePlayers")
    public String initializePlayers(Model model, @RequestParam String[] playersNames) {
        YAHTZEE_GAME_SERVICE.initializePlayers(playersNames);
        model.addAttribute("players", YAHTZEE_GAME_SERVICE.getPlayers());
        return "game";
    }

    /**
     * Start the game.
     *
     * @param model the model
     * @return the view game
     */
    @GetMapping("/startGame")
    public String startGame(Model model) {
        YAHTZEE_GAME_SERVICE.initializeTable();
        model.addAttribute("upperSection", YAHTZEE_GAME_SERVICE.getScoreTableUpperSection());
        model.addAttribute("iconSources", YAHTZEE_GAME_SERVICE.getDiceIconsSources());
        model.addAttribute("lowerSection", YAHTZEE_GAME_SERVICE.getScoreTableLowerSection());
        model.addAttribute("players", YAHTZEE_GAME_SERVICE.getPlayers());
        model.addAttribute("resultElements", YAHTZEE_GAME_SERVICE.getResultElements());
        return "game";
    }

    /**
     * Generate a random shuffel.
     *
     * @param selectedDices the selected dices
     * @return the dice set response
     */
    @GetMapping("/randomShuffel")
    public @ResponseBody DiceSetResponse randomShuffel(@RequestParam boolean[] selectedDices) {
        return YAHTZEE_GAME_SERVICE.processDiceSetSelection(selectedDices);
    }

    /**
     * Get the scoreboard for the current player.
     *
     * @param playerId the player id
     * @return the scoreboard of the current player
     */
    @PostMapping("/getScoreboardForCurrentPlayer")
    public @ResponseBody Scoreboard getScoreboardForCurrentPlayer(@RequestParam int playerId) {
        return YAHTZEE_GAME_SERVICE.getScoreBoard(playerId);
    }

    /**
     * Commit the decision made by the player.
     *
     * @param rowLabel the row's label
     * @param section  the section
     * @param playerId the player's id
     * @return the id of the next player
     */
    @GetMapping("/commitDecision")
    public @ResponseBody int commitDecision(@RequestParam String rowLabel, @RequestParam String section, @RequestParam int playerId) {
        YAHTZEE_GAME_SERVICE.processDecision(rowLabel, section, playerId);
        return YAHTZEE_GAME_SERVICE.getNextPlayer(playerId);
    }

    @GetMapping("/rankPlayers")
    public @ResponseBody ResultElement[] rankPlayers() {
        return YAHTZEE_GAME_SERVICE.rankPlayers();
    }



    @GetMapping("/checkEndOfGame")
    public @ResponseBody boolean checkEndOfGame() {
        return YAHTZEE_GAME_SERVICE.checkEndOfGame();
    }
}

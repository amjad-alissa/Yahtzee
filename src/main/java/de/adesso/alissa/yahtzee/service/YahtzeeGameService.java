package de.adesso.alissa.yahtzee.service;

import de.adesso.alissa.yahtzee.game.Player;
import de.adesso.alissa.yahtzee.game.Scoreboard;
import de.adesso.alissa.yahtzee.game.YahtzeeGame;
import de.adesso.alissa.yahtzee.game.business.DiceSetResponse;
import de.adesso.alissa.yahtzee.game.elements.ScoreTableRow;
import de.adesso.alissa.yahtzee.game.enums.Avatar;

import java.util.ArrayList;

public class YahtzeeGameService {

    private static YahtzeeGameService yahtzeeGameService =  null;
    private final YahtzeeGame yahtzeeGame;
    private final DiceSetService diceSetService;
    private final ScoreTableService scoreTableService;
    private DiceSetResponse diceSetResponse;
    private final ScoreService scoreService;
    private final DiceSetResponseService diceSetResponseService;
    private final PointsCalculatorService pointsCalculatorService;


    public static YahtzeeGameService getInstance() {
        if (yahtzeeGameService == null) {
            yahtzeeGameService = new YahtzeeGameService();
        }
        return yahtzeeGameService;
    }

    private YahtzeeGameService() {
        this.yahtzeeGame = YahtzeeGame.getInstance();
        this.diceSetService = new DiceSetService(yahtzeeGame.getDiceSet());
        this.diceSetResponseService = new DiceSetResponseService();
        this.pointsCalculatorService = new PointsCalculatorService();
        this.scoreTableService = new ScoreTableService();
        this.scoreService = new ScoreService();
    }


    public ArrayList<ScoreTableRow> getScoreTableUpperSection() {
        return yahtzeeGame.getTable().getUpperSection();
    }

    public ArrayList<ScoreTableRow> getScoreTableLowerSection() {
        return yahtzeeGame.getTable().getLowerSection();
    }

    public String[] getDiceIconsSources() {
        return this.diceSetService.getDiceSourceImages();
    }

    public DiceSetResponse processDiceSetSelection(final boolean[] selectedDices) {
        this.diceSetResponse = diceSetResponseService.createDiceSetResponse(pointsCalculatorService, diceSetService, selectedDices);
        return this.diceSetResponse;
    }

    public void initializePlayers(String[] playersNames) {
        ArrayList<Player> players = new ArrayList<>();
        for (String name : playersNames) {
            Player player = new Player();
            player.setName(name);
            player.setAvatarIconSource(Avatar.getNextAvatar().getValue());
            players.add(player);
        }
        yahtzeeGame.setPlayers(players);
    }

    public void initializeTable() {
        yahtzeeGame.setScoreTable(scoreTableService.createTable());
    }

    public ArrayList<Player> getPlayers() {
        return yahtzeeGame.getPlayers();
    }

    public Scoreboard getScoreBoard(int playerId) {
        /*Scoreboard scoreboard = null;
        for (Player player : yahtzeeGame.getPlayers()) {
            if (player.getId() == playerId) {
                scoreboard = player.getScoreboard();
                break;
            }
        }*/
        Scoreboard result = yahtzeeGame.getPlayers().get(playerId - 1).getScoreboard();
        return result;
    }

    public void processDecision(String rowLabel, String section, int playerId) {
        scoreService.processDecision(rowLabel, section, playerId);
    }

    public DiceSetResponse getDiceSetResponse() {
        return diceSetResponse;
    }
}

package de.adesso.alissa.yahtzee.service;

import de.adesso.alissa.yahtzee.game.elements.*;
import de.adesso.alissa.yahtzee.game.YahtzeeGame;
import de.adesso.alissa.yahtzee.game.enums.Avatar;

import java.util.ArrayList;

/**
 * The YahtzeeGameService serves as the service class for the whole game.
 */
public class YahtzeeGameService {

    private static YahtzeeGameService yahtzeeGameService =  null;
    private final YahtzeeGame yahtzeeGame;
    private final DiceSetService diceSetService;
    private final ScoreTableService scoreTableService;
    private DiceSetResponse diceSetResponse;
    private final ScoreService scoreService;
    private final DiceSetResponseService diceSetResponseService;
    private final PointsCalculatorService pointsCalculatorService;


    /**
     * Gets instance.
     *
     * @return the instance
     */
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


    /**
     * Gets score table upper section.
     *
     * @return the score table upper section
     */
    public ArrayList<ScoreTableRow> getScoreTableUpperSection() {
        return yahtzeeGame.getTable().getUpperSection();
    }

    /**
     * Gets score table lower section.
     *
     * @return the score table lower section
     */
    public ArrayList<ScoreTableRow> getScoreTableLowerSection() {
        return yahtzeeGame.getTable().getLowerSection();
    }

    /**
     * Get dice icons sources string [ ].
     *
     * @return the string [ ]
     */
    public String[] getDiceIconsSources() {
        return this.diceSetService.getDiceSourceImages();
    }

    /**
     * Process dice set selection dice set response.
     *
     * @param selectedDices the selected dices
     * @return the dice set response
     */
    public DiceSetResponse processDiceSetSelection(final boolean[] selectedDices) {
        this.diceSetResponse = diceSetResponseService.createDiceSetResponse(pointsCalculatorService, diceSetService, selectedDices);
        return this.diceSetResponse;
    }

    /**
     * Initialize players.
     *
     * @param playersNames the players names
     */
    public void initializePlayers(String[] playersNames) {
        Player[] players = new Player[playersNames.length];

        for (int index = 0; index < playersNames.length; index++) {
            Player player = new Player();
            player.setName(playersNames[index]);
            player.setAvatarIconSource(Avatar.getNextAvatar(player.getId() - 1).getValue());
            players[index] = player;

            if (index == 0) {
                player.setCurrentPlayer(true);
            }
        }
        yahtzeeGame.setPlayers(players);
        createResultElements();
    }

    /**
     * Initialize table.
     */
    public void initializeTable() {
        yahtzeeGame.setScoreTable(scoreTableService.createTable());
    }

    /**
     * Get players player [ ].
     *
     * @return the player [ ]
     */
    public Player[] getPlayers() {
        return yahtzeeGame.getPlayers();
    }

    /**
     * Gets score board.
     *
     * @param playerId the player id
     * @return the score board
     */
    public Scoreboard getScoreBoard(int playerId) {
        for (Player player : yahtzeeGame.getPlayers()) {
            if (player.getId() == playerId) {
                return player.getScoreboard();
            }
        }
        return null;
    }

    /**
     * Process decision.
     *
     * @param rowLabel the row label
     * @param section  the section
     * @param playerId the player id
     */
    public void processDecision(String rowLabel, String section, int playerId) {
        scoreService.processDecision(rowLabel, section, playerId);
    }

    /**
     * Gets dice set response.
     *
     * @return the dice set response
     */
    public DiceSetResponse getDiceSetResponse() {
        return diceSetResponse;
    }

    /**
     * Gets next player.
     *
     * @param playerId the player id
     * @return the next player
     */
    public int getNextPlayer(int playerId) {
        int nextPlayerId;
        if (playerId + 1 > yahtzeeGame.getPlayers().length) {
            nextPlayerId = 1;
        } else {
            nextPlayerId = playerId + 1;
        }
        yahtzeeGame.getPlayers()[playerId - 1].setCurrentPlayer(false);
        yahtzeeGame.getPlayers()[nextPlayerId -1].setCurrentPlayer(true);
        return nextPlayerId;
    }

    public void createResultElements() {
        ResultElement[] resultElements = new ResultElement[yahtzeeGame.getPlayers().length];
        for (int index = 0; index < yahtzeeGame.getPlayers().length; index++) {
            resultElements[index] = new ResultElement(yahtzeeGame.getPlayers()[index].getName(), getTotalPoints(yahtzeeGame.getPlayers()[index].getName()));
        }
        yahtzeeGame.setResultElements(resultElements);
    }

    public ResultElement[] getResultElements() {
        return yahtzeeGame.getResultElements();
    }

    public ResultElement[] rankPlayers() {
        createResultElements();
        for (int indexI = 0; indexI < yahtzeeGame.getPlayers().length - 1; indexI++) {
            for (int indexJ = 0; indexJ < yahtzeeGame.getPlayers().length - indexI - 1; indexJ++) {
                if (yahtzeeGame.getResultElements()[indexJ].getTotalPoints() < yahtzeeGame.getResultElements()[indexJ + 1].getTotalPoints()) {
                    ResultElement resultElement = yahtzeeGame.getResultElements()[indexJ];
                    yahtzeeGame.getResultElements()[indexJ] = yahtzeeGame.getResultElements()[indexJ + 1];
                    yahtzeeGame.getResultElements()[indexJ + 1] = resultElement;
                }
            }
        }
        return yahtzeeGame.getResultElements();
    }

    public int getTotalPoints(String name) {
        int result = 0;
        for (Player player : yahtzeeGame.getPlayers()) {
            if (player.getName().equals(name)) {
                result = player.getScoreboard().getTotalLowerSection()[2];
                break;
            }
        }
        return result;
    }

    public boolean checkEndOfGame() {
        Player player = yahtzeeGame.getPlayers()[yahtzeeGame.getPlayers().length - 1];
        for (ScoreElement scoreElement : player.getScoreboard().getUpperSection()) {
            if (!scoreElement.isSelected()) {
                return false;
            }
        }

        for (ScoreElement scoreElement : player.getScoreboard().getLowerSection()) {
            if (!scoreElement.isSelected()) {
                return false;
            }
        }

        return true;
    }
}

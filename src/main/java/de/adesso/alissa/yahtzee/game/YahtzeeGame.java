package de.adesso.alissa.yahtzee.game;

import de.adesso.alissa.yahtzee.game.elements.DiceSet;
import de.adesso.alissa.yahtzee.game.elements.Player;
import de.adesso.alissa.yahtzee.game.elements.ResultElement;
import de.adesso.alissa.yahtzee.game.elements.ScoreTable;

/**
 * The type YahtzeeGame which serves as the basis class for the whole game.
 */
public class YahtzeeGame {
    private static YahtzeeGame yahtzeeGame = null;
    private Player[] players;
    private DiceSet diceSet;
    private ScoreTable scoreTable;
    private ResultElement[] resultElements;

    /**
     * Instantiates a new Yahtzee game.
     */
    public YahtzeeGame() {
        this.players = new Player[8];
        this.diceSet = DiceSet.getInstance();
        this.scoreTable = new ScoreTable();
        this.resultElements = new ResultElement[8];
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static YahtzeeGame getInstance() {
        if (yahtzeeGame == null) {
            yahtzeeGame = new YahtzeeGame();
        }
        return yahtzeeGame;
    }

    /**
     * Get players player [ ].
     *
     * @return the player [ ]
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Gets dice set.
     *
     * @return the dice set
     */
    public DiceSet getDiceSet() {
        return diceSet;
    }

    /**
     * Gets table.
     *
     * @return the table
     */
    public ScoreTable getTable() {
        return scoreTable;
    }

    /**
     * Sets players.
     *
     * @param players the players
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * Sets dice set.
     *
     * @param diceSet the dice set
     */
    public void setDiceSet(DiceSet diceSet) {
        this.diceSet = diceSet;
    }

    /**
     * Sets score table.
     *
     * @param scoreTable the score table
     */
    public void setScoreTable(ScoreTable scoreTable) {
        this.scoreTable = scoreTable;
    }

    /**
     * Get result elements result element [ ].
     *
     * @return the result element [ ]
     */
    public ResultElement[] getResultElements() {
        return resultElements;
    }

    /**
     * Sets result elements.
     *
     * @param resultElements the result elements
     */
    public void setResultElements(ResultElement[] resultElements) {
        this.resultElements = resultElements;
    }
}

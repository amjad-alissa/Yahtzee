package de.adesso.alissa.yahtzee.game.elements;

/**
 * The type Result element.
 */
public class ResultElement {
    private final String playerName;
    private final int totalPoints;

    /**
     * Instantiates a new Result element.
     *
     * @param playerName  the player name
     * @param totalPoints the total points
     */
    public ResultElement(String playerName, int totalPoints) {
        this.playerName = playerName;
        this.totalPoints = totalPoints;
    }

    /**
     * Gets player name.
     *
     * @return the player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Gets total points.
     *
     * @return the total points
     */
    public int getTotalPoints() {
        return totalPoints;
    }
}

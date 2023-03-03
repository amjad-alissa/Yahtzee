package de.adesso.alissa.yahtzee.game.elements;

/**
 * The type Dice set response which serves as the response for the request for generating a random dice set.
 */
public class DiceSetResponse {
    private int[] pointsUpperSection;
    private int[] pointsLowerSection;
    private String[] diceIconSource;


    /**
     * Get points upper section int [ ].
     *
     * @return the int [ ]
     */
    public int[] getPointsUpperSection() {
        return pointsUpperSection;
    }

    /**
     * Sets points upper section.
     *
     * @param pointsUpperSection the points upper section
     */
    public void setPointsUpperSection(int[] pointsUpperSection) {
        this.pointsUpperSection = pointsUpperSection;
    }

    /**
     * Get points lower section int [ ].
     *
     * @return the int [ ]
     */
    public int[] getPointsLowerSection() {
        return pointsLowerSection;
    }

    /**
     * Sets points lower section.
     *
     * @param pointsLowerSection the points lower section
     */
    public void setPointsLowerSection(int[] pointsLowerSection) {
        this.pointsLowerSection = pointsLowerSection;
    }

    /**
     * Get dice icon source string [ ].
     *
     * @return the string [ ]
     */
    public String[] getDiceIconSource() {
        return diceIconSource;
    }

    /**
     * Sets dice icon source.
     *
     * @param diceIconSource the dice icon source
     */
    public void setDiceIconSource(String[] diceIconSource) {
        this.diceIconSource = diceIconSource;
    }
}

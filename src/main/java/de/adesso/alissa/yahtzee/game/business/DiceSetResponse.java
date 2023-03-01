package de.adesso.alissa.yahtzee.game.business;

/**
 * The type Response data.
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
     * Get dice source images string [ ].
     *
     * @return the string [ ]
     */
    public String[] getDiceIconSource() {
        return diceIconSource;
    }

    /**
     * Sets dice source images.
     *
     * @param diceIconSource the dice source images
     */
    public void setDiceIconSource(String[] diceIconSource) {
        this.diceIconSource = diceIconSource;
    }
}

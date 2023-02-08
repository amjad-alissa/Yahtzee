package de.adesso.alissa.yahtzee.game.business;

/**
 * The type Response data.
 */
public class ResponseData {
    private int[] pointsUpperSection;
    private int[] pointsLowerSection;
    private String[] diceSourceImages;

    /**
     * Instantiates a new Response data.
     */
    public ResponseData() {
    }

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
    public String[] getDiceSourceImages() {
        return diceSourceImages;
    }

    /**
     * Sets dice source images.
     *
     * @param diceSourceImages the dice source images
     */
    public void setDiceSourceImages(String[] diceSourceImages) {
        this.diceSourceImages = diceSourceImages;
    }
}

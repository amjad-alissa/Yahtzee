package de.adesso.alissa.yahtzee.game.enums;

/**
 * The enum Label for the ScoreTable.
 */
public enum Label {
    /**
     * Ones label.
     */
    ONES("Ones"),
    /**
     * Tows label.
     */
    TOWS("Tows"),
    /**
     * Threes label.
     */
    THREES("Threes"),
    /**
     * Fours label.
     */
    FOURS("Fours"),
    /**
     * Fives label.
     */
    FIVES("Fives"),
    /**
     * Sixes label.
     */
    SIXES("Sixes"),

    /**
     * Three same label.
     */
    THREE_SAME("Three-Same"),
    /**
     * Four same label.
     */
    FOUR_SAME("Four-Same"),
    /**
     * Full house label.
     */
    FULL_HOUSE("Full-House"),
    /**
     * Small street label.
     */
    SMALL_STREET("Small-Straight"),
    /**
     * Big street label.
     */
    BIG_STREET("Large-Straight"),

    /**
     * Yahtzee label.
     */
    YAHTZEE("YAHTZEE"),
    /**
     * Chance label.
     */
    CHANCE("Chance");

    private final String value;

    Label(final String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

}

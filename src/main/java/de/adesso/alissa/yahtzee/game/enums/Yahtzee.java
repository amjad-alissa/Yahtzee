package de.adesso.alissa.yahtzee.game.enums;

/**
 * The enum Yahtzee.
 */
public enum Yahtzee {
    /**
     * Number of dices.
     */
    NUMBER_OF_DICES(5),
    /**
     * Full house points.
     */
    FULL_HOUSE_POINTS(25),
    /**
     * Small street points.
     */
    SMALL_STREET_POINTS(30),
    /**
     * Bonus points yahtzee.
     */
    BONUS_POINTS(35),
    /**
     * Big street points.
     */
    BIG_STREET_POINTS(40),
    /**
     * Yahtzee points.
     */
    YAHTZEE_POINTS(50),
    /**
     * Lower section rows.
     */
    LOWER_SECTION_ROWS(7),
    /**
     * Upper section rows.
     */
    UPPER_SECTION_ROWS(6);

    private final int value;
    Yahtzee(final int value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return this.value;
    }
}

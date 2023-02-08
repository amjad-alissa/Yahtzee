package de.adesso.alissa.yahtzee.game.elements;

/**
 * The type Dice.
 */
public class Dice {
    private final int value;
    private final String iconSource;

    /**
     * Instantiates a new Dice.
     *
     * @param value      the value
     * @param iconSource the path
     */
    public Dice(final int value, final String iconSource) {
        this.value = value;
        this.iconSource = iconSource;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Gets path.
     *
     * @return the path
     */
    public String getIconSource() {
        return this.iconSource;
    }
}

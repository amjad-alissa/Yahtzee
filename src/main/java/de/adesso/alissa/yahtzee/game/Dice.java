package de.adesso.alissa.yahtzee.game;

/**
 * The type Dice.
 */
public class Dice {
    private final int value;
    private final String path;
    private boolean selected = false;

    /**
     * Instantiates a new Dice.
     *
     * @param value the value
     * @param path  the path
     */
    public Dice(final int value, final String path) {
        this.value = value;
        this.path = path;
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
    public String getPath() {
        return this.path;
    }

    /**
     * Is selected boolean.
     *
     * @return the boolean
     */
    public boolean isSelected() {
        return this.selected;
    }

    /**
     * Sets selected.
     *
     * @param selected the selected
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}

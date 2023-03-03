package de.adesso.alissa.yahtzee.game.enums;

/**
 * The enum RedDiceIconSource for the red dice.
 */
public enum RedDiceIconSource {

    /**
     * dice icon source One .
     */
    ONE("/media/dice/one-red.png"),
    /**
     * dice icon source Two .
     */
    TWO("/media/dice/two-red.png"),
    /**
     * dice icon source Three .
     */
    THREE("/media/dice/three-red.png"),
    /**
     * dice icon source Four .
     */
    FOUR("/media/dice/four-red.png"),
    /**
     * dice icon source Five .
     */
    FIVE("/media/dice/five-red.png"),
    /**
     * dice icon source Six .
     */
    SIX("/media/dice/six-red.png");

    private final String iconSource;

    RedDiceIconSource(final String iconSource) {
        this.iconSource = iconSource;
    }

    /**
     * Gets icon source.
     *
     * @return the icon source
     */
    public String getIconSource() {
        return this.iconSource;
    }
}

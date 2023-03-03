package de.adesso.alissa.yahtzee.game.enums;

/**
 * The enum YellowDiceIconSource for the yellow dice.
 */
public enum YellowDiceIconSource {
    /**
     * Dice three png yellow dice icon source.
     */
    DICE_THREE_PNG ("/media/dice/three.png"),
    /**
     * Dice one png yellow dice icon source.
     */
    DICE_ONE_PNG("/media/dice/one.png"),
    /**
     * Dice two png yellow dice icon source.
     */
    DICE_TWO_PNG("/media/dice/two.png"),
    /**
     * Dice four png yellow dice icon source.
     */
    DICE_FOUR_PNG ("/media/dice/four.png"),
    /**
     * Dice five png yellow dice icon source.
     */
    DICE_FIVE_PNG ("/media/dice/five.png"),
    /**
     * Dice six png yellow dice icon source.
     */
    DICE_SIX_PNG ("/media/dice/six.png");

    private final String iconSource;

    YellowDiceIconSource(final String iconSource) {
        this.iconSource = iconSource;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return this.iconSource;
    }
}

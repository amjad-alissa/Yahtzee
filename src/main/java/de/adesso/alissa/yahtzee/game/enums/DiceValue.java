package de.adesso.alissa.yahtzee.game.enums;

/**
 * The enum Dice value representing the possible six values of a dice.
 */
public enum DiceValue {
    /**
     * dice value One .
     */
    ONE(1),
    /**
     * dice value Two .
     */
    TWO(2),
    /**
     * dice value Three .
     */
    THREE(3),
    /**
     * dice value Four .
     */
    FOUR(4),
    /**
     * dice value Five .
     */
    FIVE(5),
    /**
     * dice value Six .
     */
    SIX(6);
    private final int value;

    DiceValue(final int diceValue) {
        this.value = diceValue;
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

package de.adesso.alissa.yahtzee.game.enums;

import de.adesso.alissa.yahtzee.game.elements.Dice;

import java.security.SecureRandom;
import java.util.Random;


/**
 * The type DiceEnum to represents the six possible dices as Dice obj with value and icon's source.
 */
public class DiceEnum {
    /**
     * The constantDice ONE.
     */
    private static final Dice ONE = new Dice(DiceValue.ONE.getValue(), DiceIconSource.ONE.getIconSource());
    /**
     * The constantDice TWO.
     */
    private static final Dice TWO = new Dice(DiceValue.TWO.getValue(), DiceIconSource.TWO.getIconSource());
    /**
     * The constantDice THREE.
     */
    private static final Dice THREE = new Dice(DiceValue.THREE.getValue(), DiceIconSource.THREE.getIconSource());
    /**
     * The constantDice FOUR.
     */
    private static final Dice FOUR = new Dice(DiceValue.FOUR.getValue(), DiceIconSource.FOUR.getIconSource());
    /**
     * The constantDice FIVE.
     */
    private static final Dice FIVE = new Dice(DiceValue.FIVE.getValue(), DiceIconSource.FIVE.getIconSource());
    /**
     * The constantDice SIX.
     */
    private static final Dice SIX = new Dice(DiceValue.SIX.getValue(), DiceIconSource.SIX.getIconSource());

    private static final Random randomGenerator = new SecureRandom();

    // private constructor to simulate an Enum
    private DiceEnum() {}

    /**
     * Generate a random dice.
     *
     * @return the dice
     */
    public static Dice randomDice() {
        Dice[] dices = {ONE, TWO, THREE, FOUR, FIVE, SIX};
        return dices[randomGenerator.nextInt(dices.length)];
    }
}

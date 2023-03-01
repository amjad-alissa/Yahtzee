package de.adesso.alissa.yahtzee.game.elements;

import de.adesso.alissa.yahtzee.game.enums.DiceEnum;
import de.adesso.alissa.yahtzee.game.enums.Yahtzee;

/**
 * The Singleton type DiceSet represents the set of (5) dices.
 */
public class DiceSet {

    // Singleton instance
    private static DiceSet diceSet = null;
    private final Dice[] dices;

    /**
     * Instantiates a new DiceSet.
     */
    private DiceSet() {
        this.dices = new Dice[Yahtzee.NUMBER_OF_DICES.getValue()];
        this.initializeDices();
    }

    /**
     * Get the Singleton instance
     * @return an instance of the type DiceSet
     */
    public static DiceSet getInstance() {
        if (diceSet == null) {
            diceSet = new DiceSet();
        }
        return diceSet;
    }

    /**
     * Initialize the first set of dices with a randomly generated dices.
     */
    public void initializeDices() {
        for (int index = 0; index < this.dices.length; index++) {
            this.dices[index] = DiceEnum.randomDice();
        }
    }

    /**
     * Get dices [ ].
     *
     * @return the dice [ ]
     */
    public Dice[] getDices() {
        return dices;
    }
}

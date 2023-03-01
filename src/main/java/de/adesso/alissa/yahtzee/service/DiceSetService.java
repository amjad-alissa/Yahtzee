package de.adesso.alissa.yahtzee.service;

import de.adesso.alissa.yahtzee.game.elements.DiceSet;
import de.adesso.alissa.yahtzee.game.enums.DiceEnum;
import de.adesso.alissa.yahtzee.game.enums.Yahtzee;

public class DiceSetService {

    private final DiceSet diceSet;

    public DiceSetService(DiceSet diceSet) {
        this.diceSet = diceSet;
    }

    /**
     * Get values of the current set of dices.
     *
     * @return int array with the corresponding values
     */
    public int[] getDiceValues() {
        int[] diceValues = new int[Yahtzee.NUMBER_OF_DICES.getValue()];
        for (int index = 0; index < this.diceSet.getDices().length; index++) {
            diceValues[index] = this.diceSet.getDices()[index].getValue();
        }
        return diceValues;
    }

    /**
     * Get icon's source of the current set of dices.
     *
     * @return array with the corresponding icon's source
     */
    public String[] getDiceSourceImages() {
        String[] diceIconsSources = new String[Yahtzee.NUMBER_OF_DICES.getValue()];
        for (int index = 0; index < this.diceSet.getDices().length; index++) {
            diceIconsSources[index] = this.diceSet.getDices()[index].getIconSource();
        }
        return diceIconsSources;
    }

    /**
     * Update selected dices based on the array passed from AJAX.
     *
     * @param selectedDices passed from AJAX with boolean values for each dice in the set, whether dice was selected
     */
    public void updateSelectedDices(final boolean[] selectedDices) {
        for (int index = 0; index < this.diceSet.getDices().length; index++) {
            if (!selectedDices[index]) {
                this.diceSet.getDices()[index] = DiceEnum.randomDice();
            }
        }
    }
}

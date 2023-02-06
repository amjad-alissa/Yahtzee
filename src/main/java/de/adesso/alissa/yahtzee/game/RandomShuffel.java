package de.adesso.alissa.yahtzee.game;

import java.util.ArrayList;

/**
 * The type Random shuffel.
 */
public class RandomShuffel {
    private int shuffelCount;
    private final ArrayList<RandomDice> randomDices;

    /**
     * Instantiates a new Random shuffel.
     */
    public RandomShuffel() {
        this.shuffelCount = 3;
        this.randomDices = new ArrayList<>();
        this.randomDices.add(new RandomDice(1));
        this.randomDices.add(new RandomDice(2));
        this.randomDices.add(new RandomDice(3));
        this.randomDices.add(new RandomDice(4));
        this.randomDices.add(new RandomDice(5));
    }

    /**
     * Generate radom shuffel.
     */
    public void generateRadomShuffel() {
        if (this.shuffelCount > 0 && this.shuffelCount <= 3) {
            this.shuffelCount--;
            for (RandomDice randomDice : this.randomDices) {
                if (!randomDice.getDice().isSelected()) {
                    randomDice.setDice(RandomDice.getRandomDice());
                }
            }
        }
    }

    public ArrayList<RandomDice> getRandomDices() {
        return randomDices;
    }

    public void updateSelectedDices(boolean[] selectedDices) {
        for (int i = 0; i < selectedDices.length; i++) {
            RandomDice randomDice = this.randomDices.get(i);
            if (selectedDices[i]) {
                randomDice.setCheckMarkSelected("checkmark-selected");
                randomDice.getDice().setSelected(selectedDices[i]);
            } else {
                randomDice.setCheckMarkSelected("");
                randomDice.getDice().setSelected(selectedDices[i]);
            }
        }
    }
}

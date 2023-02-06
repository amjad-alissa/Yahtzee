package de.adesso.alissa.yahtzee.game;

import java.util.Random;

/**
 * The type Random dice.
 */
public class RandomDice {

    private static final Dice ONE = new Dice(1, "/media/dice/one-red.png");
    private static final Dice TWO = new Dice(2, "/media/dice/two-red.png");
    private static final Dice THREE = new Dice(3, "/media/dice/three-red.png");
    private static final Dice FOUR = new Dice(4, "/media/dice/four-red.png");
    private static final Dice FIVE = new Dice(5, "/media/dice/five-red.png");
    private static final Dice SIX = new Dice(6, "/media/dice/six-red.png");
    private static final Random RANDOM = new Random();
    private final int id;
    private Dice dice;

    private String checkMarkSelected;


    /**
     * Instantiates a new Random dice.
     *
     * @param id the id
     */
    public RandomDice(int id) {
        this.id = id;
        this.dice = getRandomDice();
        this.checkMarkSelected = "";
    }

    /**
     * Generate a random dice
     *
     * @return the random dice
     */
    public static Dice getRandomDice() {
        int randomValue = RANDOM.nextInt(1, 7);
        switch (randomValue) {
            case 1 -> {
                return ONE;
            }
            case 2 -> {
                return TWO;
            }
            case 3 -> {
                return THREE;
            }
            case 4 -> {
                return FOUR;
            }
            case 5 -> {
                return FIVE;
            }
            case 6 -> {
                return SIX;
            }
            default -> {
                return null;

            }
        }
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets dice.
     *
     * @return the dice
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * Sets dice.
     *
     * @param dice the dice
     */
    public void setDice(Dice dice) {
        this.dice = dice;
    }

    /**
     * Sets check mark selected.
     *
     * @param checkMarkSelected the check mark selected
     */
    public void setCheckMarkSelected(String checkMarkSelected) {
        this.checkMarkSelected = checkMarkSelected;
    }

    /**
     * Gets check mark selected.
     *
     * @return the check mark selected
     */
    public String getCheckMarkSelected() {
        return checkMarkSelected;
    }
}

package de.adesso.alissa.yahtzee.game.business;

import de.adesso.alissa.yahtzee.game.enums.DiceValue;
import de.adesso.alissa.yahtzee.game.enums.Yahtzee;

import java.util.HashMap;
import java.util.Map;


/**
 * The Singleton type PointsCalculator to calculate the points for each section of the score block.
 */
public class PointsCalculator {

    // Singleton instance
    private static PointsCalculator pointsCalculator = null;

    private PointsCalculator() {}

    /**
     * Gets the singleton instance.
     *
     * @return the singleton instance
     */
    public static PointsCalculator getInstance() {
        if (pointsCalculator == null) {
            pointsCalculator = new PointsCalculator();
        }
        return pointsCalculator;
    }

    /**
     * Calculate the points for the upper section of the score board
     *
     * @param diceValues the values of the dice Set selected by the player
     * @return array with the points for each row in the upper section array[0] points for ones, array[1] points for ones, .....
     */
    public int[] calculateResultsForUpperSection(final int[] diceValues) {
        int[] upperSectionPoints = new int[Yahtzee.UPPER_SECTION_ROWS.getValue()];

        for (int index = DiceValue.ONE.getValue(); index <= DiceValue.SIX.getValue(); index++) {
            upperSectionPoints[index - 1] = this.calculatePointsForSimilarValues(index, diceValues);
        }

        return upperSectionPoints;
    }

    /**
     * Calculate the points for the Ones, Tows, threes, ...
     *
     * @param diceValue  which diceValue to look for
     * @param diceValues the diceValues of the dice Set
     * @return the total points of the for the specified dice Value
     */
    private int calculatePointsForSimilarValues(final int diceValue, final int[] diceValues) {
        int counter = 0;

        for (int index = 0; index < diceValues.length; index++) {
            if (diceValues[index] == diceValue) {
                counter++;
            }
        }

        return counter * diceValue;
    }

    /**
     * Calculate the points for the upper section of the score board
     *
     * @param diceValues the values of the dice Set selected by the player
     * @return array with the points for each row in the upper section         array[0] points for Three the same, array[1] points for Four the same, .....
     */
    public int[] calculateResultsForLowerSection(final int[] diceValues) {
        int[] lowerSectionPoints = new int[Yahtzee.LOWER_SECTION_ROWS.getValue()];

        for (int index = 0; index < lowerSectionPoints.length; index++) {

            int points = 0;

            switch (index) {
                case 0 -> {
                    // Three the same
                    if (checkNumberOfOccurrences(DiceValue.THREE.getValue(), diceValues)) {
                        points = sumValues(diceValues);
                    }
                }
                // Four the same
                case 1 -> {
                    if (checkNumberOfOccurrences(DiceValue.FOUR.getValue(), diceValues)) {
                        points = sumValues(diceValues);
                    }
                }
                // Full House
                case 2 -> {
                    if (checkFullHouse(diceValues)) {
                        points = Yahtzee.FULL_HOUSE_POINTS.getValue();
                    }
                }
                // Small street
                case 3 -> {
                    if (checkSmallStreet(diceValues)) {
                        points = Yahtzee.SMALL_STREET_POINTS.getValue();
                    }
                }
                // Big street
                case 4 -> {
                    if (checkBigStreet(diceValues)) {
                        points = Yahtzee.BIG_STREET_POINTS.getValue();
                    }
                }
                // Yahtzee
                case 5 -> {
                    if (checkNumberOfOccurrences(DiceValue.FIVE.getValue(), diceValues)) {
                        points = Yahtzee.YAHTZEE_POINTS.getValue();
                    }
                }
                // Chance
                case 6 -> points = sumValues(diceValues);

                default -> throw new IllegalStateException("Unexpected value: " + index);
            }
            lowerSectionPoints[index] = points;
        }

        return lowerSectionPoints;
    }

    /**
     * Checks whether in @param diceValues exist a value with exact or more than @param numberOfOccurrences
     * @param numberOfOccurrences the frequency of value to look for
     * @param diceValues the values of the dice Set selected by the player
     * @return true if a value exist with exact or more than numberOfOccurrences
     */
    private boolean checkNumberOfOccurrences(final int numberOfOccurrences, final int[] diceValues) {

        // Loop through diceValues and see how many times a value exist (counter)
        // Then compare (counter) with the provided param (numberOfOccurrences)
        for (int value : diceValues) {
            int counter = 0;

            for (int secondValue : diceValues) {
                if (value == secondValue) {
                    counter++;
                }
            }

            if (counter >= numberOfOccurrences) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sum the total points which exist in diceValues
     *
     * @param diceValues the values of the dice Set selected by the player
     * @return the total points which exist in diceValues
     */
    public int sumValues(final int[] diceValues) {
        int total = 0;

        for (int value : diceValues) {
            total += value;
        }

        return total;
    }

    /**
     * Check if the diceValues has two values with frequency two and three
     * @param diceValues the values of the dice Set selected by the player
     * @return
     */
    private boolean checkFullHouse(final int[] diceValues) {
        Map<Integer, Integer> diceValueFrequency = calculateDiceValueFrequencies(diceValues);

        boolean frequencyTwo = false;
        boolean frequencyThree = false;

        for (Integer key: diceValueFrequency.keySet()) {
            if (diceValueFrequency.get(key) == DiceValue.TWO.getValue()) {
                frequencyTwo = true;
            } else if (diceValueFrequency.get(key) == DiceValue.THREE.getValue()) {
                frequencyThree = true;
            }
        }

        return frequencyTwo && frequencyThree;
    }

    /**
     * Calculate the frequency for each possible value of dice (1 - 6)
     * @param diceValues the values of the dice Set selected by the player
     * @return a Map with each value and its frequency
     */
    private Map<Integer, Integer> calculateDiceValueFrequencies(final int[] diceValues) {
        Map<Integer, Integer> diceValueFrequency = new HashMap<>();

        // loop through the six possible values for dice
        for (int value = DiceValue.ONE.getValue(); value <= DiceValue.SIX.getValue(); value++) {

            // loop through diceValues and count the frequency for each value
            int counter = 0;
            for (int index = 0; index < diceValues.length; index++) {
                if (value == diceValues[index]) {
                    counter++;
                }
            }
            // store the value with the corresponding frequency
            diceValueFrequency.put(value, counter);
        }
        return diceValueFrequency;
    }

    /**
     * Map for each possible value of dice (1 - 6) if it exists in diceValues
     * @param diceValues the values of the dice Set selected by the player
     * @return array with the values if they exist or not
     */
    private boolean[] mapDiceValuesToBoolean(final int[] diceValues) {
        boolean[] valuesExist = new boolean[DiceValue.SIX.getValue()];
        Map<Integer, Integer> diceValueFrequency = calculateDiceValueFrequencies(diceValues);

        for (int index = 0; index < valuesExist.length; index++) {
            // a dice value exist if its frequency > 0
            valuesExist[index] = diceValueFrequency.get(index + 1) > 0;
        }

        return valuesExist;
    }

    /**
     * Check if diceValues satisfy the conditions for small street
     * @param diceValues the values of the dice Set selected by the player
     * @return whether the conditions for a small street is met
     */
    private boolean checkSmallStreet(final int[] diceValues) {
        boolean[] valuesExist = mapDiceValuesToBoolean(diceValues);

        // 1 - 4
        boolean oneToFour = valuesExist[DiceValue.ONE.getValue() - 1] &&
                            valuesExist[DiceValue.TWO.getValue() - 1] &&
                            valuesExist[DiceValue.THREE.getValue() - 1] &&
                            valuesExist[DiceValue.FOUR.getValue() - 1];

        // 2 - 5
        boolean twoToFive = valuesExist[DiceValue.TWO.getValue() - 1] &&
                            valuesExist[DiceValue.THREE.getValue() - 1] &&
                            valuesExist[DiceValue.FOUR.getValue() - 1] &&
                            valuesExist[DiceValue.FIVE.getValue() - 1];

        // 3 - 6
        boolean threeToSix = valuesExist[DiceValue.THREE.getValue() - 1] &&
                             valuesExist[DiceValue.FOUR.getValue() - 1] &&
                             valuesExist[DiceValue.FIVE.getValue() - 1] &&
                             valuesExist[DiceValue.SIX.getValue() - 1];

        return oneToFour || twoToFive || threeToSix;
    }

    /**
     * Check if diceValues satisfy the conditions for big street
     * @param diceValues the values of the dice Set selected by the player
     * @return whether the conditions for a big street is met
     */
    private boolean checkBigStreet(final int[] diceValues) {
        boolean[] valuesExist = mapDiceValuesToBoolean(diceValues);

        // 1 - 5
        boolean oneToFive = valuesExist[DiceValue.ONE.getValue() - 1] &&
                            valuesExist[DiceValue.TWO.getValue() - 1] &&
                            valuesExist[DiceValue.THREE.getValue() - 1] &&
                            valuesExist[DiceValue.FOUR.getValue() - 1] &&
                            valuesExist[DiceValue.FIVE.getValue() - 1];

        // 2 - 6
        boolean twoToSix = valuesExist[DiceValue.TWO.getValue() - 1] &&
                           valuesExist[DiceValue.THREE.getValue() - 1] &&
                           valuesExist[DiceValue.FOUR.getValue() - 1] &&
                           valuesExist[DiceValue.FIVE.getValue() - 1]&&
                           valuesExist[DiceValue.SIX.getValue() - 1];

        return oneToFive || twoToSix;
    }
}

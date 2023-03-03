package de.adesso.alissa.yahtzee.service;

import de.adesso.alissa.yahtzee.game.elements.ScoreElement;
import de.adesso.alissa.yahtzee.game.enums.Label;

/**
 * The ScoreElementService to create the score elements for the scoreboard for each player .
 */
public class ScoreElementService {

    private ScoreElementService() {
    }

    /**
     * Get upper score section score element [ ].
     *
     * @return the score element [ ]
     */
    public static ScoreElement[] getUpperScoreSection() {
        ScoreElement ONES = new ScoreElement(Label.ONES.getValue());
        ScoreElement TOWS = new ScoreElement(Label.TOWS.getValue());
        ScoreElement THREES = new ScoreElement(Label.THREES.getValue());
        ScoreElement FOURS = new ScoreElement(Label.FOURS.getValue());
        ScoreElement FIVES = new ScoreElement(Label.FIVES.getValue());
        ScoreElement SIXES = new ScoreElement(Label.SIXES.getValue());
        return new ScoreElement[]{ONES, TOWS, THREES, FOURS, FIVES, SIXES};
    }

    /**
     * Get lower score section score element [ ].
     *
     * @return the score element [ ]
     */
    public static ScoreElement[] getLowerScoreSection() {
        ScoreElement THREE_SAME = new ScoreElement(Label.THREE_SAME.getValue());
        ScoreElement FOUR_SAME = new ScoreElement(Label.FOUR_SAME.getValue());
        ScoreElement FULL_HOUSE = new ScoreElement(Label.FULL_HOUSE.getValue());
        ScoreElement SMALL_STREET = new ScoreElement(Label.SMALL_STREET.getValue());
        ScoreElement BIG_STREET = new ScoreElement(Label.BIG_STREET.getValue());
        ScoreElement YAHTZEE = new ScoreElement(Label.YAHTZEE.getValue());
        ScoreElement CHANCE = new ScoreElement(Label.CHANCE.getValue());
        return new ScoreElement[]{THREE_SAME, FOUR_SAME, FULL_HOUSE, SMALL_STREET, BIG_STREET, YAHTZEE, CHANCE};
    }
}

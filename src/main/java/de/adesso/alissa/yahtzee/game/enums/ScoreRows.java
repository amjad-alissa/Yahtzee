package de.adesso.alissa.yahtzee.game.enums;

import de.adesso.alissa.yahtzee.game.ScoreElement;

public class ScoreRows {
    public static final ScoreElement ONES = new ScoreElement(Label.ONES.getValue());
    public static final ScoreElement TOWS = new ScoreElement(Label.TOWS.getValue());
    public static final ScoreElement THREES = new ScoreElement(Label.THREES.getValue());
    public static final ScoreElement FOURS = new ScoreElement(Label.FOURS.getValue());
    public static final ScoreElement FIVES = new ScoreElement(Label.FIVES.getValue());
    public static final ScoreElement SIXES = new ScoreElement(Label.SIXES.getValue());
    public static final ScoreElement THREE_SAME = new ScoreElement(Label.THREE_SAME.getValue());
    public static final ScoreElement FOUR_SAME = new ScoreElement(Label.FOUR_SAME.getValue());
    public static final ScoreElement FULL_HOUSE = new ScoreElement(Label.FULL_HOUSE.getValue());
    public static final ScoreElement SMALL_STREET = new ScoreElement(Label.SMALL_STREET.getValue());
    public static final ScoreElement BIG_STREET = new ScoreElement(Label.BIG_STREET.getValue());
    public static final ScoreElement YAHTZEE = new ScoreElement(Label.YAHTZEE.getValue());
    public static final ScoreElement CHANCE = new ScoreElement(Label.CHANCE.getValue());

    // Don't need objects of this class
    private ScoreRows() {}


    public static ScoreElement[] getUpperScoreSection() {
        return new ScoreElement[]{ONES, TOWS, THREES, FOURS, FIVES, SIXES};
    }

    public static ScoreElement[] getLowerScoreSection() {
        return new ScoreElement[]{THREE_SAME, FOUR_SAME, FULL_HOUSE, SMALL_STREET, BIG_STREET, YAHTZEE, CHANCE};
    }
}

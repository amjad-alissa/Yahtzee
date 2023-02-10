package de.adesso.alissa.yahtzee.game;

import de.adesso.alissa.yahtzee.game.enums.DiceValue;
import de.adesso.alissa.yahtzee.game.enums.ScoreRows;
import de.adesso.alissa.yahtzee.game.enums.Yahtzee;

public class Scoreboard {
    private final ScoreElement[] upperSection;
    private final ScoreElement[] lowerSection;

    private final int[] totalUpperSection;
    private final int[] totalLowerSection;

    public Scoreboard() {
        this.upperSection = ScoreRows.getUpperScoreSection();
        this.lowerSection = ScoreRows.getLowerScoreSection();
        this.totalUpperSection = new int[DiceValue.THREE.getValue()];
        this.totalLowerSection = new int[DiceValue.THREE.getValue()];
    }

    public ScoreElement[] getUpperSection() {
        return upperSection;
    }

    public ScoreElement[] getLowerSection() {
        return lowerSection;
    }

    public int[] getTotalUpperSection() {
        return totalUpperSection;
    }

    public int[] getTotalLowerSection() {
        return totalLowerSection;
    }

    public int[] computeTotalUpperSection() {
        int totalPoints = 0;

        for (ScoreElement element : this.upperSection) {
            totalPoints += element.getPoints();
        }

        // totalPoints
        this.totalUpperSection[0] = totalPoints;

        // Check if totalPoints is greater than 63
        if (totalPoints >= Yahtzee.POINTS_LIMIT_FOR_BONUS.getValue()) {
            this.totalUpperSection[1] = Yahtzee.BONUS_POINTS.getValue();
        }

        //totalPoints upper section after bonus
        this.totalUpperSection[2] = this.totalUpperSection[0] + this.totalUpperSection[1];

        return this.totalUpperSection;
    }

    public int[] computeTotalLowerSection() {
        int totalPoints = 0;

        for (ScoreElement element : this.lowerSection) {
            totalPoints += element.getPoints();
        }

        // totalPoints lower Section
        this.totalLowerSection[0] = totalPoints;

        // totalPoints for upper section
        this.totalLowerSection[1] = this.totalUpperSection[2];

        //totalPoints (The result)
        this.totalLowerSection[2] = this.totalLowerSection[0] + this.totalLowerSection[1];

        return this.totalLowerSection;
    }

    public int[] mapScoreElementPointsToIntegers(ScoreElement[] scoreElements) {
        int[] points = new int[scoreElements.length];
        for (int index = 0; index < points.length; index++) {
            points[index] = scoreElements[index].getPoints();
        }
        return points;
    }
}

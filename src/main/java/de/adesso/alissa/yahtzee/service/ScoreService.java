package de.adesso.alissa.yahtzee.service;

import de.adesso.alissa.yahtzee.game.CommitResponse;
import de.adesso.alissa.yahtzee.game.Player;
import de.adesso.alissa.yahtzee.game.ScoreElement;
import de.adesso.alissa.yahtzee.game.enums.DiceValue;
import de.adesso.alissa.yahtzee.game.enums.Yahtzee;

public class ScoreService {

    public CommitResponse processDecision(Player player, String tableSection, String rowLabel, int rowIndex) {

        processCommittedDecision(player, tableSection, rowLabel, rowIndex);
        int[] upperPoints = mapScoreElementPointsToIntegers(player.getScoreboard().getUpperSection());
        int[] lowerPoints = mapScoreElementPointsToIntegers(player.getScoreboard().getLowerSection());
        int[] totalUpperPoints = computeTotalUpperSection(upperPoints);
        int[] totalLowerPoints = computeTotalLowerSection(lowerPoints, upperPoints);
        return new CommitResponse(upperPoints, lowerPoints, totalUpperPoints, totalLowerPoints);
    }
    public void processCommittedDecision(Player player, String tableSection, String rowLabel, int rowIndex) {
        ScoreElement[] upperSection = player.getScoreboard().getUpperSection();
        ScoreElement[] lowerSection = player.getScoreboard().getLowerSection();
        if (tableSection.equals("upper-table")) {
//            int points =
            for (ScoreElement scoreElement : upperSection) {
                if (scoreElement.getLabel().equals(rowLabel) && !scoreElement.isSelected()) {
                    scoreElement.setSelected(true);
//                    scoreElement.setPoints(points);
                }
            }
        } else if (tableSection.equals("lower-table")) {
            for (ScoreElement scoreElement : lowerSection) {
                if (scoreElement.getLabel().equals(rowLabel) && !scoreElement.isSelected()) {
                    scoreElement.setSelected(true);
//                    scoreElement.setPoints(points);
                }
            }
        }
    }

    public int[] computeTotalUpperSection(int[] upperSectionPoints) {

        int totalPoints = 0;
        int[] points = new int[DiceValue.THREE.getValue()];
        for (int point :upperSectionPoints) {
            totalPoints += point;
        }

        // totalPoints before bonus
        points[0] = totalPoints;

        // Check if totalPoints is greater than 63
        if (totalPoints >= Yahtzee.POINTS_LIMIT_FOR_BONUS.getValue()) {
            points[1] = Yahtzee.BONUS_POINTS.getValue();
        }

        //totalPoints upper section after bonus
        points[2] = points[0] + points[1];

        return points;
    }

    public int[] computeTotalLowerSection(int[] lowerSectionPoints, int[] totalUpperSection) {

        int totalPoints = 0;
        int[] points = new int[DiceValue.THREE.getValue()];
        for (int point : lowerSectionPoints) {
            totalPoints += point;
        }

        // totalPoints lower Section
        points[0] = totalPoints;

        // totalPoints for upper section
        points[1] = totalUpperSection[2];

        //totalPoints (The result)
        points[2] = points[0] + points[1];

        return points;
    }

    public int[] mapScoreElementPointsToIntegers(ScoreElement[] scoreElements) {
        int[] points = new int[scoreElements.length];
        for (int index = 0; index < points.length; index++) {
            points[index] = scoreElements[index].getPoints();
        }
        return points;
    }
}

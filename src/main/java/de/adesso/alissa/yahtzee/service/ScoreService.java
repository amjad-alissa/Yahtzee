package de.adesso.alissa.yahtzee.service;

import de.adesso.alissa.yahtzee.game.*;
import de.adesso.alissa.yahtzee.game.elements.Player;
import de.adesso.alissa.yahtzee.game.elements.ScoreElement;
import de.adesso.alissa.yahtzee.game.enums.Yahtzee;

/**
 * The ScoreService serves as the service class for processing the decision for players.
 */
public class ScoreService {

    /**
     * Process decision.
     *
     * @param rowLabel the row label
     * @param section  the section
     * @param playerId the player id
     */
    public void processDecision(String rowLabel, String section, int playerId) {

        //Find the current player
        Player player = YahtzeeGame.getInstance().getPlayers()[playerId - 1];
        registerPoints(rowLabel, section, player);

        int[] upperPoints = mapScoreElementPointsToIntegers(player.getScoreboard().getUpperSection());
        int[] lowerPoints = mapScoreElementPointsToIntegers(player.getScoreboard().getLowerSection());

        computeTotalUpperSection(upperPoints, player);
        computeTotalLowerSection(lowerPoints, player.getScoreboard().getTotalUpperSection(), player);

    }

    /**
     * Register points in the scoreboard for the respective player.
     *
     * @param rowLabel the row label
     * @param section  the section
     * @param player   the player
     */
    public void registerPoints(String rowLabel, String section, Player player) {
        ScoreElement[] scoreSection = null;
        int[] predictedPoints = null;
        if (section.equals("upper-section")) {
            scoreSection = player.getScoreboard().getUpperSection();
            predictedPoints = YahtzeeGameService.getInstance().getDiceSetResponse().getPointsUpperSection();
        } else if (section.equals("lower-section")) {
            scoreSection = player.getScoreboard().getLowerSection();
            predictedPoints = YahtzeeGameService.getInstance().getDiceSetResponse().getPointsLowerSection();
        }
        assert scoreSection != null;
        assert predictedPoints != null;
        registerPointsForSection(rowLabel, scoreSection, predictedPoints);
    }

    /**
     * Register points for section.
     *
     * @param rowLabel        the row label
     * @param pointsSection   the points section
     * @param predictedPoints the predicted points
     */
    public void registerPointsForSection(String rowLabel, ScoreElement[] pointsSection, int[] predictedPoints) {
        for (int index = 0; index < pointsSection.length; index++) {
            if (pointsSection[index].getLabel().equals(rowLabel) && !pointsSection[index].isSelected()) {
                pointsSection[index].setSelected(true);
                pointsSection[index].setPoints(predictedPoints[index]);
                break;
            }
        }
    }

    /**
     * Compute total upper section.
     *
     * @param upperSectionPoints the upper section points
     * @param player             the player
     */
    public void computeTotalUpperSection(int[] upperSectionPoints, Player player) {

        int totalPoints = 0;
        int[] points = player.getScoreboard().getTotalUpperSection();
        for (int point : upperSectionPoints) {
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

    }

    /**
     * Compute total lower section.
     *
     * @param lowerSectionPoints the lower section points
     * @param totalUpperSection  the total upper section
     * @param player             the player
     */
    public void computeTotalLowerSection(int[] lowerSectionPoints, int[] totalUpperSection, Player player) {

        int totalPoints = 0;
        int[] points = player.getScoreboard().getTotalLowerSection();
        for (int point : lowerSectionPoints) {
            totalPoints += point;
        }

        // totalPoints lower Section
        points[0] = totalPoints;

        // totalPoints for upper section
        points[1] = totalUpperSection[2];

        //totalPoints (The result)
        points[2] = points[0] + points[1];
    }

    /**
     * Map score element points to integers int [ ].
     *
     * @param scoreElements the score elements
     * @return the int [ ]
     */
    public int[] mapScoreElementPointsToIntegers(ScoreElement[] scoreElements) {
        int[] points = new int[scoreElements.length];
        for (int index = 0; index < points.length; index++) {
            points[index] = scoreElements[index].getPoints();
        }
        return points;
    }
}

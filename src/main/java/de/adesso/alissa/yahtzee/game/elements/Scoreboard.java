package de.adesso.alissa.yahtzee.game.elements;

import de.adesso.alissa.yahtzee.game.enums.DiceValue;
import de.adesso.alissa.yahtzee.service.ScoreElementService;

/**
 * The type Scoreboard which serves as the class to store the points for each player.
 */
public class Scoreboard {
    private final ScoreElement[] upperSection;
    private final ScoreElement[] lowerSection;
    private final int[] totalUpperSection;
    private final int[] totalLowerSection;

    /**
     * Instantiates a new Scoreboard.
     */
    public Scoreboard() {
        this.upperSection = ScoreElementService.getUpperScoreSection();
        this.lowerSection = ScoreElementService.getLowerScoreSection();
        this.totalUpperSection = new int[DiceValue.THREE.getValue()];
        this.totalLowerSection = new int[DiceValue.THREE.getValue()];
    }

    /**
     * Get upper section score element [ ].
     *
     * @return the score element [ ]
     */
    public ScoreElement[] getUpperSection() {
        return upperSection;
    }

    /**
     * Get lower section score element [ ].
     *
     * @return the score element [ ]
     */
    public ScoreElement[] getLowerSection() {
        return lowerSection;
    }

    /**
     * Get total upper section int [ ].
     *
     * @return the int [ ]
     */
    public int[] getTotalUpperSection() {
        return totalUpperSection;
    }

    /**
     * Get total lower section int [ ].
     *
     * @return the int [ ]
     */
    public int[] getTotalLowerSection() {
        return totalLowerSection;
    }

}

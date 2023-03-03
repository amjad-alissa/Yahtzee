package de.adesso.alissa.yahtzee.game.elements;

import java.util.ArrayList;

/**
 * The type ScoreTableRow which serves as the visual representation as a row for the ScoreTable.
 */
public class ScoreTableRow {
    private final int id;
    private final ArrayList<String> diceIcons;
    private final String label;
    private int score = 0;
    private int predictedScore = 0;


    /**
     * Instantiates a new ScoreTable row.
     *
     * @param id        the id
     * @param diceIcons the dice icons
     * @param label     the label
     */
    public ScoreTableRow(final int id, final ArrayList<String> diceIcons, final String label) {
        this.id = id;
        this.diceIcons = diceIcons;
        this.label = label;
    }

    /**
     * Instantiates a new ScoreTable row.
     *
     * @param id             the id
     * @param diceIcons      the dice icons
     * @param label          the label
     * @param score          the score
     * @param predictedScore the predicted score
     */
    public ScoreTableRow(final int id, final ArrayList<String> diceIcons, final String label, final int score, final int predictedScore) {
        this.id = id;
        this.diceIcons = diceIcons;
        this.label = label;
        this.score = score;
        this.predictedScore = predictedScore;
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
     * Gets dice icons.
     *
     * @return the dice icons
     */
    public ArrayList<String> getDiceIcons() {
        return diceIcons;
    }

    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets predicted score.
     *
     * @return the predicted score
     */
    public int getPredictedScore() {
        return predictedScore;
    }
}

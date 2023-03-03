package de.adesso.alissa.yahtzee.game.elements;

import java.util.ArrayList;

/**
 * The type ScoreTable which serves as the visual representation for the table.
 */
public class ScoreTable {
    private ArrayList<ScoreTableRow> upperSection;
    private ArrayList<ScoreTableRow> lowerSection;

    /**
     * Instantiates a new ScoreTable.
     */
    public ScoreTable() {
        this.upperSection = new ArrayList<>();
        this.lowerSection = new ArrayList<>();
    }

    /**
     * Gets upper section.
     *
     * @return the upper section
     */
    public ArrayList<ScoreTableRow> getUpperSection() {
        return upperSection;
    }

    /**
     * Gets lower section.
     *
     * @return the lower section
     */
    public ArrayList<ScoreTableRow> getLowerSection() {
        return lowerSection;
    }

    /**
     * Sets upper section.
     *
     * @param upperSection the upper section
     */
    public void setUpperSection(ArrayList<ScoreTableRow> upperSection) {
        this.upperSection = upperSection;
    }

    /**
     * Sets lower section.
     *
     * @param lowerSection the lower section
     */
    public void setLowerSection(ArrayList<ScoreTableRow> lowerSection) {
        this.lowerSection = lowerSection;
    }
}

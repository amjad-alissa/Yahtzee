package de.adesso.alissa.yahtzee.game.elements;

/**
 * The type Score element which serves as the class for every row in the scoreboard.
 */
public class ScoreElement {
    private final String label;
    private boolean selected;
    private int points;

    /**
     * Instantiates a new Score element.
     *
     * @param label the label
     */
    public ScoreElement(String label) {
        this.label = label;
        this.selected = false;
        this.points = 0;
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
     * Is selected boolean.
     *
     * @return the boolean
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Sets selected.
     *
     * @param selected the selected
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * Gets points.
     *
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets points.
     *
     * @param points the points
     */
    public void setPoints(int points) {
        this.points = points;
    }
}

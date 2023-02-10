package de.adesso.alissa.yahtzee.game;

public class ScoreElement {
    private final String label;
    private boolean selected;
    private int points;

    public ScoreElement(String label) {
        this.label = label;
        this.selected = false;
        this.points = 0;
    }

    public String getLabel() {
        return label;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

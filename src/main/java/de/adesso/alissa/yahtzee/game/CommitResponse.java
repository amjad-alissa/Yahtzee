package de.adesso.alissa.yahtzee.game;

public class CommitResponse {
    private final int[] upperPoints;
    private final int[] lowerPoints;
    private final int[] totalUpperPoints;
    private final int[] totalLowerPoints;

    public CommitResponse(int[] upperPoints, int[] lowerPoints, int[] totalUpperPoints, int[] totalLowerPoints) {
        this.upperPoints = upperPoints;
        this.lowerPoints = lowerPoints;
        this.totalUpperPoints = totalUpperPoints;
        this.totalLowerPoints = totalLowerPoints;
    }

    public int[] getUpperPoints() {
        return upperPoints;
    }

    public int[] getLowerPoints() {
        return lowerPoints;
    }

    public int[] getTotalUpperPoints() {
        return totalUpperPoints;
    }

    public int[] getTotalLowerPoints() {
        return totalLowerPoints;
    }
}

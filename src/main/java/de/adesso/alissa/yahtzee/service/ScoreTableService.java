package de.adesso.alissa.yahtzee.service;

import de.adesso.alissa.yahtzee.game.elements.ScoreTable;
import de.adesso.alissa.yahtzee.game.elements.ScoreTableRow;
import de.adesso.alissa.yahtzee.game.enums.YellowDiceIconSource;

import java.util.ArrayList;

/**
 * The ScoreTableService serve as the service class for creating the ScoreTable.
 */
public class ScoreTableService {

    private final ScoreTable scoreTable = new ScoreTable();

    /**
     * Create table score table.
     *
     * @return the score table
     */
    public ScoreTable createTable() {
        this.createUpperSection();
        this.createLowerSection();
        return this.scoreTable;
    }

    // Create the upper section of the score table
    private void createUpperSection() {
        ArrayList<ScoreTableRow> upperSection = new ArrayList<>();
        final ScoreTableRow ones = this.createUpperSectionRow(1, YellowDiceIconSource.DICE_ONE_PNG.getValue(), "Ones");
        upperSection.add(ones);
        final ScoreTableRow twos = this.createUpperSectionRow(2, YellowDiceIconSource.DICE_TWO_PNG.getValue(), "Tows");
        upperSection.add(twos);
        final ScoreTableRow threes = this.createUpperSectionRow(3, YellowDiceIconSource.DICE_THREE_PNG.getValue(), "Threes");
        upperSection.add(threes);
        final ScoreTableRow fours = this.createUpperSectionRow(4, YellowDiceIconSource.DICE_FOUR_PNG.getValue(), "Fours");
        upperSection.add(fours);
        final ScoreTableRow fives = this.createUpperSectionRow(5, YellowDiceIconSource.DICE_FIVE_PNG.getValue(), "Fives");
        upperSection.add(fives);
        final ScoreTableRow sixes = this.createUpperSectionRow(6, YellowDiceIconSource.DICE_SIX_PNG.getValue(), "Sixes");
        upperSection.add(sixes);

        this.scoreTable.setUpperSection(upperSection);
    }

    // Create the upper section of the score block table
    private ScoreTableRow createUpperSectionRow(final int id, final String diceIcon, final String label) {
        ArrayList<String> diceIcons = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            diceIcons.add(diceIcon);
        }
        return new ScoreTableRow(id, diceIcons, label);
    }

    // Create the lower section of the score block table
    private void createLowerSection() {
        ArrayList<ScoreTableRow> lowerSection = new ArrayList<>();
        // Dreierpasch
        ArrayList<String> threeSameDiceIcons = new ArrayList<>();
        threeSameDiceIcons.add(YellowDiceIconSource.DICE_ONE_PNG.getValue());
        threeSameDiceIcons.add(YellowDiceIconSource.DICE_ONE_PNG.getValue());
        threeSameDiceIcons.add(YellowDiceIconSource.DICE_ONE_PNG.getValue());
        final ScoreTableRow threeSame = new ScoreTableRow(1, threeSameDiceIcons, "Three-Same");
        lowerSection.add(threeSame);

        // Viererpasch
        ArrayList<String> fourSameDiceIcons = new ArrayList<>();
        fourSameDiceIcons.add(YellowDiceIconSource.DICE_TWO_PNG.getValue());
        fourSameDiceIcons.add(YellowDiceIconSource.DICE_TWO_PNG.getValue());
        fourSameDiceIcons.add(YellowDiceIconSource.DICE_TWO_PNG.getValue());
        fourSameDiceIcons.add(YellowDiceIconSource.DICE_TWO_PNG.getValue());
        final ScoreTableRow fourSame = new ScoreTableRow(2, fourSameDiceIcons, "Four-Same");
        lowerSection.add(fourSame);

        //Full-House
        ArrayList<String> fullHouseDiceIcons = new ArrayList<>();
        fullHouseDiceIcons.add(YellowDiceIconSource.DICE_ONE_PNG.getValue());
        fullHouseDiceIcons.add(YellowDiceIconSource.DICE_ONE_PNG.getValue());
        fullHouseDiceIcons.add(YellowDiceIconSource.DICE_ONE_PNG.getValue());
        fullHouseDiceIcons.add(YellowDiceIconSource.DICE_TWO_PNG.getValue());
        fullHouseDiceIcons.add(YellowDiceIconSource.DICE_TWO_PNG.getValue());
        final ScoreTableRow fullHouse = new ScoreTableRow(3, fullHouseDiceIcons, "Full-House");
        lowerSection.add(fullHouse);

        //Kleine-Strasse
        ArrayList<String> smallStreetDiceIcons = new ArrayList<>();
        smallStreetDiceIcons.add(YellowDiceIconSource.DICE_THREE_PNG.getValue());
        smallStreetDiceIcons.add(YellowDiceIconSource.DICE_FOUR_PNG.getValue());
        smallStreetDiceIcons.add(YellowDiceIconSource.DICE_FIVE_PNG.getValue());
        smallStreetDiceIcons.add(YellowDiceIconSource.DICE_SIX_PNG.getValue());
        final ScoreTableRow smallStreet = new ScoreTableRow(4, smallStreetDiceIcons, "Small-Straight");
        lowerSection.add(smallStreet);

        //Gro??e-Strasse
        ArrayList<String> bigStreetDiceIcons = new ArrayList<>();
        bigStreetDiceIcons.add(YellowDiceIconSource.DICE_ONE_PNG.getValue());
        bigStreetDiceIcons.add(YellowDiceIconSource.DICE_TWO_PNG.getValue());
        bigStreetDiceIcons.add(YellowDiceIconSource.DICE_THREE_PNG.getValue());
        bigStreetDiceIcons.add(YellowDiceIconSource.DICE_FOUR_PNG.getValue());
        bigStreetDiceIcons.add(YellowDiceIconSource.DICE_FIVE_PNG.getValue());
        final ScoreTableRow bigStreet = new ScoreTableRow(5, bigStreetDiceIcons, "Large-Straight");
        lowerSection.add(bigStreet);

        //Kniffel
        ArrayList<String> yahtzeeDiceIcons = new ArrayList<>();
        yahtzeeDiceIcons.add(YellowDiceIconSource.DICE_THREE_PNG.getValue());
        yahtzeeDiceIcons.add(YellowDiceIconSource.DICE_THREE_PNG.getValue());
        yahtzeeDiceIcons.add(YellowDiceIconSource.DICE_THREE_PNG.getValue());
        yahtzeeDiceIcons.add(YellowDiceIconSource.DICE_THREE_PNG.getValue());
        yahtzeeDiceIcons.add(YellowDiceIconSource.DICE_THREE_PNG.getValue());
        final ScoreTableRow yahtzee = new ScoreTableRow(6, yahtzeeDiceIcons, "YAHTZEE");
        lowerSection.add(yahtzee);

        //Chance
        ArrayList<String> chanceDiceIcons = new ArrayList<>();
        chanceDiceIcons.add(YellowDiceIconSource.DICE_ONE_PNG.getValue());
        chanceDiceIcons.add(YellowDiceIconSource.DICE_THREE_PNG.getValue());
        chanceDiceIcons.add(YellowDiceIconSource.DICE_FIVE_PNG.getValue());
        chanceDiceIcons.add(YellowDiceIconSource.DICE_FOUR_PNG.getValue());
        chanceDiceIcons.add(YellowDiceIconSource.DICE_SIX_PNG.getValue());
        final ScoreTableRow chance = new ScoreTableRow(7, chanceDiceIcons, "Chance");
        lowerSection.add(chance);

        this.scoreTable.setLowerSection(lowerSection);
    }

}

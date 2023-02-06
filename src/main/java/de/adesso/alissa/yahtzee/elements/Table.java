package de.adesso.alissa.yahtzee.elements;

import java.util.ArrayList;

/**
 * The type Table.
 */
public class Table {

    public static final String DICE_THREE_PNG = "/media/dice/three.png";
    public static final String DICE_ONE_PNG = "/media/dice/one.png";
    public static final String DICE_TWO_PNG = "/media/dice/two.png";
    public static final String DICE_FOUR_PNG = "/media/dice/four.png";
    public static final String DIC_FIVE_PNG = "/media/dice/five.png";
    public static final String DICE_SIX_PNG = "/media/dice/six.png";
    private ArrayList<TableRow> upperSection;
    private ArrayList<TableRow> lowerSection;


    /**
     * Instantiates a new Table.
     */
    public Table() {
        this.createUpperSection();
        this.createLowerSection();
    }

    // Create the upper section of the score block table
    private void createUpperSection() {
        this.upperSection = new ArrayList<>();

        final TableRow ones = this.createUpperSectionRow(1, DICE_ONE_PNG, "Einser");
        final TableRow two = this.createUpperSectionRow(2, DICE_TWO_PNG, "Zweier");
        final TableRow threes = this.createUpperSectionRow(3, DICE_THREE_PNG, "Dreier");
        final TableRow fours = this.createUpperSectionRow(4, DICE_FOUR_PNG, "Vierer");
        final TableRow fives = this.createUpperSectionRow(5, DIC_FIVE_PNG, "Fünfer");
        final TableRow sixes = this.createUpperSectionRow(6, DICE_SIX_PNG, "Sechser");

        this.upperSection.add(ones);
        this.upperSection.add(two);
        this.upperSection.add(threes);
        this.upperSection.add(fours);
        this.upperSection.add(fives);
        this.upperSection.add(sixes);
    }

    private TableRow createUpperSectionRow(final int id, final String diceIcon, final String label) {

        ArrayList<String> diceIcons = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            diceIcons.add(diceIcon);
        }

        return new TableRow(id, diceIcons, label);
    }

    // Create the lower section of the score block table
    private void createLowerSection() {

        this.lowerSection = new ArrayList<>();

        // Dreierpasch
        ArrayList<String> threeSameDiceIcons = new ArrayList<>();
        threeSameDiceIcons.add(DICE_ONE_PNG);
        threeSameDiceIcons.add(DICE_ONE_PNG);
        threeSameDiceIcons.add(DICE_ONE_PNG);
        final TableRow threeSame = new TableRow(7, threeSameDiceIcons, "Dreierpasch");
        this.lowerSection.add(threeSame);

        // Viererpasch
        ArrayList<String> fourSameDiceIcons = new ArrayList<>();
        fourSameDiceIcons.add(DICE_TWO_PNG);
        fourSameDiceIcons.add(DICE_TWO_PNG);
        fourSameDiceIcons.add(DICE_TWO_PNG);
        fourSameDiceIcons.add(DICE_TWO_PNG);
        final TableRow fourSame = new TableRow(8, fourSameDiceIcons, "Viererpasch");
        this.lowerSection.add(fourSame);

        //Full-House
        ArrayList<String> fullHouseDiceIcons = new ArrayList<>();
        fullHouseDiceIcons.add(DICE_ONE_PNG);
        fullHouseDiceIcons.add(DICE_ONE_PNG);
        fullHouseDiceIcons.add(DICE_ONE_PNG);
        fullHouseDiceIcons.add(DICE_TWO_PNG);
        fourSameDiceIcons.add(DICE_TWO_PNG);
        final TableRow fullHouse = new TableRow(9, fullHouseDiceIcons, "Full-Haus");
        this.lowerSection.add(fullHouse);

        //Kleine-Strasse
        ArrayList<String> smallStreetDiceIcons = new ArrayList<>();
        smallStreetDiceIcons.add(DICE_ONE_PNG);
        smallStreetDiceIcons.add(DICE_TWO_PNG);
        smallStreetDiceIcons.add(DICE_THREE_PNG);
        smallStreetDiceIcons.add(DICE_FOUR_PNG);
        final TableRow smallStreet = new TableRow(10, smallStreetDiceIcons, "Kleine Straße");
        this.lowerSection.add(smallStreet);

        //Große-Strasse
        ArrayList<String> bigStreetDiceIcons = new ArrayList<>();
        bigStreetDiceIcons.add(DICE_ONE_PNG);
        bigStreetDiceIcons.add(DICE_TWO_PNG);
        bigStreetDiceIcons.add(DICE_THREE_PNG);
        bigStreetDiceIcons.add(DICE_FOUR_PNG);
        bigStreetDiceIcons.add(DIC_FIVE_PNG);
        final TableRow bigStreet = new TableRow(11, bigStreetDiceIcons, "Große Straße");
        this.lowerSection.add(bigStreet);

        //Kniffel
        ArrayList<String> yahtzeeDiceIcons = new ArrayList<>();
        yahtzeeDiceIcons.add(DICE_THREE_PNG);
        yahtzeeDiceIcons.add(DICE_THREE_PNG);
        yahtzeeDiceIcons.add(DICE_THREE_PNG);
        yahtzeeDiceIcons.add(DICE_THREE_PNG);
        yahtzeeDiceIcons.add(DICE_THREE_PNG);
        final TableRow yahtzee = new TableRow(12, yahtzeeDiceIcons, "Kniffel");
        this.lowerSection.add(yahtzee);

        //Chance
        ArrayList<String> chanceDiceIcons = new ArrayList<>();
        chanceDiceIcons.add(DICE_ONE_PNG);
        chanceDiceIcons.add(DICE_THREE_PNG);
        chanceDiceIcons.add(DIC_FIVE_PNG);
        chanceDiceIcons.add(DICE_SIX_PNG);
        chanceDiceIcons.add(DICE_TWO_PNG);
        final TableRow chance = new TableRow(13, chanceDiceIcons, "Chance");
        this.lowerSection.add(chance);
    }

    public ArrayList<TableRow> getUpperSection() {
        return upperSection;
    }

    public ArrayList<TableRow> getLowerSection() {
        return lowerSection;
    }
}

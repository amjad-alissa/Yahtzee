package de.adesso.alissa.yahtzee.game.enums;

public enum Label {
    ONES("Einser"),
    TOWS("Zweier"),
    THREES("Dreier"),
    FOURS("Vierer"),
    FIVES("Fünfer"),
    SIXES("Sechser"),

    THREE_SAME("Dreierpasch"),
    FOUR_SAME("Viererpasch"),
    FULL_HOUSE("Voll-Haus"),
    SMALL_STREET("Kleine Straße"),
    BIG_STREET("Große Straße"),

    YAHTZEE("Kniffel"),
    CHANCE("Chance");

    private final String value;

    Label(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}

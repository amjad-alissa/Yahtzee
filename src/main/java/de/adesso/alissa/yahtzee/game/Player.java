package de.adesso.alissa.yahtzee.game;

public class Player {
    private final int id;
    private final String name;
    private final String avatar;
    private final Scoreboard scoreboard;

    public Player(String name, String avatar) {
        //TODO: need to be modified
        this.id = 1;
        this.name = name;
        this.avatar = avatar;
        this.scoreboard = new Scoreboard();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }
}

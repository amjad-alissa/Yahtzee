package de.adesso.alissa.yahtzee.game.elements;

/**
 * The type Player which serves as the class for the players.
 */
public class Player {
    private int id;
    private String name;
    private String avatarIconSource;
    private Scoreboard scoreboard;

    private boolean currentPlayer = false;
    private static int counter = 1;

    /**
     * Instantiates a new Player.
     */
    public Player() {
        this.id = counter;
        counter++;
        this.scoreboard = new Scoreboard();
    }

    /**
     * Instantiates a new Player.
     *
     * @param name             the name
     * @param avatarIconSource the avatar icon source
     */
    public Player(String name, String avatarIconSource) {
        this.id = counter;
        counter++;
        this.name = name;
        this.avatarIconSource = avatarIconSource;
        this.scoreboard = new Scoreboard();
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets avatar icon source.
     *
     * @return the avatar icon source
     */
    public String getAvatarIconSource() {
        return avatarIconSource;
    }

    /**
     * Gets scoreboard.
     *
     * @return the scoreboard
     */
    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets avatar icon source.
     *
     * @param avatarIconSource the avatar icon source
     */
    public void setAvatarIconSource(String avatarIconSource) {
        this.avatarIconSource = avatarIconSource;
    }

    /**
     * Sets scoreboard.
     *
     * @param scoreboard the scoreboard
     */
    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    /**
     * Is current player boolean.
     *
     * @return the boolean
     */
    public boolean isCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Sets current player.
     *
     * @param currentPlayer the current player
     */
    public void setCurrentPlayer(boolean currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}

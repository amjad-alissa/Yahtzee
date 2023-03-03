package de.adesso.alissa.yahtzee.game.enums;

import java.security.SecureRandom;
import java.util.Random;

/**
 * The enum Avatar for the profile icon for the players.
 */
public enum Avatar {
    /**
     * Bear avatar.
     */
    BEAR("/media/avatars/bear.png"),
    /**
     * Cat avatar.
     */
    CAT("/media/avatars/cat.png"),
    /**
     * Chicken avatar.
     */
    CHICKEN("/media/avatars/chicken.png"),
    /**
     * Dog avatar.
     */
    DOG("/media/avatars/dog.png"),
    /**
     * Giraffe avatar.
     */
    GIRAFFE("/media/avatars/giraffe.png"),
    /**
     * Meerkat avatar.
     */
    MEERKAT("/media/avatars/meerkat.png"),
    /**
     * Rabbit avatar.
     */
    RABBIT("/media/avatars/rabbit.png"),
    /**
     * Whale avatar.
     */
    WHALE("/media/avatars/whale.png");

    private final String avatarSource;

    Avatar(final String avatarSource) {
        this.avatarSource = avatarSource;
    }

    /**
     * Gets next avatar.
     *
     * @param index the index
     * @return the next avatar
     */
    public static Avatar getNextAvatar(int index) {
        Avatar[] avatars = {BEAR, CAT, CHICKEN, DOG, GIRAFFE, MEERKAT, RABBIT, WHALE};
        return avatars[index];
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return this.avatarSource;
    }
}

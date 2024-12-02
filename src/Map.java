/**
 * Represents a map in a game with specific coordinates for key items and locations such as a key, door,
 * armor, and health pack. Provides methods to determine player interactions with these items and locations,
 * as well as random encounter mechanics.
 */
public class Map {

    // Coordinates for the key location
    private final int keyX;
    private final int keyY;

    // Coordinates for the door location
    private final int doorX;
    private final int doorY;

    // Coordinates for the armor location
    private final int armourX;
    private final int armourY;

    // Coordinates for the health pack location
    private final int healthX;
    private final int healthY;
    /**
     * Constructs a new Map with specified coordinates for key items and locations.
     *
     * @param keyX     the x-coordinate of the key
     * @param keyY     the y-coordinate of the key
     * @param doorX    the x-coordinate of the door
     * @param doorY    the y-coordinate of the door
     * @param armourX  the x-coordinate of the armor
     * @param armourY  the y-coordinate of the armor
     * @param healthX  the x-coordinate of the health pack
     * @param healthY  the y-coordinate of the health pack
     */
    public Map(int keyX, int keyY, int doorX, int doorY, int armourX, int armourY, int healthX, int healthY) {
        this.keyX = keyX;
        this.keyY = keyY;
        this.doorX = doorX;
        this.doorY = doorY;
        this.armourX = armourX;
        this.armourY = armourY;
        this.healthX = healthX;
        this.healthY = healthY;
    }

    /**
     * Generates a random encounter chance.
     *
     * @return a random integer between 1 and 99 (inclusive).
     */
    public int encounterChance() {//returns a number 1-100
        return (int) (Math.random() * 99) + 1;
    }

    /**
     * Simulates a random encounter.
     *
     * @return a random integer between 1 and 3 (inclusive), representing different types of encounters.
     */
    public int randomEncounter() {//returns a number 1-3
        return (int) (Math.random() * 3) + 1;
    }

    /**
     * Checks if the player is on the key location.
     *
     * @param playerX the player's x-coordinate
     * @param playerY the player's y-coordinate
     * @return true if the player is on the key location, false otherwise.
     */
    public boolean isOnKey(int playerX, int playerY) {
        return (playerX == keyX) && (playerY == keyY);
    }

    /**
     * Checks if the player is on the door location.
     *
     * @param playerX the player's x-coordinate
     * @param playerY the player's y-coordinate
     * @return true if the player is on the door location, false otherwise.
     */
    public boolean isOnDoor(int playerX, int playerY) {
        return (playerX == doorX) && (playerY == doorY);
    }

    /**
     * Checks if the player is on the armor location.
     *
     * @param playerX the player's x-coordinate
     * @param playerY the player's y-coordinate
     * @return true if the player is on the armor location, false otherwise.
     */
    public boolean isOnArmour(int playerX, int playerY) {
        return (playerX == armourX) && (playerY == armourY);
    }

    /**
     * Checks if the player is on the health pack location.
     *
     * @param playerX the player's x-coordinate
     * @param playerY the player's y-coordinate
     * @return true if the player is on the health pack location, false otherwise.
     */
    public boolean isOnHealth(int playerX, int playerY) {
        return (playerX == healthX) && (playerY == healthY);
    }

}

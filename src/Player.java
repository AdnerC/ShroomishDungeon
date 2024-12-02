/**
 * Represents the player in the game with attributes such as health, strength, speed, level, and defense.
 * Provides methods for taking damage, dealing damage, leveling up, and modifying stats.
 */
public class Player {
    private double health;//Represents the player's strength
    private double strong;//Represents the player's strength
    private double speed;//Represents the player's speed
    private double level;//Represents the player's level
    private double defense;//Represents the player's defense value

    /**
     * Constructs a new Player with specified attributes.
     *
     * @param health//the player's health
     * @param strong//the player's strength
     * @param speed//the player's speed
     * @param level//the player's level
     * @param defense//the player's defense value
     */
    public Player(double health, double strong,double speed,double level, double defense){//constructor
        this.health = health;
        this.strong = strong;
        this.speed = speed;
        this.level = level;
        this.defense = defense;
    }

    /**
     * Calculates the damage taken by the player after accounting for their defense.
     *
     * @param enemyHit the raw damage dealt by the enemy
     * @return the net damage taken by the player
     */
    public double takeDamage(double enemyHit){//calculates dmg taken
        return enemyHit-defense;
    }

    /**
     * Calculates the damage dealt by the player to an enemy after considering the enemy's defense.
     *
     * @param playerHit    the raw damage dealt by the player
     * @param enemyDefense the enemy's defense value
     * @return the net damage dealt to the enemy
     */
    public double dealDamage(double playerHit, double enemyDefense){//calculates dmg done
        return playerHit-enemyDefense;
    }

    /**
     * Modifies the player's health by a given amount. Health cannot exceed 100.
     *
     * @param change the amount to adjust the player's health by (positive or negative)
     */
    public void changeHealth(double change){//calculates a change in health
        this.health += change;
        if (this.health > 100) {
            this.health = 100; //Cap health at a maximum value of 100
        }
    }

    /**
     * Adds armor to the player, increasing their defense value.
     */
    public void getArmour(){//acquires armour and increases defense
        defense += 30;
    }

    /**
     * Levels up the player, increasing all attributes by a set amount.
     */
    public void levelUp(){//adds 2 to each stat
        health+=2;
        speed+=2;
        strong+=2;
        level+=2;
        defense+=2;
    }

    /**
     * Gets the player's current health value.
     *
     * @return the player's health
     */
    public double getHealth (){
        return health;
    }

    /**
     * Gets the player's current strength value.
     *
     * @return the player's strength
     */
    public double getStrong (){
        return strong;
    }

    /**
     * Gets the player's current speed value.
     *
     * @return the player's speed
     */
    public double getSpeed (){
        return speed;
    }

    /**
     * Gets the player's current level.
     *
     * @return the player's level
     */
    public double getLevel (){
        return level;
    }

    /**
     * Gets the player's current defense value.
     *
     * @return the player's defense
     */
    public double getDefense (){
        return defense;
    }

    /**
     * Ensures a given value is clamped between a minimum and maximum range.
     *
     * @param value the value to be clamped
     * @param min the minimum allowable value
     * @param max the maximum allowable value
     * @return the clamped value
     */
    public static int fixValue (int value, int min, int max) {//clamps a value down to one of 2 either min or max
        if (value > max) return max;
        if (value < min) return min;
        return value;
    }


}

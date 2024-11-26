public class Player {
    private double health;
    private double strong;
    private double speed;
    private double level;
    private double defense;

    public Player(double health, double strong,double speed,double level, double defense){//constructor
        this.health = health;
        this.strong = strong;
        this.speed = speed;
        this.level = level;
        this.defense = defense;
    }

    public double takeDamage(double enemyHit){//calculates dmg taken
        return enemyHit-defense;
    }

    public double dealDamage(double playerHit, double enemyDefense){//calculates dmg done
        return playerHit-enemyDefense;
    }

    public void changeHealth(double change){//calculates a change in health
        this.health += change;
        if (this.health > 100) {
            this.health = 100; // Optional: Cap health at a maximum value of 100
        }
    }


    public void getArmour(){//acquires armour and increases defense
        defense += 30;
    }

    public void levelUp(){//adds 2 to each stat
        health+=2;
        speed+=2;
        strong+=2;
        level+=2;
        defense+=2;
    }

    public double getHealth (){
        return health;
    }

    public double getStrong (){
        return strong;
    }

    public double getSpeed (){
        return speed;
    }

    public double getLevel (){
        return level;
    }

    public double getDefense (){
        return defense;
    }

    public static int fixValue (int value, int min, int max) {//clamps a value down to one of 2 either min or max
        if (value > max) return max;
        if (value < min) return min;
        return value;
    }


}

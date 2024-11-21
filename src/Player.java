public class Player {
    private double health;
    private double strong;
    private double speed;
    private double level;
    private double defense;

    public Player(double health, double strong,double speed,double level, double defense){
        this.health = health;
        this.strong = strong;
        this.speed = speed;
        this.level = level;
        this.defense = defense;
    }

    public double takeDamage(double enemyHit){
        return enemyHit-defense;
    }

    public double dealDamage(double playerHit, double enemyDefense){
        return playerHit-enemyDefense;
    }

    public void changeHealth(double change){
        this.health += change;
        if (this.health > 100) {
            this.health = 100; // Optional: Cap health at a maximum value of 100
        }
    }


    public void getArmour(){
        defense += 30;
    }

    public void levelUp(){
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

    public static int fixValue (int value, int min, int max) {
        if (value > max) return max;
        if (value < min) return min;
        return value;
    }


}

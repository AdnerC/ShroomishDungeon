public class Player {
    private int health;
    private int strong;
    private int speed;
    private int level;
    private int defense;

    public Player(int health, int strong,int speed,int level, int defense){
        this.health = health;
        this.strong = strong;
        this.speed = speed;
        this.level = level;
        this.defense = defense;
    }

    public int takeDamage(int enemyHit){
        int damageDealt = enemyHit-defense;
       return damageDealt;
    }

    public int dealDamage(int playerHit, int enemyDefense){
        int damageDealt = playerHit-enemyDefense;
        return damageDealt;
    }

    public void levelUp(){
        health++;
        speed++;
        strong++;
        level++;
        defense++;
    }

    public int getHealth (){
        return health;
    }

    public int getStrong (){
        return strong;
    }

    public int getSpeed (){
        return speed;
    }

    public int getLevel (){
        return level;
    }

    public int getDefense (){
        return defense;
    }


}

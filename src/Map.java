public class Map {

    private final int keyX;
    private final int keyY;
    private final int doorX;
    private final int doorY;
    private final int armourX;
    private final int armourY;
    private final int healthX;
    private final int healthY;

    public Map(int keyX, int keyY,int doorX,int doorY, int armourX, int armourY, int healthX, int healthY) {
        this.keyX = keyX;
        this.keyY = keyY;
        this.doorX = doorX;
        this.doorY = doorY;
        this.armourX = armourX;
        this.armourY = armourY;
        this.healthX = healthX;
        this.healthY = healthY;
    }

    public int encounterChance(){
        return (int) (Math.random()*99)+1;
    }

    public int randomEncounter(){
        return (int) (Math.random()*3 )+1;
    }

    public boolean isOnKey(int playerX, int playerY){
        if ((playerX==keyX)&&(playerY==keyY)){
            return true;
        }else {
            return false;
        }
    }

    public boolean isOnDoor(int playerX, int playerY){
        if ((playerX==doorX)&&(playerY==doorY)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isOnArmour(int playerX, int playerY){
        if ((playerX==armourX)&&(playerY==armourY)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isOnHealth(int playerX, int playerY){
        if ((playerX==healthX)&&(playerY==healthY)){
            return true;
        }else{
            return false;
        }
    }


}

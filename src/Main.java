import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean gameWon =false;
        Player player = new Player(100, 25, 40, 1, 60);
        int playerX = 6;
        int playerY = 6;
        boolean gotKey = false;

        System.out.println("Would you like to play the default map, or have someone create one? (1 for default, 2 for custom)");
        String number = s.nextLine();
        int choice = Integer.parseInt(number);

        if(choice==1){
            Map gameMap = new Map(6,2,10,4,3,9,2,5);
        }else {
            System.out.println("What would you like the X coordinate of the key to be? (grid is 11x11)");
            String keyXString = s.nextLine();
            int keyX = Integer.parseInt(keyXString);
            System.out.println("What would you like the Y coordinate of the key to be? (grid is 11x11)");
            String keyYString = s.nextLine();
            int keyY = Integer.parseInt(keyYString);

            System.out.println("What would you like the X coordinate of the door to be? (grid is 11x11)");
            String doorXString = s.nextLine();
            int doorX = Integer.parseInt(doorXString);
            System.out.println("What would you like the Y coordinate of the key to be? (grid is 11x11)");
            String doorYString = s.nextLine();
            int doorY = Integer.parseInt(doorYString);

            System.out.println("What would you like the X coordinate of the armour to be? (grid is 11x11)");
            String armourXString = s.nextLine();
            int armourX = Integer.parseInt(armourXString);
            System.out.println("What would you like the Y coordinate of the armour to be? (grid is 11x11)");
            String armourYString = s.nextLine();
            int armourY = Integer.parseInt(armourYString);

            System.out.println("What would you like the X coordinate of the health to be? (grid is 11x11)");
            String healthXString = s.nextLine();
            int healthX = Integer.parseInt(healthXString);
            System.out.println("What would you like the Y coordinate of the health to be? (grid is 11x11)");
            String healthYString = s.nextLine();
            int healthY = Integer.parseInt(healthYString);

            Map gameMap = new Map(keyX,keyY,doorX,doorY,armourX,armourY,healthX,healthY);

        }

        while (!gameWon){
            System.out.println("What direction do you want to move ? (the grid is 11x11) w = up / s = down / a = left / d = right ");
            String direction = s.nextLine();

            if (direction.equals("a")){
                if(playerX==1){
                    System.out.println("You can't go that way, theres a wall...");
                }else {
                    System.out.println("You moved to the left.");
                    playerX--;
                }
            }

            if (direction.equals("d")){
                if(playerX==11){
                    System.out.println("You can't go that way, theres a wall...");
                }else {
                    System.out.println("You moved to the right.");
                    playerX++;
                }
            }

            if (direction.equals("s")){
                if(playerY==1){
                    System.out.println("You can't go that way, theres a wall...");
                }else {
                    System.out.println("You moved down.");
                    playerY--;
                }
            }

            if (direction.equals("w")){
                if(playerY==11){
                    System.out.println("You can't go that way, theres a wall...");
                }else {
                    System.out.println("You moved up.");
                    playerY--;
                }
            }

            if ()
        }

    }
}

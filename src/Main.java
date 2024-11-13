import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean gameWon = false;
        Player player = new Player(100, 25, 40, 1, 60);
        int playerX = 6;
        int playerY = 6;
        boolean gotKey = false;
        int keyX;
        int keyY;
        int doorX;
        int doorY;
        int armourX;
        int armourY;
        int healthX;
        int healthY;
        double randomness = (((double) (Math.random() * 30) + 85) / 100);

        System.out.println("Would you like to play the default map, or have someone create one? (1 for default, 2 for custom)");
        String number = s.nextLine();
        int choice = Integer.parseInt(number);

        if (choice == 1) {
            keyX = 6;
            keyY = 2;
            doorX = 10;
            doorY = 4;
            armourX = 3;
            armourY = 9;
            healthX = 2;
            healthY = 5;
        } else {
            System.out.println("What would you like the X coordinate of the key to be? (grid is 11x11)");
            String keyXString = s.nextLine();
            keyX = Integer.parseInt(keyXString);
            System.out.println("What would you like the Y coordinate of the key to be? (grid is 11x11)");
            String keyYString = s.nextLine();
            keyY = Integer.parseInt(keyYString);

            System.out.println("What would you like the X coordinate of the door to be? (grid is 11x11)");
            String doorXString = s.nextLine();
            doorX = Integer.parseInt(doorXString);
            System.out.println("What would you like the Y coordinate of the key to be? (grid is 11x11)");
            String doorYString = s.nextLine();
            doorY = Integer.parseInt(doorYString);

            System.out.println("What would you like the X coordinate of the armour to be? (grid is 11x11)");
            String armourXString = s.nextLine();
            armourX = Integer.parseInt(armourXString);
            System.out.println("What would you like the Y coordinate of the armour to be? (grid is 11x11)");
            String armourYString = s.nextLine();
            armourY = Integer.parseInt(armourYString);

            System.out.println("What would you like the X coordinate of the health to be? (grid is 11x11)");
            String healthXString = s.nextLine();
            healthX = Integer.parseInt(healthXString);
            System.out.println("What would you like the Y coordinate of the health to be? (grid is 11x11)");
            String healthYString = s.nextLine();
            healthY = Integer.parseInt(healthYString);

        }
        Map gameMap = new Map(keyX, keyY, doorX, doorY, armourX, armourY, healthX, healthY);
        System.out.println(keyX);

        while (!gameWon) {
            System.out.println("What direction do you want to move ? (the grid is 11x11) w = up / s = down / a = left / d = right ");
            String direction = s.nextLine();

            if (direction.equals("a")) {
                if (playerX == 1) {
                    System.out.println("You can't go that way, theres a wall...");
                } else {
                    System.out.println("You moved to the left.");
                    playerX--;
                }
            }

            if (direction.equals("d")) {
                if (playerX == 11) {
                    System.out.println("You can't go that way, theres a wall...");
                } else {
                    System.out.println("You moved to the right.");
                    playerX++;
                }
            }

            if (direction.equals("s")) {
                if (playerY == 1) {
                    System.out.println("You can't go that way, theres a wall...");
                } else {
                    System.out.println("You moved down.");
                    playerY--;
                }
            }

            if (direction.equals("w")) {
                if (playerY == 11) {
                    System.out.println("You can't go that way, theres a wall...");
                } else {
                    System.out.println("You moved up.");
                    playerY++;
                }
            }

//            if (gameMap.encounterChance() > 70) {
//                if (gameMap.randomEncounter() == 1) {
//                    System.out.println("A small goblin approaches looking for a fight.");
//                    System.out.println("What do you want to do? (1 fight / 2  run attempt)");
//                    String fightOption = s.nextLine();
//                    int combat = Integer.parseInt(number);
//                    if (combat == 1) {
//
//                        double goblinHealth = 100;
//
//                        while (goblinHealth > 0) {
//                            double goblinDmg = 7 * randomness;
//                            double playerHit = player.getStrong() * randomness;
//                            System.out.println("You did " + player.dealDamage(playerHit, 5) + " damage!");
//                            System.out.println("The goblin hit you for " + player.takeDamage(goblinDmg) + "damage!");
//                            player.changeHealth(-1 * (player.takeDamage(goblinDmg)));
//                            goblinHealth -= player.dealDamage(playerHit, 5);
//                        }
//
//
//                    } else {
//                        if (player.getSpeed() > (40 * randomness)) {
//                            System.out.println("you managed to escape!");
//                        }
//                    }
//                }

                System.out.println("");
                System.out.println(playerX);
                System.out.println(playerY);
                System.out.println("");
                System.out.println(gameMap.getKey());

                if ((gameMap.isOnKey(playerX, playerY))) {
                    gotKey = true;
                    System.out.println("You got the key!");
                }

                if (gameMap.isOnDoor(playerX, playerY) && gotKey) {
                    gameWon = true;
                }

            }
            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⢀⣀⡠⠤⠴⠚⣿⠃\n" +
                    "⠀⠸⣿⡭⣭⣿⣽⣿⣿⣿⣿⣿⣿⣿⣽⣿⡿⠓⠚⠉⣉⣀⣤⡤⣴⠀⣿⠀\n" +
                    "⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢰⠞⢩⠀⢻⡏⠀⡏⠀⣿⠄\n" +
                    "⠀⢠⣟⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠀⠃⠀⣿⠂\n" +
                    "⠀⢘⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠀⡇⠀⣿⡇\n" +
                    "⠀⠈⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠀⣷⠀⣿⡇\n" +
                    "⠀⣠⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠀⣿⣼⣿⡇\n" +
                    "⠀⡃⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠘⠛⠛⠒⠛⠓⠛⠛⣿⣿⡇\n" +
                    "⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢰⠦⢠⠀⢤⣤⣤⣄⠋⣿⡇\n" +
                    "⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠈⣿⠀⣿⡇\n" +
                    "⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠀⣿⠀⣿⡇\n" +
                    "⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⣄⢸⠠⣼⡇⠀⣿⠀⣿⡇\n" +
                    "⠀⣸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠉⠉⠀⠛⠚⠯⠿⠀⣿⡇\n" +
                    "⠠⢿⣿⣷⣶⣶⣶⠶⢶⡶⢶⣶⣶⣶⣶⢿⣶⣤⣄⣀⣀⠀⠀⠀⢨⠀⣿⡇\n" +
                    "⠀⠀⠀⠈⠀⠐⠒⠒⠀⠀⠀⠘⠁⠈⠀⠀⠀⠀⠉⠉⢛⠉⠑⠒⠠⠤⢿⠇");
            System.out.println("You escaped the dungeon!");

        }
    }

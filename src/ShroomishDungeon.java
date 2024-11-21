import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ShroomishDungeon {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        boolean gameWon = false;
        Player player = new Player(100, 25, 40, 1, 60);
        boolean mapInt = false;
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
        double randomness = (((Math.random() * 20) + 95) / 100);
        boolean gotArmour = false;
        String number = "";
        System.out.println("You will be playing the default map!");
//        System.out.println("Would you like to play the default map, or have someone create one? (1 for default, 2 for custom)");
//        number = s.nextLine();
//        while(!mapInt){
//            if (!Objects.equals(number, "1") && !Objects.equals(number, "2")) {
//                System.out.println("Sorry, but that isn't an option!");
//                System.out.println("Would you like to play the default map, or have someone create one? (1 for default, 2 for custom)");
//                number = s.nextLine();
//            } else {
//                mapInt = true;
//            }
//        }
//        int choice = Integer.parseInt(number);
        int choice = 1;


        if (choice == 1) {
            keyX = 6;
            keyY = 2;
            doorX = 10;
            doorY = 4;
            armourX = 3;
            armourY = 9;
            healthX = 2;
            healthY = 5;
        }else {
            keyX = 6;
            keyY = 2;
            doorX = 10;
            doorY = 4;
            armourX = 3;
            armourY = 9;
            healthX = 2;
            healthY = 5;
        }
//        } else {
//            System.out.println("Any numbers above 11 will get rounded to 11");
//            System.out.println("What would you like the X coordinate of the key to be? (grid is 11x11)");
//            String keyXString = s.nextLine();
//            keyX = Integer.parseInt(keyXString);
//            System.out.println("What would you like the Y coordinate of the key to be? (grid is 11x11)");
//            String keyYString = s.nextLine();
//            keyY = Integer.parseInt(keyYString);
//            System.out.println();
//            System.out.println("What would you like the X coordinate of the door to be? (grid is 11x11)");
//            String doorXString = s.nextLine();
//            doorX = Integer.parseInt(doorXString);
//            System.out.println("What would you like the Y coordinate of the key to be? (grid is 11x11)");
//            String doorYString = s.nextLine();
//            doorY = Integer.parseInt(doorYString);
//            System.out.println();
//            System.out.println("What would you like the X coordinate of the armour to be? (grid is 11x11)");
//            String armourXString = s.nextLine();
//            armourX = Integer.parseInt(armourXString);
//            System.out.println("What would you like the Y coordinate of the armour to be? (grid is 11x11)");
//            String armourYString = s.nextLine();
//            armourY = Integer.parseInt(armourYString);
//            System.out.println();
//            System.out.println("What would you like the X coordinate of the health to be? (grid is 11x11)");
//            String healthXString = s.nextLine();
//            healthX = Integer.parseInt(healthXString);
//            System.out.println("What would you like the Y coordinate of the health to be? (grid is 11x11)");
//            String healthYString = s.nextLine();
//            healthY = Integer.parseInt(healthYString);
//
//            keyX = Player.fixValue(keyX, 1, 11);
//            keyY = Player.fixValue(keyY, 1, 11);
//            doorX = Player.fixValue(doorX, 1, 11);
//            doorY = Player.fixValue(doorY, 1, 11);
//            armourX = Player.fixValue(armourX, 1, 11);
//            armourY = Player.fixValue(armourY, 1, 11);
//            healthX = Player.fixValue(healthX, 1, 11);
//            healthY = Player.fixValue(healthY, 1, 11);
//
//
//        }


        Map gameMap = new Map(keyX, keyY, doorX, doorY, armourX, armourY, healthX, healthY);

        while (!gameWon) {
            System.out.println("Your current location on the 11x11 grid is ("+ playerX+", "+playerY+")");
            System.out.println();
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

            if (gameMap.encounterChance() > 80) {
                int encounter = gameMap.randomEncounter();
                if (encounter == 1) {
                    System.out.println("A small goblin approaches looking for a fight.");

                    double goblinHealth = 100;

                    while (goblinHealth > 0 && player.getHealth() > 0) {
                        int combat = 0;
                        String fightOption = "";

                        System.out.println("What do you want to do? (1 fight / 2 run attempt)");
                        fightOption = s.nextLine();
                        boolean optionInt =false;
                        while (!optionInt){
                            if (!Objects.equals(fightOption, "1") && !Objects.equals(fightOption, "2")){
                                System.out.println("Sorry, but that isn't an option!");
                                System.out.println("What do you want to do? (1 fight / 2 run attempt)");
                                fightOption = s.nextLine();

                            }else{
                                optionInt = true;
                            }

                        }

                        combat = Integer.parseInt(fightOption);


                        if (combat == 2) {
                            double escapeChance = player.getSpeed() * randomness;
                            double requiredEscapeChance = 40 * randomness;

                            if (escapeChance > requiredEscapeChance) {
                                System.out.println("You managed to escape!");
                                return;
                            } else {
                                System.out.println("You failed to escape and must fight!");
                            }
                        }

                        if (combat == 1) {
                            double goblinDmg = 60 * randomness;
                            double playerHit = player.getStrong() * randomness;

                            System.out.println("You did " + (int) player.dealDamage(playerHit, 5) + " damage!");
                            goblinHealth -= player.dealDamage(playerHit, 5);

                            if (goblinHealth > 0) {
                                if (player.takeDamage(goblinDmg)>0){
                                    System.out.println("The goblin hit you for " + (int) player.takeDamage(goblinDmg) + " damage!");
                                    player.changeHealth(-1 * player.takeDamage(goblinDmg));
                                }else {
                                    System.out.println("The goblin hit you for no damage");
                                }
                            }
                        }
                    }

                    if (player.getHealth() <= 0) {
                        System.out.println("The goblin defeated you. Game over.");
                        gameWon = true;
                    } else if (goblinHealth <= 0) {
                        System.out.println("You defeated the goblin!");
                        player.levelUp();
                    }
                } else if (encounter == 4) {
                    System.out.println("You found a small bandage");
                    if (player.getHealth() >= 100){
                        System.out.println("Your already healthy as can be!");
                    }else {
                        System.out.println("You heal a small amount!");
                        player.changeHealth(10);
                    }
                }
            }

            if ((gameMap.isOnArmour(playerX, playerY)) && !(gotArmour)){
                System.out.println("You found some armour!");
                player.getArmour();
                gotArmour = true;

            }

            if (gameMap.isOnHealth(playerX,playerY)){
                System.out.println("You found a complete medkit! ");
                System.out.println("You feel completely rejuvenated ");
                player.changeHealth(100-player.getHealth());
            }

            if ((gameMap.isOnKey(playerX, playerY))) {
                    gotKey = true;
                    System.out.println("You got the key!");
                }

            if (gameMap.isOnDoor(playerX, playerY) && gotKey) {
                    gameWon = true;
                }else if (gameMap.isOnDoor(playerX, playerY)){
                System.out.println("You found the door, but need the key...");
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
            for (int i = 0; i < 50; ++i) {
            System.out.println();
            }

        System.out.println("But then suddenly a disgustingly large monster appears in the middle of the street. He is all red, and he looks like a weird stubby mushroom.");
        System.out.println();
        System.out.println("He starts running towards you!");
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }





        System.out.println("QUICK TIME EVENT");
        System.out.println();
        System.out.println("He tries to grab you! Type 'duck' to evade within 3 seconds!");

        // Set up the timer task
        TimerTask failDuck = new TimerTask() {
            public void run() {
                System.out.println("You took too long! The monster grabs you and you lose!");
                System.exit(0);
            }
        };

        Timer timer = new Timer();
        timer.schedule(failDuck, 2500); // Give the user 3 seconds to respond

        // Capture user input
        String quickTimeEvent = s.nextLine();
        timer.cancel();

        // Check user input
        if (quickTimeEvent.equalsIgnoreCase("duck")) {
            System.out.println("You duck just in time! The monster misses you!");
        } else {
            System.out.println("Wrong move! The monster grabs you, and tears a leg off");
        }


        Thread.sleep(200);


        System.out.println("He tries to grab you! Type 'roll' to evade within 3 seconds!");

        // Set up the timer task
        TimerTask failRoll = new TimerTask() {
            public void run() {
                System.out.println("You took too long! The monster grabs you and you lose!");
                System.exit(0); // Exit the game
            }
        };

        Timer timer2 = new Timer();
        timer2.schedule(failRoll, 2500); // Give the user 3 seconds to respond

        // Capture user input
        String rollTimeEvent = s.nextLine();
        timer2.cancel();

        // Check user input
        if (rollTimeEvent.equalsIgnoreCase("roll")) {
            System.out.println("You roll just in time! The monster misses you!");
        } else {
            System.out.println("Wrong move! The monster bites you, and tears an arm off");
        }





        System.out.println("He starts to swell, it looks like hes going to explode! Type 'sprint' to evade within 3 seconds!");

        // Set up the timer task
        TimerTask failSprint = new TimerTask() {
            public void run() {
                System.out.println("You took too long! The monster explodes and leaves corrosive acid all over you!");
                System.exit(0); // Exit the game
            }
        };

        Timer timer3 = new Timer();
        timer3.schedule(failSprint, 3000); // Give the user 3 seconds to respond

        // Capture user input
        String sprintTimeEvent = s.nextLine();
        timer3.cancel();

        // Check user input
        if (sprintTimeEvent.equalsIgnoreCase("sprint")) {
            System.out.println("You sprint just in time! The monster monster explodes, but you managed to get awawy!!");
        } else {
            System.out.println("Wrong move! You try to run, but trip! ");
        }


    }
}


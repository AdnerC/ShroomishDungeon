import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ShroomishDungeon {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        boolean gameWon = false;//initializing all variables
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


//default map
        keyX = 6;
        keyY = 2;
        doorX = 10;
        doorY = 4;
        armourX = 3;
        armourY = 9;
        healthX = 2;
        healthY = 5;



        Map gameMap = new Map(keyX, keyY, doorX, doorY, armourX, armourY, healthX, healthY); // creating map object

        System.out.println("You find yourself in a dark room...");
        System.out.println("Arranged in a convenient 11x11 grid!");
        System.out.println();
        System.out.println("You find a note that reads: ");
        System.out.println("There are a few items to help you escape...");
        System.out.println("A med kit, some armour, a key and a door");
        System.out.println("And a large amount of goblins");
        System.out.println();
        System.out.println("PS. Im waiting outside!");
        System.out.println("PSS. the key should be a bit below you!");


        while (!gameWon) {//loop until the game is won
            System.out.println("Your current location on the 11x11 grid is (" + playerX + ", " + playerY + ")");
            System.out.println();
            System.out.println("What direction do you want to move ? (the grid is 11x11) w = up / s = down / a = left / d = right ");
            String direction = s.nextLine();

            if (direction.equals("a")) {//checking the users direction
                if (playerX == 1) {
                    System.out.println("You can't go that way, theres a wall...");
                } else {
                    System.out.println("You moved to the left.");
                    playerX--;
                }
            }

            if (direction.equals("d")) {//checking the users direction
                if (playerX == 11) {
                    System.out.println("You can't go that way, theres a wall...");
                } else {
                    System.out.println("You moved to the right.");
                    playerX++;
                }
            }

            if (direction.equals("s")) {//checking the users direction
                if (playerY == 1) {
                    System.out.println("You can't go that way, theres a wall...");
                } else {
                    System.out.println("You moved down.");
                    playerY--;
                }
            }

            if (direction.equals("w")) {//checking the users direction
                if (playerY == 11) {
                    System.out.println("You can't go that way, theres a wall...");
                } else {
                    System.out.println("You moved up.");
                    playerY++;
                }
            }

            if (gameMap.encounterChance() > 80) {//checks if there is an encounter, 1/5 chance
                int encounter = gameMap.randomEncounter();
                if (encounter == 1) {//checks which encounter it is 1/3 chance
                    System.out.println("A small goblin approaches looking for a fight.");

                    double goblinHealth = 100;
                    boolean escaped = false;

                    while (goblinHealth > 0 && player.getHealth() > 0 && !escaped) {//as long as the goblin is not dead, or the player is alive, or the player has not escaped
                        int combat = 0;
                        String fightOption = "";

                        System.out.println("What do you want to do? (1 fight / 2 run attempt)");
                        fightOption = s.nextLine();
                        boolean optionInt = false;
                        while (!optionInt) {
                            if (!Objects.equals(fightOption, "1") && !Objects.equals(fightOption, "2")) {
                                System.out.println("Sorry, but that isn't an option!");
                                System.out.println("What do you want to do? (1 fight / 2 run attempt)");
                                fightOption = s.nextLine();

                            } else {
                                optionInt = true;
                            }

                        }

                        combat = Integer.parseInt(fightOption);


                        if (combat == 2) {//checks if they wanted to run
                            double escapeChance = player.getSpeed() * randomness;
                            double requiredEscapeChance = 40 * randomness;

                            if (escapeChance > requiredEscapeChance) {
                                System.out.println("You managed to escape!");
                                escaped = true;
                            } else {
                                System.out.println("You failed to escape and must fight!");
                            }
                        }

                        if (combat == 1) {//checks for attack
                            double goblinDmg = 60 * randomness;
                            double playerHit = player.getStrong() * randomness;

                            System.out.println("You did " + (int) player.dealDamage(playerHit, 5) + " damage!");
                            goblinHealth -= player.dealDamage(playerHit, 5);

                            if (goblinHealth > 0) {
                                if (player.takeDamage(goblinDmg) > 0) {
                                    System.out.println("The goblin hit you for " + (int) player.takeDamage(goblinDmg) + " damage!");
                                    player.changeHealth(-1 * player.takeDamage(goblinDmg));
                                } else {
                                    System.out.println("The goblin hit you for no damage");
                                }
                            }
                        }
                    }

                    if (player.getHealth() <= 0) { //the situations after the fight
                        System.out.println("The goblin defeated you. Game over.");
                        gameWon = true;
                    } else if (goblinHealth <= 0) {
                        System.out.println("You defeated the goblin!");
                        player.levelUp();
                    }
                } else if (encounter == 4) {
                    System.out.println("You found a small bandage");
                    if (player.getHealth() >= 100) {
                        System.out.println("Your already healthy as can be!");
                    } else {
                        System.out.println("You heal a small amount!");
                        player.changeHealth(10);
                    }
                }
            }

            if ((gameMap.isOnArmour(playerX, playerY)) && !(gotArmour)) {//checks for the player being on the same tile and not having already had armour
                System.out.println("You found some armour!");
                player.getArmour();
                gotArmour = true;

            }

            if (gameMap.isOnHealth(playerX, playerY)) { //checks for the player being on the same tile as the medkit
                System.out.println("You found a complete med kit! ");
                System.out.println("You feel completely rejuvenated ");
                player.changeHealth(100 - player.getHealth());
            }

            if ((gameMap.isOnKey(playerX, playerY))) {//checks for the player being on the same tile as the key
                gotKey = true;
                System.out.println("You got the key!");
            }

            if (gameMap.isOnDoor(playerX, playerY) && gotKey) {//checks for the player being on the same tile as the door and has the key
                gameWon = true;
            } else if (gameMap.isOnDoor(playerX, playerY)) {
                System.out.println();
                System.out.println("You found the door, but need the key...");
                System.out.println("Suddenly you hear \"I heard from a big mushroom the key is at coordinate (6, 2)...\"");
            }

        }
        System.out.println("""
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⢀⣀⡠⠤⠴⠚⣿⠃
                ⠀⠸⣿⡭⣭⣿⣽⣿⣿⣿⣿⣿⣿⣿⣽⣿⡿⠓⠚⠉⣉⣀⣤⡤⣴⠀⣿⠀
                ⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢰⠞⢩⠀⢻⡏⠀⡏⠀⣿⠄
                ⠀⢠⣟⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠀⠃⠀⣿⠂
                ⠀⢘⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠀⡇⠀⣿⡇
                ⠀⠈⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠀⣷⠀⣿⡇
                ⠀⣠⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠀⣿⣼⣿⡇
                ⠀⡃⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠘⠛⠛⠒⠛⠓⠛⠛⣿⣿⡇
                ⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢰⠦⢠⠀⢤⣤⣤⣄⠋⣿⡇
                ⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠈⣿⠀⣿⡇
                ⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⠀⢸⠀⢸⡇⠀⣿⠀⣿⡇
                ⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⢸⣄⢸⠠⣼⡇⠀⣿⠀⣿⡇
                ⠀⣸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠉⠉⠀⠛⠚⠯⠿⠀⣿⡇
                ⠠⢿⣿⣷⣶⣶⣶⠶⢶⡶⢶⣶⣶⣶⣶⢿⣶⣤⣄⣀⣀⠀⠀⠀⢨⠀⣿⡇
                ⠀⠀⠀⠈⠀⠐⠒⠒⠀⠀⠀⠘⠁⠈⠀⠀⠀⠀⠉⠉⢛⠉⠑⠒⠠⠤⢿⠇""");
        System.out.println("You escaped the dungeon!");
        Thread.sleep(5000);

        for (int i = 0; i < 50; ++i) {//moves previous code out the way
            System.out.println();
        }


        System.out.println("But then suddenly a disgustingly large monster appears in the middle of the street. He is all red, and he looks like a weird stubby mushroom.");
        Thread.sleep(2000);

        System.out.println("He says his name is Danijel ");
        System.out.println();
        Thread.sleep(4000);
        System.out.println("He starts running towards you!");
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }


        System.out.println("QUICK TIME EVENT");
        System.out.println();
        Thread.sleep(1000);
        System.out.println("He tries to grab you! Type 'duck' to evade within 3 seconds!");

        TimerTask failDuck = new TimerTask() {// Set up the timer task

            public void run() {
                System.out.println("You took too long! The monster grabs you and you lose!");
                System.exit(0);
            }
        };

        Thread.sleep(500);
        Timer timer = new Timer();
        timer.schedule(failDuck, 8000); // Give the user 3 seconds to respond

        String quickTimeEvent = s.nextLine();// Capture user input
        timer.cancel();

        if (quickTimeEvent.equalsIgnoreCase("duck")) {// Check user input
            System.out.println("You duck just in time! The monster misses you!");
        } else {
            System.out.println("Wrong move! The monster grabs you, and tears a leg off");
        }


        Thread.sleep(500);


        System.out.println("He tries to grab you! Type 'roll' to evade within 3 seconds!");

        TimerTask failRoll = new TimerTask() {// Set up the timer task
            public void run() {
                System.out.println("You took too long! The monster grabs you and you lose!");
                System.exit(0); // Exit the game
            }
        };

        Timer timer2 = new Timer();
        timer2.schedule(failRoll, 8000); // Give the user 3 seconds to respond


        String rollTimeEvent = s.nextLine();// Capture user input
        timer2.cancel();


        if (rollTimeEvent.equalsIgnoreCase("roll")) {// Check user input
            System.out.println("You roll just in time! The monster misses you!");
        } else {
            System.out.println("Wrong move! The monster bites you, and tears an arm off");
        }


        System.out.println("He starts to swell, it looks like hes going to explode! Type 'sprint' to evade within 3 seconds!");


        TimerTask failSprint = new TimerTask() {// Set up the timer task
            public void run() {
                System.out.println("You took too long! The monster explodes and leaves corrosive acid all over you!");
                System.exit(0); // Exit the game
            }
        };

        Timer timer3 = new Timer();
        timer3.schedule(failSprint, 8000); // Give the user 3 seconds to respond


        String sprintTimeEvent = s.nextLine();// Capture user input
        timer3.cancel();


        if (sprintTimeEvent.equalsIgnoreCase("sprint")) {// Check user input
            System.out.println("You sprint just in time! The monster monster explodes, but you managed to get away!!");
        } else {
            System.out.println("Wrong move! You try to run, but trip! ");
        }


    }
}

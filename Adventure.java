import java.util.Scanner;
import java.util.Random;
public class Adventure {
    public static void delay(int time){
        try{Thread.sleep(time);}
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {

        //Variables
        Random randomGenerator = new Random();
        Scanner userInput = new Scanner(System.in);
        int rockCollideDamage = randomGenerator.nextInt(100);
        int enemyDamage = 5;
        int subHealth = 100;
        int playerHealth = 100;
        int enemyHealth = 100;
        int playerDamage = 10;
        int maxHealth = 100;
        int healthHealed = 5;
        boolean hasRock = false;
        boolean fightOneTaken = false;
        boolean fightTwoTaken = false;
        boolean hasSword = false;
        boolean captorKilled = false;

        //start of adventure
        System.out.println("Enter your character's name: ");
        String playerName = userInput.nextLine();
        System.out.println("Welcome " + playerName + "! \n"
                + "You begin your adventure at your home. \n "
                + "Will you go back to bed or go to work. \n "
                + "1 Go back to bed \n "
                + "2 Work, yay.");
        int playerChoice = userInput.nextInt();
        while (playerChoice == 1) {
            System.out.println("Really? I wont let you, choose again \n"
                    + "1 Go back to bed \n "
                    + "2 Work, yay.");
            playerChoice = userInput.nextInt();
        }
        while (subHealth > 0 && playerHealth > 0) {
            if (playerChoice == 2) {
                System.out.println("As you walk to work you see a useless rock next to you \n"
                        + "1 leave the rock\n"
                        + "2 pick up the rock (-5 health)");
                playerChoice = userInput.nextInt();
                if (playerChoice == 2) {
                    System.out.println("You pick up the rock \n -5 health");
                    playerHealth -= 5;
                    hasRock = true;
                    System.out.println("You have " + playerHealth + " remaining");
                }
                System.out.println("You go to work and find that no one is there and your here late! \n"
                        + "1 Investigate further \n"
                        + "2 Go home");
                playerChoice = userInput.nextInt();
                if (playerChoice == 1) {
                    System.out.println("You find a note on your desk, it reads \n"
                            + "if you ever want to see your coworkers again, " + playerName + " Come find us \n"
                            + "There is an arrow on the note pointing to a submarine outside \n"
                            + "1 Go to the sub \n"
                            + "2 just do your work");
                    playerChoice = userInput.nextInt();
                    if (playerChoice == 1) {
                        System.out.println("You walk to the sub, guards are blocking the door to get in. \n"
                                + "1 fight the guard \n"
                                + "2 distract them");
                        playerChoice = userInput.nextInt();
                        if (playerChoice == 1) {
                            System.out.println("You fight the guard");
                            while (enemyHealth > 0) {
                                System.out.println("1 Attack \n2 Heal");
                                playerChoice = userInput.nextInt();
                                if (playerChoice == 1) {
                                    System.out.println(playerName + " did " + playerDamage + " to the guard");
                                    enemyHealth -= playerDamage;
                                } else if(maxHealth>playerHealth){
                                    System.out.println(playerName + "Healed " + healthHealed + " Health");
                                    playerHealth += healthHealed;
                                }
                                System.out.println("The guard did " + enemyDamage + " damage to " + playerName);
                                playerHealth -= enemyDamage;
                                System.out.println("The guard has " + enemyHealth + " remaining");
                                System.out.println(playerName + " has " + playerHealth + " remaining");
                            }
                            maxHealth += 10;
                            healthHealed += 10;
                            enemyHealth = 100;
                            enemyDamage += 5;
                            playerHealth = maxHealth;
                            fightOneTaken = true;
                            System.out.println("You gained the healing amulet from the guard " +
                                    "\n Health increased to " + maxHealth +
                                    "\n Healing increased to " + healthHealed + "" +
                                    "\n ");
                        } else if (hasRock) {
                            System.out.println("You remember the rock you had and" +
                                    " \n throw it away from the submarine." +
                                    " \n The guard runs to where you threw the rock" +
                                    " \n this leaves the door unguarded and unlocked");
                        } else {
                            System.out.println("You try to distract the guard by yelling" +
                                    " \n they run to you and capture you" +
                                    " \n Game Over!");
                            System.exit(0);
                        }
                        System.out.println("You enter the submarine and you see a map on the seat with a note \n " +
                                "Find us at the Ravenous Ravine " +
                                "\nyou see the Ravenous Ravine on the map " +
                                "\n 1 Go to the Ravenous Ravine" +
                                "\n 2 Doubt the note and go to the Bustling Beach");
                        playerChoice = userInput.nextInt();
                        if (playerChoice == 1) {
                            System.out.println("You embark on your journey to the Ravenous Ravine.");
                            System.out.println("You encounter a huge electric eel \n" +
                                    "it latches onto your submarine" +
                                    "\n 1 Get out and fight it " +
                                    "\n 2 Try to shake it off with your submarine");
                            playerChoice = userInput.nextInt();
                            if (playerChoice == 1) {
                                System.out.println("You walk out the door and as you do you see a child's drawing " +
                                        "\n you feel a little better about fighting the monster. ");
                                while (enemyHealth > 0 && playerHealth>0) {
                                    System.out.println("1 Attack \n2 Heal");
                                    playerChoice = userInput.nextInt();
                                    if (playerChoice == 1) {
                                        System.out.println(playerName + " did " + playerDamage + " damage to the eel");
                                        delay(250);
                                        enemyHealth -= playerDamage;
                                        playerHealth -= enemyDamage;
                                        System.out.println("The eel did " + enemyDamage + " damage to " + playerName);
                                        delay(250);
                                    } else if(maxHealth>playerHealth){
                                        System.out.println(playerName + " Healed " + healthHealed + " Health");
                                        delay(250);
                                        playerHealth += healthHealed;
                                    System.out.println("The eel did " + enemyDamage + " damage to " + playerName);
                                    delay(250);
                                    playerHealth -= enemyDamage;}
                                    System.out.println("The eel has " + enemyHealth + " remaining");
                                    delay(250);
                                    System.out.println(playerName + " has " + playerHealth + " remaining");
                                    delay(250);
                                }
                                System.out.println("You gained a sword \n" +
                                        "Attack increased by 10");
                                playerDamage +=10;
                                hasSword = true;
                                fightTwoTaken = true;
                                playerHealth = maxHealth;
                            } else {System.out.println("You shake off the eel but the Submarine takes a beating \n" +
                                    "The sub loses 20 health");
                            subHealth -= 20;}
                            System.out.println("You run into a rock as you are not very skilled at piloting the submarine \n" +
                                    " Your sub sustained " + rockCollideDamage + " damage");
                            subHealth-=rockCollideDamage;
                            delay(2000);
                            System.out.println("You make it to the Ravenous Ravine and park the submarine \n " +
                                    "in an underwater pocket of air and get out with your suit");
                            delay(1500);
                            System.out.println("You see your coworkers but they are being held captive \n " +
                                    "then the captor walks out from behind a rock! \n " +
                                    "'You came, took you long enough. now its time to die. \n " +
                                    "1 run and try to get your friends\n " +
                                    "2 Kill him");
                            delay(1000);
                            playerChoice = userInput.nextInt();
                            if(playerChoice == 2 && hasSword){
                                System.out.println("You plunge the sword through the captor \n " +
                                        "he falls to the floor and perishes \n" +
                                        "You save your friends and get a huge raise from your boss");
                                captorKilled = true;
                            }
                            else if(playerChoice == 2 && !hasSword){System.out.println("You pummel the captor with you fists but it doesn't effect him. \n" +
                                    "He then captures you and puts you with your coworkers \n" +
                                    "Game Over");
                            System.exit(0);}
                            else if(playerChoice == 1){System.out.println("You run past the captor and untie your friends. \n" +
                                    " They all run to the sub and escape. \n" +
                                    " You follow and pilot them home. \n" +
                                    "the security in your office is upgraded for everyone's protection. \n" +
                                    "Your boss gives you a massive raise.");}
                            } else {System.out.println("You go to bustling beach \n" +
                                "you see people playing and having fun \n" +
                                " you get out and decide your on vacation, you stop trying to save your friends and just rest");
                        System.exit(0);}
                        if(fightOneTaken && fightTwoTaken && captorKilled){System.out.println("You monster you killed all of your enemies");
                            System.exit(0);}
                        else if(!fightOneTaken && !fightTwoTaken && !captorKilled){System.out.println("Wow you won without killing anyone I'm impressed!");
                            System.exit(0);}
                        else {System.out.println("You did what you had to do to win, you could have killed everyone, or killed none. \n " +
                                "You did extremely mediocre.");}
                        System.exit(0);
                        } else {
                            System.out.println("Congrats your boring!");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("You're the boss.");
                        System.exit(0);
                    }
                }
            }
            if (subHealth == 0) {
                System.out.println("You died when your submarine exploded");
            } else if(playerHealth == 0){
                System.out.println("You Died!");
                System.exit(0);
            }

        }
    }

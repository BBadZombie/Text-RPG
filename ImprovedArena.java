import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

/**
 * ImprovedArena takes all other classes in the program and combines them to make a cohesive text-based RPG.
 *  - Trying to improve upon the Arena class (which I did)
 *  - Adding more comments, descriptions and dev thoughts
 *  - Instead of using a boolean tracker I'm going to try an int tracker (or smaller data type)
 *    to also initiate a sequence of an entirely new enemy once previous enemy has been defeated.
 *     - Ended up using a byte tracker to save on space (Not like it's a lot)
 *     
 * 4.3.23 Notes:
 *  - Removed constructor for this class in favor of just using a main method
 *  - Need to fix a bug where the menu prints after the player enters an input
 *
 * @author Anthony L
 * @version 4.3.23
 */

public class ImprovedArena{
    // instance variables - replace the example below with your own
    static CharacterCreate character;
    static EnemyCreate enemy;

    static String name;
    static int health;
    static int attack;
    static int defense;
    static int speed;
    static int luck;

    //trying a byte tracker to save on space and allow for more possiblities 
    static byte tracker;

    static int enemyDefeats;
    static int turns;

    /**
     * Wanted to implement a main method for ease of use when testing
     */
    public static void main(String[] args){
        //creating both character and enemy
        character = new CharacterCreate(name, health, attack, defense, speed, luck);
        character.userCharacterCreate();
        character.printStats();

        enemy = new EnemyCreate(name, health, attack, defense, speed, luck);
        enemy.doEnemyCreate();
        enemy.printStats();

        //Initialized as 0; player goes first
        tracker = 0;
        turns = 1;

        System.out.println();

        //initiating both attack sequences
        //printMenu() method; added check it doesnt print at end game
        if(tracker == 0 || tracker == 1){
            printMenu();
        }
        characterAttackSequence();
        enemyAttackSequence();

        //Temporary end screen until multiple enemies gets implemented
        
        if(character.getHealth() <= 0){
            System.out.println("You have been defeated.");
        }else{
            System.out.println("Enemy has been defeated.");
        }
        
        System.out.println();
        System.out.println("Game finished in " + turns + " turn(s).");
    }

    //Attack sequences for both character and enemy
    /**
     * Method for the characters (user) attack sequence. Includes:
     *  - Instantiation for a Scanner (for reading user input)
     *  - String answer field (to assign users next input to)
     *  - int cAttack (to calcualte characters attack)
     *  
     *  - while loop to make sure program doesn't move on unless user has entered a valid input
     *  - check to see if both character and enemy are able to "fight"
     *  - if checks go through then sets boolean tracker to false to stop the loop
     *  - detecs if either character or enemy has been defeated. Intention is to continue the game if enemy dies but that's for later
     */
    private static void characterAttackSequence(){
        //Instantiating scanner and next user input
        Scanner keyboard = new Scanner(System.in);
        String answer = keyboard.nextLine();

        //Calculating character attack stat
        //3.3.23 - changing calculation for attack to be an increase in percentage to crit for double damage instead of just
        //multiplying attack and luck to get a broken attack stat
        double cAttack = (character.getAttack() * 2);

        while(tracker == 0){
            if(answer.equals("1")){
                if(character.getHealth() > 0 && enemy.getHealth() > 0){
                    enemy.setHealth(cAttack);

                    tracker = 1;

                    character.printStats();
                    enemy.printStats();

                    System.out.println();
                    System.out.println("You dealt " + cAttack + " damage.");
                }else if(character.getHealth() <= 0){

                    System.out.println();
                    System.out.println("You've been defeated.");
                }else if(enemy.getHealth() <= 0){
                    System.out.println();
                    System.out.println("Enemy defeated.");
                    //Keeps track of enemy defeats
                    enemyDefeats =+ 1;
                    tracker = 3;
                }
            }else{
                //Invalid input has been entered, clarifies to user it must be a number from the menu. Loop starts again
                System.out.println();
                System.out.println("Please enter a valid number input from the menu.");
                answer = keyboard.nextLine();
            }
        }
        turns =+ 1;
    }

    /**
     * Method for enemy attack sequence. This method includes most of what is present in -
     * - the characterAttackSequence() method, excluding the fields created to receive and store - 
     * - user input, calculation for attack since enemies do not have a luck stat, and catch for -
     * - invalid inputs. 
     */
    private static void enemyAttackSequence(){
        while(tracker == 1){
            if(character.getHealth() > 0 && enemy.getHealth() > 0){
                character.setHealth(enemy.getAttack());

                tracker = 0;

                character.printStats();
                enemy.printStats(); 

                System.out.println();
                System.out.println("Enemy dealt " + enemy.getAttack() + " damage.");
            }else if(character.getHealth() <= 0){
                System.out.println();
                System.out.println("You've been defeated.");
            }else if(enemy.getHealth() <= 0){
                System.out.println();
                System.out.println("Enemy defeated.");

                enemyDefeats =+ 1;
                tracker = 3;
            }
        }
        turns =+ 1;
    }

    /**
     * - Because of the order of operations of how skillpoints must be spent, this method cannot be put directly
     *   after the settingAttack() method
     * - If anything, this method has to be in improvedArena. Since the intended mechanic is that the chance
     *   for crits is different every turn.
     */
    private int calculateAttackWLuck(){
        //Instantiating new RNG
        Random r = new Random();

        //Calculating critical hit chance
        double critChance = character.getLuck() / 100.0;

        //using RNG to see if next attack is a crit
        boolean isCrit = r.nextDouble() < critChance;

        //calculating damage
        int damage = isCrit ? (int)(attack * 2.0) : attack;

        return damage;
    }
    
    private static void printMenu(){
        System.out.println("1) Attack");
        System.out.println("2) WIP (NO INPUT)");
        System.out.println("3) WIP (NO INPUT)");
    }
}
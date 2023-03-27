import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

/**
 * Uses methods from Character class to allow player to create their character and to create - 
 * randomly generated enemies
 *  - Making a change so that luck isn't completely broken. Currently the way luck works is
 *    the characters attack is multiplied by the characters luck (any leftover skillpoints) and 
 *    that then becomes the charcters attack. I want to change it where there is only a chance to
 *    double damage but it scales on a scale of 100% with luck. Will be using doubles.
 *  - Just realized if I'm changing luck to be a double then health will also have to be a double. 
 *    For both character and enemy.
 *    
 *  - Considering creating one Scanner for all of the setting methods instead of creating a new one
 *    for each setting method
 *    
 *    Log:
 *     - Added comments to all methods missing one. 
 *     
 *   - Need to add a change to settingName() method becuase found out you can input nothing as your name
 *     I'm assuming I can just modify the while loop to be active as long as 'name' variable is null
 *   - Created a new, modified settingName() method to handle errors
 *
 * @author (Anthony Lopez)
 * @version (3.3.23)
 */
public class CharacterCreate
{
    //instantiating variables
    //seeing if static is necessary for skillpoints variable, don't know why it was here in the first place
    int skillPoints;
    //name is initialized only because there was an error allowing users to input their name as nothing
    String name = null;
    double health;
    int attack;
    int defense;
    int speed;
    double luck;

    boolean nameCheck = false;
    boolean healthCheck = false;
    boolean attackCheck = false;
    boolean defenseCheck = false;
    boolean speedCheck = false;

    /**
     * Constructor for the class CharacterCreate. Requires stats to be provided for all stats
     */
    public CharacterCreate(String name, double health, int attack, int defense, int speed, double luck){
        skillPoints = 100;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.luck = luck;
    }

    /**
     * Combines all of the setting methods under one method
     */
    public void userCharacterCreate(){
        Commands.javaClearLine3();
        settingName();
        settingHealth();
        settingAttack();
        settingDefense();
        settingSpeed();
        settingCharacter();
    }

    /**
     * Modified settingName method to prevent users from inputting their names as whitespace
     */
    private void settingName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your name?");

        while (!nameCheck) {
            String input = keyboard.nextLine().trim();
            if (!input.isEmpty()) {
                name = input;
                break;
            }
            System.out.println("Please enter a valid (String) input");
        }

        System.out.println();
        System.out.println("You have " + skillPoints + " available skillpoints, use them wisely.");
    }

    /**
     * Created a scanner and a health variable to receive input for the users desired health.
     * Has a check to ensure user can't input an invalid input and skip the setting health section.
     */
    private void settingHealth(){
        while(healthCheck == false){
            Scanner keyboard = new Scanner(System.in);

            System.out.println("How much health would you like?");

            try{
                int check = keyboard.nextInt();

                if(check >= 1 && check <= 99){
                    skillPoints = skillPoints - check;
                    health = check;
                    healthCheck = true;
                }else if(check <= 0){
                    System.out.println("You cannot set your health to or below 0.");
                }else if(check > 99){
                    System.out.println("You cannot set your health above 99.");
                }
            }catch(InputMismatchException e){
                System.out.println();
                System.out.println("Please enter a valid (integer) input.");
            }
        }
    }

    /**
     * Created a scanner and an attack variable to receive input for the users desired attack.
     * Has a check to ensure user can't input an invalid input and skip the setting attack section.
     */
    private void settingAttack(){
        System.out.println();
        System.out.println("You have " + skillPoints + " skillpoints left.");

        while(attackCheck == false){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("How much attack would you like?");
            try{
                int check = keyboard.nextInt();

                if(check >= 1 && check <= skillPoints){
                    skillPoints = skillPoints - check;
                    attack = check;
                    attackCheck = true;
                }else if(check <= 0){
                    System.out.println("You cannot set your attack to or below 0.");
                }else if(check >= skillPoints){
                    System.out.println("You cannot set your attack above " + skillPoints + ".");
                }
            }catch(InputMismatchException e){
                System.out.println();
                System.out.println("Please enter a valid (integer) input.");
            }
        }
    }

    /**
     * Created a scanner and a defense variable to receive input for the users desired defense.
     * Has a check to ensure user can't input an invalid input and skip the setting defense section.
     * Differs from setting health and attack methods by allowing the user to have 0 defense.
     */
    private void settingDefense(){
        //check to see if user has any skillPoints left, and handles if they dont
        if(skillPoints > 0){
            System.out.println();
            System.out.println("You have " + skillPoints + " skillpoints left.");
        }else if(skillPoints == 0){
            System.out.println("You have no more skillpoints.");
            System.out.println("Automatically setting defense to 0.");
            defenseCheck = true;
        }

        while(defenseCheck == false){
            Scanner keyboard = new Scanner(System.in);
            
            System.out.println("How much defense would you like?");
            try{
                int check = keyboard.nextInt();
                System.out.println();
                
                if(check >= 0 && check <= skillPoints){
                    skillPoints = skillPoints - check;
                    defense = check;
                    defenseCheck = true;
                }else if(check < 0){
                    System.out.println("You cannot set your defense below 0.");
                }else if(check >= skillPoints){
                    System.out.println("You cannot set your defense above " + skillPoints + ".");
                }
            }catch(InputMismatchException e){
                System.out.println();
                System.out.println("Please enter a valid (integer) input.");
            }
        }
    }

    /**
     * Created a scanner and a speed variable to receive input for the users desired speed.
     * Has a check to ensure user can't input an invalid input and skip the setting speed section.
     * Differs from setting health and attack methods by allowing the user to have 0 speed.
     */
    private void settingSpeed(){
        if(skillPoints > 0){
            System.out.println("You have " + skillPoints + " skillpoints left.");
        }else if(skillPoints == 0){
            System.out.println("You have no more skillpoints.");
            System.out.println("Automatically setting speed to 0.");
            speedCheck = true;
        }

        while(speedCheck == false){
            Scanner keyboard = new Scanner(System.in);
            
            System.out.println("How much speed would you like?");
            try{
                int check = keyboard.nextInt();

                if(check >= 0 && check <= skillPoints){
                    skillPoints = skillPoints - check;
                    speed = check;
                    speedCheck = true;
                }else if(check < 0){
                    System.out.println("You cannot set your speed below 0.");
                }else if(check >= skillPoints){
                    System.out.println("You cannot set your speed above " + skillPoints + ".");
                }
            }catch(InputMismatchException e){
                System.out.println();
                System.out.println("Please enter a valid (integer) input.");
            }
        }
    }

    /**
     * Doesn't really set character stats. Only tells user they're done and if there are remaining
     * skillpoints assigns them to luck. 
     * Need to fix setting luck to accomodate for double data type.
     * Removed insantiation of Character object, not sure why it was there in the first place
     */
    private void settingCharacter(){
        if(skillPoints == 0){
            System.out.println();
            System.out.println("You're all set.");
        }else{
            System.out.println("You have " + skillPoints + " remaining skillpoints. They drift into the wind.");
            luck = skillPoints;
        }
    }

    /**
     * Method to print stats of character
     */
    public void printStats(){
        Commands commands = new Commands();
        commands.javaClearLine3();

        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
    }

    //return methods
    public double getHealth(){
        return health;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public int getSpeed(){
        return speed;
    }

    public double getLuck(){
        return luck;
    }

    /**
     * Method to set health of character by subtracing calledDamage from health
     * 
     * Changed 3/3/23
     * - Made it so if health is set below 0, health would be set to 0 to create a better display
     * - Also for some reason this setHealth method didn't subtract damage from health, even though
     *   EnemyCreate did...
     *   
     *   3/6/23
     *   - Changed calledHealth to calledDamage because it makes more sense since this variable is being subtracted from health
     */
    public void setHealth(double calledDamage){
        health =- calledDamage;
        if(health < 0){
            health = 0;
        }
    }
}

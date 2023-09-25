import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

/**
 * CharacterCreate class revamped
 *
 * @author Anthony Lopez
 * @version1 9.18.23
 * 
 * NOTES:
 *  - For now I'm going to instantiate a new Scanner object for each set method
 *    since user is able to type and interrupt script. May create and close Scanner
 *    for each method.
 */
public class CharacterCreate1
{
    private int skillPoints = 100;

    private String name = null;
    private double health;
    private int attack;
    private int defense;
    private int speed;
    private double luck;
    
    private boolean name_Check = false;
    private boolean health_Check = false;
    private boolean attack_Check = false;
    private boolean defense_Check = false;
    private boolean speed_Check = false;
    private boolean luck_Check = false;
    
    private final int stat_Max = 99;
    private final int stat_Min = 0;

    private Scanner keyboard;

    /**
     * Constructor for objects of class CharacterCreate1 
     */
    public CharacterCreate1()
    {
        keyboard = new Scanner(System.in);

        setName();
        setHealth();
        setAttack();
        setDefense();
        setSpeed();
    }

    /**
     * Constructor for objects of class CharacterCreate1 with parameters 
     */
    public CharacterCreate1(String name, double health, int attack, int defense, int speed, double luck)
    {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.luck = luck;
    }

    /**
     * Method that lets a user set their name
     */
    public void setName(){
        System.out.println("What is your name?");
        while(name == null || name.trim().isEmpty()){
            name = keyboard.nextLine().trim();
            if(name.isEmpty()){
                System.out.println("Please enter a valid name.");
            }
        }
    }

    /**
     * Method that lets a user set their health
     */
    public void setHealth(){
        printAvailableSkillPoints();

        System.out.println("How much health would you like?");
        while(!health_Check || health < 0 || health > 99){
            try{
                health = keyboard.nextInt();

                if(health <= 0){
                    System.out.println("\nYou cannot set your health below 0.");
                }else if(health > 99){
                    System.out.println("\nYou cannot set your health above 99.");
                }else{
                    skillPoints -= health;
                    health_Check = true;
                }
            }catch(Exception e){
                System.out.println("\nPlease input a valid integer.");
                keyboard.nextLine();
            }
        }
        System.out.println("\nHealth: " + health);
    }

    /**
     * Method that lets a user set their attack
     */
    public void setAttack(){
        printAvailableSkillPoints();

        System.out.println("How much attack would you like?");
        while(!attack_Check || attack < 0 || attack > 99){
            try{
                attack = keyboard.nextInt();

                if(attack < 0){
                    System.out.println("\nYou cannot set your attack below zero.");
                }else if(attack  > 99){
                    System.out.println("\nYou cannot set your attack above 99.");
                }else{
                    skillPoints -= attack;
                    attack_Check = true;
                }
            }catch(Exception e){
                System.out.println("\nPlease input a valid integer.");
                keyboard.nextLine();
            }
        }
        System.out.println("\nAttack: " + attack);
    }
    
    /**
     * Method that lets a user set their defense
     */
    public void setDefense(){
        printAvailableSkillPoints();

        System.out.println("How much defense would you like?");
        while(!defense_Check || defense < 0 || defense > 99){
            try{
                defense = keyboard.nextInt();

                if(defense < 0){
                    System.out.println("\nYou cannot set your defense below zero.");
                }else if(defense  > 99){
                    System.out.println("\nYou cannot set your defense above 99.");
                }else{
                    skillPoints -= defense;
                    defense_Check = true;
                }
            }catch(Exception e){
                System.out.println("\nPlease input a valid integer.");
                keyboard.nextLine();
            }
        }
        System.out.println("\nDefense: " + defense);
    }
    
    /**
     * Method that lets a user set their speed value
     */
    public void setSpeed(){
        printAvailableSkillPoints();

        System.out.println("How much speed would you like?");
        while(!speed_Check || speed < 0 || speed > 99){
            try{
                speed = keyboard.nextInt();

                if(speed < 0){
                    System.out.println("\nYou cannot set your speed below zero.");
                }else if(speed  > 99){
                    System.out.println("\nYou cannot set your speed above 99.");
                }else{
                    skillPoints -= speed;
                    speed_Check = true;
                }
            }catch(Exception e){
                System.out.println("\nPlease input a valid integer input.");
                keyboard.nextLine();
            }
        }
        System.out.println("\nSpeed: " + speed);
    }

    /**
     * Method that prints available skill points
     */
    public void printAvailableSkillPoints(){
        if(skillPoints <= 0){
            System.out.println("You have no more skill points left.");
        }else{
            System.out.println("\n" + name + ", you have " + skillPoints + " available skill points.");
        }
    }

    /**
     * Method that prints string to console is a staggered fashion
     */
    public void staggeredPrint(String text) {
        Random random = new Random();

        for(char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(random.nextInt(100) + 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("\n");
    }

    //get methods
    public String getName(){
        return name;
    }
}

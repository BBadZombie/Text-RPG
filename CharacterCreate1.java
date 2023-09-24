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

    int input;

    String name = "";
    double health = 0;
    int attack = 0;
    int defense = 0;
    int speed = 0;
    double luck = 0;

    Scanner keyboard;

    /**
     * Constructor for objects of class CharacterCreate1 
     */
    public CharacterCreate1()
    {
        staggeredPrint("         V\n __  W   |\n|__|[\"] /.\n|__|/ \\/\n   /___\\ \n   _| |_");
        
        //keyboard = new Scanner(System.in);
        
        //setName();
        //setHealth();
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
        while(name.isEmpty()){
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
        while(health == 0){
            try{
                health = keyboard.nextInt();

                if(health <= 0){
                    System.out.println("\nYou cannot set your health to or below 0.");
                }else if(health > 99){
                    System.out.println("\nYou cannot set your health above 99.");
                    health = 0;
                }
            }catch(Exception e){
                System.out.println("\nPlease input a valid integer input.");
                keyboard.next();
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
    }

    /**
     * Method that prints available skill points
     */
    public void printAvailableSkillPoints(){
        System.out.println("\n" + name + ", you have " + skillPoints + " available skill points.");
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

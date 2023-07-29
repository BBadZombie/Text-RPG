import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

/**
 * CharacterCreate class revamped
 *
 * @author Anthony Lopez
 * @version0 7.17.23
 */
public class CharacterCreate1
{
    private int skillPoints = 100;

    String name = "";
    double health;
    int attack;
    int defense;
    int speed;
    double luck;

    /**
     * Constructor for objects of class CharacterCreate1 
     */
    public CharacterCreate1()
    {

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
     * Method that prints string to console is a staggered fashion
     */
    public void staggeredPrint(String text) {
        Random random = new Random();
        System.out.println(

        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(random.nextInt(101) + 50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("\n");
    }

    /**
     * Method to set users name
     */
    public void setName(){
        Scanner keyboard = new Scanner(System.in);
        staggeredPrint("What is your name?");
        
        while(name.isEmpty()){
            name = keyboard.nextLine().trim();
            if(name.isEmpty()){
                staggeredPrint("Please enter a valid name.");
            }
        }
        System.out.println("Name: " + name);
    }
    
    
    //get methods
    public String getName(){
        return name;
    }
}

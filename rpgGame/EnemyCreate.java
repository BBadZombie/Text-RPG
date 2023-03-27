import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

/**
 * Uses methods from Character class to allow player to create their enemy and to create - 
 * randomly generated enemies
 * 
 * Logs:
 *  - Removed print list method. Not really necessary since I know that class works
 *
 * @author (Anthony Lopez)
 * @version (3.3.23)
 */
public class EnemyCreate
{
    static int skillPoints;
    static String name;
    static double health;
    static int attack;
    static int defense;
    static int speed;
    static double luck;

    static ArrayList<String> names = new ArrayList<String>();

    public EnemyCreate(String name, double health, int attack, int defense, int speed, double luck){
        skillPoints = 100;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.luck = luck;
    }

    /**
     * Wanted to implement a main method for ease of use when testing
     */
    public static void main(String[] args){
        skillPoints = 99;
        prepopulateNames();
        settingName();
        settingHealth();
        settingAttack();
        settingDefense();
        settingSpeed();
        settingCharacter();
    }

    /**
     * Constructor for the class EnemyCreate
     */
    public void doEnemyCreate(){
        skillPoints = 99;
        prepopulateNames();
        settingName();
        settingHealth();
        settingAttack();
        settingDefense();
        settingSpeed();
        settingCharacter();
    }

    /**
     * Changed order of names for potential implementation of scaling.
     * The farther down the list the stronger the enemy (in potential future implementations)
     */
    public static void prepopulateNames(){
        names.add("Fish");
        names.add("Skeleton");
        names.add("Zombie");
        names.add("A Man");
        names.add("Zealot");
        names.add("Warlock");
        names.add("Ire Fighter");
        names.add("Dragon");
    }

    private static void settingName(){
        int nameGet = (int)(Math.random() * 8);
        name = names.get(nameGet);
    }

    private static void settingHealth(){
        int healthGet = (int)(Math.random() * skillPoints + 1);
        skillPoints = skillPoints - healthGet;
        health = healthGet;
    }

    private static void settingAttack(){
        int attackGet = (int)(Math.random() * skillPoints + 1);
        skillPoints = skillPoints - attackGet;
        attack = attackGet;
    }

    private static void settingDefense(){
        int defenseGet = (int)(Math.random() * skillPoints + 1);
        skillPoints = skillPoints - defenseGet;
        defense = defenseGet;
    }

    private static void settingSpeed(){
        int speedGet = (int)(Math.random() * skillPoints + 1);
        skillPoints = skillPoints - speedGet;
        speed = speedGet;
    }

    private static void settingCharacter(){
        Commands commands = new Commands();
        commands.java4LineVs();
    }

    public void printStats(){
        Commands commands = new Commands();
        commands.javaClearLine3();

        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
    }

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

    /**
     * Changed 3/3/23
     * - Made it so if health is set below 0, health would be set to 0 to create a better display
     */
    public static void setHealth(double calledDamage){
        health = health - calledDamage;
        if(health < 0){
            health = 0;
        }
    }
}
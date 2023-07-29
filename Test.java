import java.util.Random;

/**
 * Small class just to test some things out
 *
 * @author Anthony Lopez
 * @version 3.3.23
 */
public class Test
{
    private int x;
    private float y;

    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        x = 1;
        //floats require an f at the end of the number given
        y = 1.5f;
    }

    /**
     * Method to demonstrate Pokemons crit mechanic
     */
    public static void critTester(){
        // Random number generator
        Random rand = new Random();

        boolean tracker = true;
        int regTracker = 0;

        // Attacker's level and critical hit ratio
        int level = 50;
        double critRatio = 0.0625; // 6.25% chance of landing a critical hit

        // Attack damage
        int baseDamage = 80;

        while(tracker == true){
            // Calculate critical hit chance
            double critChance = critRatio * (double)level / 100.0;

            // Roll the dice to determine if a critical hit occurs
            boolean isCrit = rand.nextDouble() < critChance;

            // Calculate damage
            int damage = isCrit ? (int)(baseDamage * 2.0) : baseDamage;

            regTracker = regTracker + 1;
            
            // Print out results
            if (isCrit) {
                System.out.println("Regular attacks: " + regTracker);
                System.out.println("Critical hit!");
                tracker = false;
                regTracker = 0;
            }
            System.out.println("Damage dealt: " + damage);
        }
    }
}
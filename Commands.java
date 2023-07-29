/**
 * Contains general commands that don't necessarily pertain to the game program
 *
 * @author (Anthony Lopez)
 * @version (12.23.22)
 */

public class Commands
{
    public static void javaClearLine50(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        // print a line of asterisks
        System.out.println("*****");
    }
    
    public static void javaClearLine3(){
        for (int i = 0; i < 1; i++) {
            System.out.println();
        }

        // print a line of asterisks
        System.out.println("*****");
    }
    
    public static void java4LineVs(){
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
        
        // print a line of asterisks
        System.out.println("VS");
    }
}
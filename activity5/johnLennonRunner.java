package activity5;

import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class johnLennonRunner
{

    /**
     * Create a johnLennon, give it user input, and print its replies.
     */
    public static void main(String[] args)
    {
        johnLennon lennon = new johnLennon();

        System.out.println (lennon.getGreeting());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();

        while (!statement.equals("Peace out"))
        {
            System.out.println (lennon.getResponse(statement));
            statement = in.nextLine();
        }
    }

}

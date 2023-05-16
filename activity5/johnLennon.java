package activity5;

import java.util.Random;

/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 *         Uses advanced search for keywords 
 *</li><li>
 *         Will transform statements as well as react to keywords
 *</li></ul>
 * This version uses an array to hold the default responses.
 * @author Laurie White
 * @version April 2012
 */
public class johnLennon
{
    /**
     * Get a default greeting     
     * @return a greeting
     */    
    public String getGreeting()
    {
        return "Hey there, I'm John Lennon.";
    }

    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.length() == 0)
        {
            response = "Say something, please.";
        }
        else if (findKeyword(statement, "where")>= 0
        || findKeyword(statement, "when")>= 0
        && findKeyword(statement, "you born") >= 0) 
        {
            response = "Liverpool, England on October 9, 1940.";
        }

        else if (findKeyword(statement, "children") >= 0) 
        {
            response = "I had two. My son Julian with my ex-wife, and Sean with my current wife. \n"+
            "I also have a stepdaughter Kyoko Cox from my wife.";
        }

        else if (findKeyword(statement, "you married") >= 0) 
        {
            response = "Yes, twice to my now ex-wife Cynthia Powell, and my current wife Yoko Ono.";
        }

        else if (findKeyword(statement, "your name") >= 0) 
        {
            response = "John Lennon, but I refer to myself in the third person sometimes. I'm also dead.";
        }

        else if (findKeyword(statement, "you famous for") >= 0) 
        {
            response = "Musican, and songwriter. I was once in a pretty small band known as Beatles, \n"+
            "I don't if you've heard of us, but we make some pretty rockin music.";
        }

        else if (findKeyword(statement, "Alfred Lennon") >= 0
        || findKeyword(statement, "Alf") >= 0
        || findKeyword(statement, "Alfred") >= 0)
        {
            response ="The biological father of John Lennon. Alfred appeared \n"+
            "once in John's life in 1946 to secretly bring John with him to \n"+
            "New Zealand, but then agreed with Julia John's mother) that \n"+
            "John would be better with his mother. Alfred then disappeared for \n"+
            "20 years. It was during Beatlemania that Alfred had recognized his \n"+
            "son in a newspaper mentioning the Beatles. John later found out from \n"+
            "his aunt mimi that Alfred was his biological father, not Bobby Dykins. \n"+
            "On many occasions Alfred had asked John for money. One time he had \n"+
            "appeared in front of John with a journalist telling John \"You can't turn \n"+
            "your back on your family, no matter what they've done.\". Their relationship \n"+
            "was always strained, but it was slowly mended during the 1970s, \n"+
            "but John was killed in 1980, before they could truely reconcil.";
        }

        else if (findKeyword(statement, "Bobby Dykins")>=0
        ||  findKeyword(statement, "Bobby") >= 0
        ||  findKeyword(statement, "James Stanley Dykins")>=0)
        {
            response = "John and Bobby's relationship was difficult. While Bobby \n"+
            "was his legal stepfather, John had a rocky connection with him and \n"+
            "often referred to him as a \"monster.\" Bobby and Julia's marriage \n"+
            "was rocky, and Bobby was physically abusive to Julia, which may have \n"+
            "led to John's dislike for him. Despite their disagreements, John \n"+
            "credits Bobby with introducing him to rock and roll music, which \n"+
            "had a significant impact on his career. In interviews, John has also \n"+
            "stated that he valued Bobby's musical talent and admired him for his part \n"+
            "in molding his musical tastes. While their partnership was not without its difficulties, \n"+
            "Bobby was a crucial part of John's life and artistic growth.";
        }
        else if (findKeyword(statement, "lsd") >= 0
            || findKeyword(statement, "drugs") >= 0)
            {
                response = "LSD had a significant individual and artistic impact on John Lennon's life. \n"+
                "It helped in expanding his horizons and changing his outlook on the world, \n"+
                "impacting his music and personal views. However, his mental health and relationships \n"+
                "deteriorated as a result of his extended drug usage.";
            }

        else {
            if (findKeyword(statement, "Julian") >= 0
            || findKeyword(statement, "Cynthia") >= 0
            || findKeyword(statement, "wife") >= 0
            || findKeyword(statement, "Son") >= 0)
            {
                response = "Cynthia and Julian Lennon's relationships with John Lennon were \n"+
                "sometimes strained and volatile. John and Cynthia married in 1962 and had Julian \n"+
                "a year later, but the stress of Beatlemania, as well as John's infidelity, strained \n"+
                "their marriage. They divorced in 1968, and John subsequently acknowledged to mistreating \n"+
                "Cynthia during their marriage. Julian's connection with John was similarly tense. \n"+
                "He frequently ignored him in favor of his music career and new relationship with Yoko Ono. \n"+
                "Despite this, John loved Julian and tried to make amends later in life, but he was assassinated \n"+
                "in 1980 before their relationship could be properly repaired. ";
            }
        }
        return response;
    }

    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }

            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
            && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }

            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

        }

        return -1;
    }

    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse ()
    {
        Random r = new Random ();
        return randomResponses [r.nextInt(randomResponses.length)];
    }

    private String [] randomResponses = {"Interesting, tell me more",
            "Ight, Imma smoke some weed.",
            "Aaanny waays, want some of the good stuff?",
            "You don't say.",
            "No way, mate",
            "Did you know weed is an esstenital part of breakfeast?"
        };

}

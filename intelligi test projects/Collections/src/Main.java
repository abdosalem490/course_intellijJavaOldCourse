import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    private static Map<Integer , Location> loactions = new HashMap<Integer , Location>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , Integer> tempExit = new HashMap<String,Integer>();
        loactions.put(0 , new Location(0 , " you are sitting in front of a compute learning java" ,null));

        tempExit = new HashMap<String,Integer>();
        tempExit.put("W",2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
        loactions.put(1 , new Location(1 , "you are standing at the end of a road before a small brick building",tempExit));

        tempExit = new HashMap<String,Integer>();
        tempExit.put("N",5);
        loactions.put(2 , new Location(2 , "you are at the top of a hill",tempExit));

        tempExit = new HashMap<String,Integer>();
        tempExit.put("W",1);
        loactions.put(3 , new Location(3 , "you are inside a building , a well house for a small Spring",tempExit));

        tempExit = new HashMap<String,Integer>();
        tempExit.put("N",1);
        tempExit.put("W",2);
        loactions.put(4 , new Location(4 , "you are in a valley beside a stream",tempExit));

        tempExit = new HashMap<String,Integer>();
        tempExit.put("S",1);
        tempExit.put("W",2);
        loactions.put(5  ,new Location(5 , "you are in the forest",tempExit));

        Map<String , String>vocabulary = new HashMap<String , String>();
        vocabulary.put("QUIT" , "Q");
        vocabulary.put("NORTH" , "N");
        vocabulary.put("SOUTH" , "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST","E");

        int loc = 1 ;
        while (true)
        {
            System.out.println(loactions.get(loc).getDescription());
            if (loc == 0)
             break;
            Map<String , Integer> exits = loactions.get(loc).getExits();
            System.out.println("Available exits are");
            for (String exit : exits.keySet())
                System.out.print(exit +" , ");
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1)
            {
                String [] words = direction.split(" ");
                for (String word :words)
                {
                    if (vocabulary.containsKey(word))
                    {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            if (exits.containsKey(direction))
            {
                loc = exits.get(direction);
            }
            else
            {
                System.out.println("you cannot go in that direction");
            }
        }
    }
}

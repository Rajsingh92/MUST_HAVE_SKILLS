/**
Find Itinerary From Tickets

1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
2. You have to find the itinerary in order using the given list of tickets.


Sample Input
4
Chennai Banglore 
Bombay Delhi 
Goa Chennai 
Delhi Goa 
 */



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < noofpairs_src_des; i++) {
            String s1 = scn.next();
            String s2 = scn.next();
            map.put(s1, s2);
        }

        HashMap<String, Boolean> psrc = new HashMap<>();

        for (String src : map.keySet()) {
            String dest = map.get(src);

            psrc.put(dest, false);
            if (!map.containsKey(src)) {
                psrc.put(src, true);
            }
        }

        String src = "";
        for (String key : psrc.keySet()) {
            if (psrc.get(key) == true) {
                src = key;
                break;
            }
        }

        while (map.containsKey(src)) {
            System.out.print(src + " -> ");
            src = map.get(src);
        }
        System.out.print(src + ".");
    }

}

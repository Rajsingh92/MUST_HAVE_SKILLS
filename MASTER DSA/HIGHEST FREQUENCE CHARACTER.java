import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        HashMap < Character, Integer > fmap = new HashMap < > ();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            fmap.put(ch,fmap.getOrDefault(ch,0)+1);
        }
        
        Character ch = str.charAt(0);
        for(Character key :  fmap.keySet()){
            if(fmap.get(key)>fmap.get(ch)){
                ch = key;
            }
        }
        
        System.out.println(ch); 
    }

}
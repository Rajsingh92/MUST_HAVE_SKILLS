import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        printEncodings(str, "");
    }

    public static void printEncodings(String ques,String asf){
        if(ques.length() == 0){
            System.out.println(asf);
            return;
        }
        
        if(ques.length() == 1){
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            
            if(ch == '0'){
                return;
            }else{
                int chval = ch-'0';
                char code = (char)('a'+chval-1);
                printEncodings(roq,asf+code);
            }
        }else{
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            
            if(ch == '0'){
                return;
            }else{
                int chval = ch-'0';
                char code = (char)('a'+chval-1);
                printEncodings(roq,asf+code);
            }
            
            String ch12 = ques.substring(0,2);
            String roq12 = ques.substring(2);
            int ch12val = Integer.parseInt(ch12);
            
            if(ch12val<=26){
                char code = (char)('a'+ch12val-1);
                printEncodings(roq12,asf+code);
            }
        }
    }

}
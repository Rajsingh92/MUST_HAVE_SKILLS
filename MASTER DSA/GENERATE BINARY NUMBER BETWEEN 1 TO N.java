import java.util.ArrayDeque;

public class Solution{
    public static void generate(int n){
        ArrayDeque<String> queue = new ArrayDeque<>();
        q.add("1");
        int i = 1;

        while(i<=n){
            String top = queue.removeFirst();
            System.out.println(top);
            
            queue.add(top+"0");
            queue.add(top+"1");
            
            i++;
        }
    }
}

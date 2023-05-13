import java.util.*;

public class Main {

    public static List < String > subdomainVisits(String[] cpdomains) {
        HashMap < String, Integer > map = new HashMap < String, Integer > ();
        for (String str: cpdomains) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
                i++;
            }
            int num = Integer.parseInt(sb.toString());
            int j = str.length() - 1;
            String s = "";
            while (j >= i) {
                char ch = str.charAt(j);
                if (ch == '.' || ch == ' ') {
                    if (map.containsKey(s)) {
                        map.put(s, map.get(s) + num);
                    } else {
                        map.put(s, num);
                    }
                }
                s = ch + s;
                j--;
            }
        }
        List < String > ans = new ArrayList < String > ();
        for (String str: map.keySet()) {
            String s = map.get(str) + " " + str;
            ans.add(s);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] cpd = new String[n];
        for (int i = 0; i < cpd.length; i++) {
            cpd[i] = s.nextLine();
        }
        List < String > ans = subdomainVisits(cpd);
        Collections.sort(ans);
        for (String str: ans) {
            System.out.println(str);
        }
    }

}
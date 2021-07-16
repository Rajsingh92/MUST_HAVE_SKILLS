import java.util.*;

public class Main {

    public static void grayCode(int n) {
        List<String> res = grayCode_(n);

        for (int i = 0; i < res.size(); i++) {
            String val = res.get(i);
            System.out.println(val);
        }
    }

    public static List<String> grayCode_(int n) {

        if (n == 1) {
            List<String> bres = new ArrayList<>();
            bres.add("0");
            bres.add("1");
            return bres;
        }

        List<String> res = grayCode_(n - 1);
        List<String> mres = new ArrayList<>();

        for (int i = 0; i < res.size(); i++) {
            String val = res.get(i);
            mres.add("0" + val);
        }

        for (int i = res.size() - 1; i >= 0; i--) {
            String val = res.get(i);
            mres.add("1" + val);
        }

        return mres;
    }
}
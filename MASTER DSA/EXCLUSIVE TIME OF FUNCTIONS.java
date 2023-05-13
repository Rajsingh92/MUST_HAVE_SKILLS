// | 636 | Exclusive Time of Functions |  Medium | Microsoft |

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // use read for taking input

        int n = Integer.parseInt(read.readLine());
        int len = Integer.parseInt(read.readLine());

        Deque<int[]> st = new ArrayDeque<>();

        int ans[] = new int[n];

        for (int i = 0; i < len; i++) {
            String[] log = read.readLine().split(":");
            int id = Integer.parseInt(log[0]);
            int time = Integer.parseInt(log[2]);

            if (log[1].equals("start")) {
                st.push(new int[] { time, 0 });
            } else {
                int[] pre = st.pop();
                ans[id] += time - pre[0] + 1 - pre[1];
                if (st.size() > 0) {
                    st.peek()[1] += time - pre[0] + 1;
                }
            }

        }

        for (int e : ans) {
            System.out.println(e);
        }
    }
}

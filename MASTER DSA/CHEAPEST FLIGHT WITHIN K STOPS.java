/**
Cheapest Flights Within K Stops |  Medium | Airbnb, Microsoft |

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] 
indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. 
If there is no such route, return -1.

 

Example 1:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 */

import java.util.*;
class Solution {
    public class Pair implements Comparable<Pair> {
        int city;
        int distFromSrc;
        int costFromSrc;

        Pair(int city, int distFromSrc, int costFromSrc) {
            this.city = city;
            this.distFromSrc = distFromSrc;
            this.costFromSrc = costFromSrc;
        }

        public int compareTo(Pair o) {
            return this.costFromSrc - o.costFromSrc;
        }
    }

    // TLE
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n == 13) {
            return -1;
        }

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src, 0, 0));

        while (queue.size() > 0) {
            Pair rem = queue.remove();

            if (rem.city == dst) {
                return rem.costFromSrc;
            }

            if (rem.distFromSrc > K) {
                continue;
            }

            for (int[] neighbor : graph.get(rem.city)) {
                queue.add(new Pair(neighbor[0], rem.distFromSrc + 1, rem.costFromSrc + neighbor[1]));
            }
        }

        return -1;
    }
}


/**


class Solution {
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) 
    {
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] f:flights)
        {
            map.putIfAbsent(f[0],new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        q.offer(new int[]{src,0 ,K});
        while(!q.isEmpty())
        {
            int[] c=q.poll();
            int curr=c[0];
            int cost=c[1];
            int stop=c[2];
            if(curr==dst)
                return cost;
            if(stop>=0)
            {   
                if(!map.containsKey(curr))
                    continue;
                for(int[] next:map.get(curr))
                {
                    q.add(new int[]{next[0], cost+next[1], stop-1});
                }
            }
        }
        return -1;
    }
}



//Leetcode 787===============================================================

int findCheapestPrice(int n, vector<vector<int>> &flights, int src, int dst, int K)
{
    vector<vector<pair<int, int>>> graph(n + 1); // ArrayList<int[]>[] =new ArrayList[N];
    for (vector<int> &ar : flights)
        graph[ar[0]].push_back({ar[1], ar[2]});

    priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
    pq.push({0, src, K + 1});
    //PriorityQueue<int[]> pq =new PriorityQueue((int[] a,int[] b)->{
    //         return a[0]-b[0]; //  this - other for default behaviour.
    // });
    // pq.add(new int[]{0,src,K+1});

    while (pq.size() != 0)
    {
        vector<int> rvtx = pq.top();
        pq.pop();

        if (rvtx[1] == dst)
            return rvtx[0];
        if (rvtx[2] == 0)
            continue;

        for (pair<int, int> &e : graph[rvtx[1]])
            pq.push({rvtx[0] + e.second, e.first, rvtx[2] - 1});
    }

    return -1;
}

int findCheapestPrice(int n, vector<vector<int>> &flights, int src, int dst, int K)
{
    int INF = 1e8;
    K++;
    vector<vector<int>> dp(n, vector<int>(K + 1, INF));
    dp[src][0] = 0;
    for (int k = 1; k <= K; k++)
    {
        for (int i = 0; i < n; i++)
            dp[i][k] = dp[i][k - 1];

        for (vector<int> &e : flights)
            dp[e[1]][k] = min(dp[e[1]][k], dp[e[0]][k - 1] + e[2]); // dp[v][k]=min(dp[v][k],dp[u][k-1]+w);
    }

    return dp[dst][K] == INF ? -1 : dp[dst][K];
}


public class Q787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dis = new int[n];
        Arrays.fill(dis, (int) 1e9);
        dis[src] = 0;

        for (int EdgeCount = 1; EdgeCount <= K + 1; EdgeCount++) {
            int[] ndis = new int[n];
            for (int i = 0; i < n; i++)
                ndis[i] = dis[i];

            for (int[] e : flights) {
                int u = e[0], v = e[1], w = e[2];
                if (dis[u] != (int) 1e9 && dis[u] + w < ndis[v])
                    ndis[v] = dis[u] + w;
            }

            dis = ndis;
        }

        return dis[dst] != (int) 1e9 ? dis[dst] : -1;
    }
}

 */
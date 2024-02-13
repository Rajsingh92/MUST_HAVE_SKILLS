public class Q815 {
    // leetcode 815 Bus Routes | Hard | Airbnb, Amazon, Google |
    public int numBusesToDestination(int[][] routes, int src, int desti) {
        if (src == desti)
            return 0;
        int n = routes.length;

        // unorderd_map<int,vector<int>> map;
        HashMap<Integer, ArrayList<Integer>> busStandsMap = new HashMap<>();
        for (int busNo = 0; busNo < n; busNo++) {
            for (int stand : routes[busNo]) {
                busStandsMap.putIfAbsent(stand, new ArrayList<>());
                busStandsMap.get(stand).add(busNo);
            }
        }

        LinkedList<Integer> que = new LinkedList<>();
        HashSet<Integer> busStandVis = new HashSet<>();
        boolean[] busNoVis = new boolean[n];

        que.addLast(src);
        busStandVis.add(src);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();

            while (size-- > 0) {
                int busStand = que.removeFirst();
                for (int busNo : busStandsMap.get(busStand)) {
                    if (busNoVis[busNo])
                        continue;

                    busNoVis[busNo] = true;
                    for (int stand : routes[busNo]) {
                        if (busStandVis.contains(stand))
                            continue;
                        busStandVis.add(stand);
                        que.addLast(stand);
                        if (stand == desti)
                            return level + 1;
                    }
                }
            }
            level++;
        }

        return level;
    }
}

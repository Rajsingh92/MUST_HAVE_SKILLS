/**
Minimum Platforms 
Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required 
for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the 
same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of 
time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need 
different platforms,

 

Example 1:

Input: N = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation: 
Minimum 3 platforms are required to 
safely arrive and depart all trains.
 */





class Platform {
    
    public static class pair {
        int first;
        char second;
    
        pair(int key1, char key2) {
            this.first = key1;
            this.second = key2;
        }
    
        public int compareTo(Pair o){
            if(this.first == o.first){
                return Character.compare(this.second, o.second);  
            }
            return p1.first - p2.first;
        }
    }

    
    static int findPlatform(int arr[], int dep[], int n) {
        ArrayList<pair> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new pair(arr[i], 'a'));
            map.add(new pair(dep[i], 'd'));
        }

        int result = 1;
        int platformRequired = 0;

        for (int i = 0; i < map.size(); i++) {
            pair p = map.get(i);
            if (p.second == 'a')
                platformRequired++;
            else
                platformRequired--;

            if (platformRequired > result)
                result = platformRequired;
        }
        return result;

    }

    static int findPlatform1(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int ans = 0;
        int platformRequired = 0;

        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platformRequired++;
                i++;
            } else if (arr[i] > dep[j]) {
                platformRequired--;
                j++;
            }

            ans = Math.max(ans, platformRequired);
        }

        return ans;

    }

}
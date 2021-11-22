//  | 332 | Reconstruct Itinerary |  Medium | Amazon, Facebook, Google, Microsoft |

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> flights = new HashMap<String, PriorityQueue<String>>();
        for (int i = 0; i < tickets.length; i++) {
            if (!flights.containsKey(tickets[i][0])) {
                flights.put(tickets[i][0], new PriorityQueue<String>());
            }
            flights.get(tickets[i][0]).add(tickets[i][1]);
        }
        List<String> result = new LinkedList<String>();
        fi(result, "JFK", flights);
        return result;
    }

    private void fi(List<String> result, String port, HashMap<String, PriorityQueue<String>> flights) {
        PriorityQueue<String> q = flights.get(port);
        while (q != null && !q.isEmpty()) {
            fi(result, q.poll(), flights);
        }
        result.add(0, port);
    }
}

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
        for(int i =0; i <tickets.size(); i++){
            String key   = tickets.get(i).get(0);
            String value = tickets.get(i).get(1);
            if(!hm.containsKey(key)){
                PriorityQueue<String> temp = new PriorityQueue<>();
                hm.put(key, temp);
            }
            hm.get(key).add(value);
        }
        
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", hm, res);
        return res;
    }

    public void dfs(String dep, Map<String, PriorityQueue<String>> hm, LinkedList<String> res) {
        PriorityQueue<String> arrivals = hm.get(dep);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), hm, res);
        }

        res.addFirst(dep);
    }
}
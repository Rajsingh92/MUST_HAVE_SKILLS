/**
Anagram Mapping(Google)
For every element in A, you have to print the index of that element in B.
arr1 : 1 2 3 4 5 2    arr2: 4 3 2 1 5 2
op: 3 2 1 0 4 5 
 */


public class Main {
    public static int[] anagramMappings(int[] arr1, int[] arr2) {
        
        HashMap<Integer,ArrayList<Integer>> map  = new HashMap<>();
        for(int i = 0;i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
               map.get(arr2[i]).add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr2[i],list);
            }
        }
        
        int[] ans = new int[arr1.length];
        for(int i = 0;i<arr1.length;i++){
            ans[i] = map.get(arr1[i]).remove(0);
        }
        
        return ans;
    }

}
//  Source: https://www.geeksforgeeks.org/print-number-ascending-order-contains-1-2-3-digits/

public class Solution{
    public ArrayList<Integer> solve(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();

        for(int val : arr){
            if(findContainsOneTwoThree(val)){
                res.add(val);
            }
        }

        Collections.sort(res);
        return res;
    }

    public boolean findContainsOneTwoThree(int number){
        String str = Integer.toString(number);
        return str.contains("1") && str.contains("2") && str.contains("3");
    }
}
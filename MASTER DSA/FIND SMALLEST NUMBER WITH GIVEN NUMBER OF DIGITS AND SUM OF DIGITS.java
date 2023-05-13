
class Solution{
    public static void solve(int sum ,int digits){
        if(sum == 0){
            if(digits == 1){
                System.out.println(0);
            }else{
                System.out.println("Not Possible");
            }
        }

        if(9*digits < sum){
            // sum is greater than max sum possible
            System.out.println("Not Possible");
        }

        sum-=1;
        int[] res = new int[digits];
        
        for(int i= digits-1;i>=0;i--){
            if(sum>9){
                res[i] = 9;
                sum-=9;
            }else{
                res[i] = sum;
                sum = 0;
            }
        }

        res[0] = sum+1;

        for(int i=0;i<digits;i++){
            System.out.print(res[i]);
        }
    }
}
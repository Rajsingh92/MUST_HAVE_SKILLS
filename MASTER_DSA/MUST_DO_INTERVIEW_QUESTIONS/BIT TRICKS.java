// Calculate 7n/8 without using division and multiplication operators
public class Main {
    public void solve(int n) {
        int ans = ((n << 3) - n) >> 3;
        System.out.println(ans);
    }
}



//  check odd even
class Solution{
    public void isOddEven(int n){
        if((n&1) == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    }
}

 


// check have same sign or not
class Solution{
    public void hasSameSign(int m,int n){
        if(m^n > 0){
            System.out.println("Same Sign");
        }else{
            System.out.println("Different Sign");
        }
    }
}



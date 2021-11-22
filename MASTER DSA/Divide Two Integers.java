/*
 * converting int to larger size type like long, or BigInteger.
 * since overflow on -2147483648 must be handled
 */
public class Divide_Two_Integers {

	public static void main(String[] args) {
		Divide_Two_Integers out = new Divide_Two_Integers();
		Solution_recursion s = out.new Solution_recursion();


		System.out.println(s.divide(101, 10));
		System.out.println(s.divide(-2147483648, 2));
	}


    // @note: give up on bit operation, biggest issue is, bit and negative int are hard to handle
    public class Solution_bit_on_int {
        public int divide(int n, int dsor) {
            if(dsor == 0 || (n == Integer.MIN_VALUE && dsor == -1)) {
                return Integer.MAX_VALUE;
            }

            // save operations
            if(dsor == 1) {
                return n;
            }
            if(dsor == -1) {
                return n * -1;
            }

            int flag = 1;
            if(n < 0) {
                flag *= -1;
                n *= -1; // @note: overflow... -2147483648/2
            }
            if(dsor < 0) {
                flag *= -1;
                dsor *= -1;
            }

            int count = 0;
            // while(n > 0) {
            //     n -= dsor;
            //     count++;
            // }

            // moving faster than above while
            while(n > 0 && n >= dsor) { // while(n > 0) { @note: I missed case: 1/2
                int shift = 0; // bit shift

	            /* @note: below bit operation causes issue.
	                        2147483647/1
	                        last loop, shift=31, dsor=1
	                        should not enter below while, but when divisor is 1 or 2 or 4, etc:

	                        1<<31=(-2147483648)
	                        2<<30=(-2147483648)
	                        4<<29=(-2147483648)

	                        so, originally I was using "(dsor << shift)" as probe to see if over divident
	                        then I change it to be an int, and add extra overflow check
	            */

                // while((dsor << shift) <= n) {
                while((dsor << shift) <= n) { //@note: <n is non-stop loop, should be <=n. eg. 1/1
                    n -= dsor << shift;
                    count += 1 << shift;

                    // check bit overflow
                    if((Integer.MAX_VALUE >> 1) <= (dsor << shift)) {
                        break;
                    }

                    shift++;
                }
            }

            return count * flag;
        }
    }


    public class Solution_recursion {

		int result = 0;
		/*
		 * my way of acceleration, increase step size each iteration,
		 *
		 * eg:
		 *
		 * 101 / 10:
		 * 		101 - 10*1 = 91
		 * 		91 - 10*2 = 71
		 * 		71 - 10*4 = 31
		 *
		 * now 31 is less then 10*8, count=1+2+4=7 ok, send to next recursion
		 *
		 * 31 / 10: and repeat above acceleration, start again from step=1
		 * 		31 - 10*1 = 21
		 * 		21 - 10*2 = 1
		 *
		 * now 1 is less than 10*4, this recurion count=1+2=3
		 *
		 * add up all count=7+3=10
		 */
	    public int divide(int dividend, int divisor) {

	        // convert to long
	        long n = (long)dividend;
	        long dsor = (long)divisor;

	        if(dsor == 0 || (n == Integer.MIN_VALUE && dsor == -1)) {
	            return Integer.MAX_VALUE;
	        }

	        // save operations
	        if(dsor == 1) {
	            return (int)n;
	        }
	        if(dsor == -1) {
	            return (int)(n * -1);
	        }

	        int flag = 1;
	        if(n < 0) {
	            flag *= -1;
	            n *= -1; // @note: overflow... -2147483648
	        }
	        if(dsor < 0) {
	            flag *= -1;
	            dsor *= -1;
	        }

	        dfs(n, dsor);

	        return flag * result;
	    }

	    public void dfs(long n, long dsor) {

//	    	if(n <= 0) {
	    	if(n < dsor) { // @note: missed here, end condition is not n
	    		return;
	    	}

	    	int step = 1;

	    	while (n >= (dsor * step)) { // @Note: should be >= , eg: 2/2 = 1

	    		n -= (dsor * step);

	    		result += step;

	    		step *= 2; // acceleration of step size
	    	}

	    	// now start again with no acceleration dsor
	    	dfs(n, dsor);
	    }
	}

	// @note: just convert to long, and solution AC. But code is ugly...
	public class Solution {
	    public int divide(int nn, int ddsor) {

	        // convert to long
	        long n = (long)nn;
	        long dsor = (long)ddsor;

	        if(dsor == 0 || (n == Integer.MIN_VALUE && dsor == -1)) {
	            return Integer.MAX_VALUE;
	        }

	        // save operations
	        if(dsor == 1) {
	            return (int)n;
	        }
	        if(dsor == -1) {
	            return (int)(n * -1);
	        }

	        int flag = 1;
	        if(n < 0) {
	            flag *= -1;
	            n *= -1; // @note: overflow... -2147483648
	        }
	        if(dsor < 0) {
	            flag *= -1;
	            dsor *= -1;
	        }

	        int count = 0;
	        // while(n > 0) {
	        //     n -= dsor;
	        //     count++;
	        // }

	        // moving faster than above while
	        while(n > 0 && n >= dsor) { // while(n > 0) { @note: I missed case: 1/2
	            int shift = 0; // bit shift

	            /* @note: below bit operation causes issue.
	                        2147483647/1
	                        last loop, shift=31, dsor=1
	                        should not enter below while, but when divisor is 1 or 2 or 4, etc:

	                        1<<31=(-2147483648)
	                        2<<30=(-2147483648)
	                        4<<29=(-2147483648)

	                        so, originally I was using "(dsor << shift)" as probe to see if over divident
	                        then I change it to be an int, and add extra overflow check
	            */

	            // while((dsor << shift) <= n) {
	            while((dsor << shift) <= n) { //@note: <n is non-stop loop, should be <=n. eg. 1/1
	                n -= dsor << shift;
	                count += 1 << shift;

	                // check bit overflow
	                if((Integer.MAX_VALUE >> 1) <= (dsor << shift)) {
	                    break;
	                }

	                shift++;
	            }
	        }

	        long result = count * flag;
	        if(result > Integer.MAX_VALUE) {
	            return Integer.MAX_VALUE;
	        } else if(result < Integer.MIN_VALUE) {
	            return Integer.MIN_VALUE;
	        } else {
	            return (int)result;
	        }

	    }
	}


	public class Solution_over_time_limit {
	    public int divide(int n, int dsor) {
	        if(dsor == 0 || (n == Integer.MIN_VALUE && dsor == -1)) {
	            return Integer.MAX_VALUE;
	        }

	        int flag = 1;
	        if(n < 0) {
	            flag *= -1;
	            n *= -1;
	        }
	        if(dsor < 0) {
	            flag *= -1;
	            dsor *= -1;
	        }

	        int count = 0;
	        while(n > 0) {
	            n -= dsor;
	            count++;
	        }

	        return count * flag;
	    }
	}

}
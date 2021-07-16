// SIEVE OF ERATOSTHENES

import java.util.Arrays;

public class Count_Primes {


    class Solution {
        public int countPrimes(int n) {
            int res = 0;
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);

            for (int i = 2; i < n; ++i) {
                if (!isPrime[i]) {
                    continue;
                }
                ++res;
                for (int j = 2; i * j < n; ++j) {
                    isPrime[i * j] = false;
                }
            }
            return res;
        }
    }
}
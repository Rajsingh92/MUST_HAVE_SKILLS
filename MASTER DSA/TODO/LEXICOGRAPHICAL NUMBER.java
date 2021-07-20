/**
Lexicographical Numbers
n = 14

1,10,11,12,13,14,2,3,4,5,6,7,8,9
*/ 

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 1; i <= 9; i++) {
            printLexicographical(n, i);
        }
    }

    public static void printLexicographical(int n, int curr) {
        if (curr > n) {
            return;
        }

        System.out.println(curr);
        for (int i = 0; i <= 9; i++) {
            printLexicographical(n, curr * 10 + i);
        }

    }
}
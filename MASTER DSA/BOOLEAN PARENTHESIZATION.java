/**
Boolean Parenthesization

Given a boolean expression with following symbols.

Symbols
    'T' ---> true 
    'F' ---> false 
And following operators filled between symbols

Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR 
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

Let the input be in form of two arrays one contains the symbols (T and F) in order and other contains operators (&, | and ^}

Example
Example 1:

Input： ['T', 'F', 'T']，['^', '&']
Output：2
Explanation：
The given expression is "T ^ F & T", it evaluates true, in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

 */

class Solution {
    public int countParenth(char[] symb, char[] oper) {
        int n = symb.length;
        int[][] dpt = new int[n][n]; // true count
        int[][] dpf = new int[n][n]; // false count

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    char ch = symb[i];
                    if (ch == 'T') {
                        dpt[i][j] = 1;
                        dpf[i][j] = 0;
                    } else {
                        dpt[i][j] = 0;
                        dpf[i][j] = 1;
                    }
                } else {
                    for (int k = i; k < j; k++) {
                        char op = oper[k];
                        int ltc = dpt[i][k];
                        int rtc = dpt[k + 1][j];
                        int lfc = dpf[i][k];
                        int rfc = dpf[k + 1][j];

                        if (op == '&') {
                            dpt[i][j] += ltc * rtc;
                            dpf[i][j] += ltc * rfc + lfc * rtc + lfc * rfc;
                        } else if (op == '|') {
                            dpt[i][j] += ltc * rtc + ltc * rfc + lfc * rtc;
                            dpf[i][j] += lfc * rfc;
                        } else {
                            dpt[i][j] += ltc * rfc + lfc * rtc;
                            dpf[i][j] += lfc * rfc + ltc * rtc;
                        }
                    }
                }
            }
        }

        return dpt[0][n - 1];
    }
}


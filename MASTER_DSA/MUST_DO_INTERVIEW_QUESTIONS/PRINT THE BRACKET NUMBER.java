// print the bracket number
class GFG {

    static void printBracketNumber(String exp, int n) {

        int left_bnum = 1;
        Stack<Integer> right_bnum = new Stack<Integer>();

        for (int i = 0; i < n; i++) {

            if (exp.charAt(i) == '(') {
                System.out.print(left_bnum + " ");
                right_bnum.push(left_bnum);
                left_bnum++;
            } else if (exp.charAt(i) == ')') {
                System.out.print(right_bnum.peek() + " ");
                right_bnum.pop();
            }
        }
    }

}
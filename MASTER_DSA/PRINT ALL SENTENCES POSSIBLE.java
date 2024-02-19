/**
Recursively print all sentences that can be formed from list of word lists

Given a list of word lists How to print all sentences possible taking one word from a list at a time via recursion? 
Example: 

Input: {{"you", "we"},
        {"have", "are"},
        {"sleep", "eat", "drink"}}

Output:
  you have sleep
  you have eat
  you have drink
  you are sleep
  you are eat
  you are drink
  we have sleep
  we have eat
  we have drink
  we are sleep
  we are eat
  we are drink 
 */


class GFG {

    public static void helper(String[][] arr, int row, String asf) {
        if (row == arr.length) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < arr[row].length; i++) {
            String str = arr[row][i];
            if (str.equals("") == false)
                helper(arr, row + 1, asf + " " + str);
        }
    }

    public static void main(String[] args) {
        String[][] arr = { { "you", "we", "" }, { "have", "are", "" }, { "sleep", "eat", "drink" } };
        helper(arr, 0, "");
    }
}



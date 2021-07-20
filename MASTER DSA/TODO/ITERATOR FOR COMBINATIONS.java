/**
Iterator for Combination

Design the CombinationIterator class:

CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
next() Returns the next combination of length combinationLength in lexicographical order.
hasNext() Returns true if and only if there exists a next combination.
 

Example 1:

Input
["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[["abc", 2], [], [], [], [], [], []]
Output
[null, "ab", true, "ac", true, "bc", false]

Explanation
CombinationIterator itr = new CombinationIterator("abc", 2);
itr.next();    // return "ab"
itr.hasNext(); // return True
itr.next();    // return "ac"
itr.hasNext(); // return True
itr.next();    // return "bc"
itr.hasNext(); // return False
 */

class CombinationIterator {

    LinkedList<String> queue;

    public CombinationIterator(String characters, int combinationLength) {
        queue = new LinkedList<>();
        generate(characters, 0, "", combinationLength);
    }

    public void generate(String characters, int vidx, String asf, int n) {
        if (n == 0) {
            queue.addLast(asf);
            System.out.println(asf);
            return;
        }
        if (vidx >= characters.length())
            return;

        char ch = characters.charAt(vidx);
        generate(characters, vidx + 1, asf + ch, n - 1);
        generate(characters, vidx + 1, asf, n);
    }

    public String next() {
        return queue.removeFirst();
    }

    public boolean hasNext() {
        return queue.size() > 0;
    }
}


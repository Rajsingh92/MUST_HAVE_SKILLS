/**
Rabbits in Forest

There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.

Given the array answers, return the minimum number of rabbits that could be in the forest.

 

Example 1:

Input: answers = [1,1,2]
Output: 5
 */

import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        int minRabbits = 0;
        Arrays.sort(answers);
        int length = answers.length;
        int startIndex = -1;
        for (int i = 0; i < length; i++) {
            if (answers[i] == 0)
                minRabbits++;
            else {
                startIndex = i;
                break;
            }
        }
        if (startIndex < 0)
            return minRabbits;
        int prevAnswer = -1;
        int count = 0;
        for (int i = startIndex; i < length; i++) {
            int answer = answers[i];
            if (prevAnswer < 0)
                count = 1;
            else if (answer == prevAnswer)
                count++;
            else {
                int prevRabbits = minRabbitsPossible(prevAnswer, count);
                minRabbits += prevRabbits;
                count = 1;
            }
            prevAnswer = answer;
        }
        int prevRabbits = minRabbitsPossible(prevAnswer, count);
        minRabbits += prevRabbits;
        return minRabbits;
    }

    public int minRabbitsPossible(int answer, int count) {
        int groupSize = answer + 1;
        int groupsCount = (int) Math.ceil(1.0 * count / groupSize);
        return groupSize * groupsCount;
    }
}

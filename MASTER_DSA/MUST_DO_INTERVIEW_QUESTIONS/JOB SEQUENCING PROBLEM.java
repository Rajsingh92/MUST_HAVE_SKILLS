// job sequencing problem

public class Solution {
    static class Job implements Comparable<Job> {
        char JobID;
        int deadline;
        int Profit;

        public Job(char JobID, int deadline, int profit) {
            this.JobID = JobID;
            this.deadline = deadline;
            this.Profit = profit;
        }

        @Override
        public int compareTo(Job o) {
            return o.Profit - this.Profit;
        }
    }

    public static void solve(Job[] jobs) {
        Arrays.sort(jobs);

        Character[] result = new Character[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            if (result[jobs[i].deadline - 1] == null) {
                result[jobs[i].deadline - 1] = jobs[i].JobID;
            } else {
                int index = jobs[i].deadline - 1;
                while (index >= 0) {
                    if (result[index] == null) {
                        result[index] = jobs[i].JobID;
                        break;
                    }
                    index--;
                }
            }
        }
    }
}

// Job Sequencing Using Disjoint Set Union

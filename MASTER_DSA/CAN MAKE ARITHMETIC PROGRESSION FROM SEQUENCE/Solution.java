class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int a1 = Integer.MAX_VALUE;
        int an = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            a1 = Math.min(a1, arr[i]);
            an = Math.max(an, arr[i]);
            set.add(arr[i]);
        }

        int d = (an - a1) / (arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            int T = a1 + i * d;

            if (set.contains(T) == false) {
                return false;
            }
        }

        return true;
    }
}


class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] freq = {0, 0, 0};

        for (int s : stones){
            freq[s % 3]++;
        }

        if ((freq[0] & 1) == 0){
            return Math.min(freq[1], freq[2]) > 0;
        }

        return Math.abs(freq[1] - freq[2]) > 2;
    }
}
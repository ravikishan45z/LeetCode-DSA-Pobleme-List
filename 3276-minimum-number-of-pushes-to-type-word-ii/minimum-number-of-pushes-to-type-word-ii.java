class Solution {
    public int minimumPushes(String word) {
        int[] table = new int[26];

        for(char ch : word.toCharArray()){
            table[ch - 'a']++;
        }

        int minPushing = 0;

        Arrays.sort(table);

        for(int i = 25, pushCnt = 0; i >= 0; i--){
            int curr = 25 - i;

            if(curr % 8 == 0)
                pushCnt++;

            minPushing += table[i] * pushCnt;
        }

        return minPushing;
    }
}
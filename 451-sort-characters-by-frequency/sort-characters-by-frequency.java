class pair implements Comparable<pair>{
    char ch;
    int freq;
    pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }

    public int compareTo(pair p){
        // Max Heap
        return Integer.compare(p.freq, this.freq);
    }
}

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(char ch : map.keySet()){
            pq.add(new pair(ch, map.get(ch)));
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            pair top = pq.remove();

            for(int i = 0; i<top.freq; i++){
                sb.append(top.ch);
            }
        }

        return sb.toString();
    }
}
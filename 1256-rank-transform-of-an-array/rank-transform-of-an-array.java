class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = Arrays.stream(arr).distinct().sorted().toArray();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<temp.length; i++){
            map.put(temp[i], i+1);
        }
        for(int i = 0; i<arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
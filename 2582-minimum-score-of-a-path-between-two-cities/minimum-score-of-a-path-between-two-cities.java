class Solution {
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        ArrayList<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            graph[road[0]].add(new int[] { road[1], road[2] });
            graph[road[1]].add(new int[] { road[0], road[2] });
        }

        boolean[] vis = new boolean[n + 1];
        dfs(1, graph, vis);

        return ans;
    }


    private void dfs(int node, ArrayList<int[]>[] graph, boolean[] vis) {
        vis[node] = true;

        for (int[] nei : graph[node]) {
            ans = Math.min(ans, nei[1]);

            if (!vis[nei[0]]) {
                dfs(nei[0], graph, vis);
            }
        }
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
      List<List<Integer>> adj = createAdj(n, edges);

      int ans = 0;
      boolean[] visited = new boolean[n];

      for(int i=0; i<n; i++){
        if(!visited[i]) {
            dfs(i, adj, visited);
            ans++;
        }
      }

      return ans;
    }

    private List<List<Integer>> createAdj(int n, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited){
        visited[node] = true;

        for(int curr : adj.get(node)){
            if(!visited[curr]) dfs(curr, adj, visited);
        }
    }
}

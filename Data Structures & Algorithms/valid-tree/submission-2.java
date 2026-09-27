class Solution {
    public boolean validTree(int n, int[][] edges) {
     boolean[] visited = new boolean[n];

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

       
        if(!dfs(adj, 0, visited, -1)) return false;
        for(int i=0; i<n; i++){
            if(!visited[i]) return false;
        }

       return true;
    }

    private boolean dfs(List<List<Integer>> adj, int curr, boolean[] visited, int parent){
        visited[curr] = true;

        for(int node : adj.get(curr)){
           if(visited[node] && node != parent) return false;
           else if(visited[node] && node == parent) continue;
           dfs(adj, node, visited, curr); 
        }
       return true; 
    }
}

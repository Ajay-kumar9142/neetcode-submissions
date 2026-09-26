class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        int[][] visited1 = new int[n][m];
        int[][] visited2 = new int[n][m];

        for(int i=0; i<n; i++){
            dfs(heights, visited1, i, 0, n, m);
            dfs(heights, visited2, i, m-1, n, m);
        }

        for(int i=0; i<m; i++){
            dfs(heights, visited1, 0, i, n, m);
            dfs(heights, visited2, n-1, i, n, m);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited1[i][j] == 1 && visited2[i][j] == 1) {
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, int[][] visited, int row, int col, int n, int m){
        if(!isValid(row, col, heights, n, m, visited)) return;

        visited[row][col] = 1;

        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, -1, 1};

        for(int i=0; i<4; i++){
            int xx = row + x[i];
            int yy = col + y[i];

            if(isValid(xx, yy, heights, n, m, visited) && heights[row][col] <= heights[xx][yy]){
                dfs(heights, visited, xx, yy, n, m);
            }
        }
    }

    private boolean isValid(int row, int col, int[][] heights, int n, int m, int[][] visited){
        if(row < 0 || row >= n || col <0 || col >= m || (visited[row][col] == 1)) return false;
        return true;
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> memo = new HashMap<>();
        return helper(m, n, 0, 0, memo);
    }

    private int helper(int m, int n, int row, int col, HashMap<String, Integer> memo){
        if(row >= m || col >= n) return 0;
        if(row == m-1 && col == n-1) return 1;

        String key = row + "-" + col;

        if(memo.containsKey(key)) return memo.get(key);

        int right = helper(m, n, row, col+1, memo);
        int down = helper(m, n, row+1, col, memo);

        memo.put(key, right+down);
        return memo.get(key);
    }
}

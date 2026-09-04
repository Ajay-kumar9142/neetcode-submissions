class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];

        for(int i=0; i<n; i++){
            memo[i] = -1;
        }
        return helper(n, 0, memo);
    }

    private int helper(int n, int curr, int[] memo){
        if(curr == n) return 1;
        if(curr > n) return 0;

        if(memo[curr] != -1) return memo[curr]; 

        int oneStep = helper(n, curr+1, memo);
        int twoStep = helper(n, curr+2, memo);
        
        memo[curr] = oneStep + twoStep;

        return memo[curr];

    }
}

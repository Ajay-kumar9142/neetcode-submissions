class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i = 0; i<=n; i++){
            ans[i] += count(i);
        }
        return ans;
    }

    private int count(int i){
        int ans = 0;
        while(i != 0){
            i = i & i-1;
            ans++;
        }
        return ans;
    }
}

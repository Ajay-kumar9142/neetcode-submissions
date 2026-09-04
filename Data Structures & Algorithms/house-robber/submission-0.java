class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length+1];

        for(int i=0; i<nums.length; i++){
            memo[i] = -1;
        }

        return maxAmount(nums, 0, memo);
    }

    private int maxAmount(int[] nums, int idx, int[] memo){
        if(idx >= nums.length) return 0;

        if(memo[idx] != -1) return memo[idx];

        int robHouse = nums[idx] + maxAmount(nums, idx+2, memo);
        int skipHouse = maxAmount(nums, idx+1, memo);

        memo[idx] = Math.max(robHouse, skipHouse);

        return memo[idx];
    }
}

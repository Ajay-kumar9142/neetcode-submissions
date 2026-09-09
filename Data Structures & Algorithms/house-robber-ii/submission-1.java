class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] memo1 = new int[nums.length+1];
        int[] memo2 = new int[nums.length+1];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        int robFirst = maxRob(nums, 0, nums.length-1, memo1);
        int skipRob = maxRob(nums, 1, nums.length, memo2);
        return Math.max(robFirst, skipRob);
    }

    private int maxRob(int[] nums, int idx, int end, int[] memo){
     if(idx >= end) return 0;

     if(memo[idx] != -1) return memo[idx];

     int rob = nums[idx] + maxRob(nums, idx+2, end, memo);
     int skipRob = maxRob(nums, idx+1, end, memo);

     memo[idx] = Math.max(rob, skipRob);
     return memo[idx];
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> m = new HashMap<>();
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            m.put(nums[i], true);
        }

        for(int i=0; i<nums.length; i++){
            if(m.containsKey(nums[i]-1)) continue;
            else {
                int count = 0;
                int k = nums[i];
                while(m.containsKey(k)){
                    count++;
                    k++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}

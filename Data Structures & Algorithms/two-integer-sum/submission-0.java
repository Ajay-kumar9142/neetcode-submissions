class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();

        // int[] ans = new int[2];
         
        for(int i=0; i<nums.length; i++){
            if(m.containsKey(target - nums[i])){
             int j = m.get(target - nums[i]);
             return i<j ? new int[]{i, j} : new int[]{j, i};
            } 
            m.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}

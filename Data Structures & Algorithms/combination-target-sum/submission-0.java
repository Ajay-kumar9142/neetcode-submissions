class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        sum(nums, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void sum(int[] nums, int target, int idx, List<Integer> temp, List<List<Integer>> ans){
        if(target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(idx >= nums.length) return;

        if(target >= nums[idx]){
            temp.add(nums[idx]);
            sum(nums, target-nums[idx], idx, temp, ans);
            temp.remove(temp.size()-1);
        }
        sum(nums, target, idx+1, temp, ans);
    }
}

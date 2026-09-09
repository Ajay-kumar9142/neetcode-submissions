class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for(int i=0; i<intervals.length; i++){
            int[] temp = ans.get(ans.size()-1);
            if(temp[1] >= intervals[i][0]){
                temp[0] = Math.min(temp[0], intervals[i][0]);
                temp[1] = Math.max(temp[1], intervals[i][1]);
                ans.remove(ans.size()-1);
                ans.add(temp);
            } else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

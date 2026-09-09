class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));  //sorted by start time

        int res = 0;
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= end){
                end = intervals[i][1];
            } else {
                res++;
                end = Math.min(end, intervals[i][1]);
            }
        }
        return res;
    }
}

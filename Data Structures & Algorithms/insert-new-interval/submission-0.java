class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // List<int[]> list = new ArrayList<>();

        // for(int[] interval : intervals){
            
        //     if(newInterval == null) {
        //         list.add(interval);
        //     } else {
        //         if(interval[1] < newInterval[0]){
        //             list.add(interval);
        //         } else if(interval[1] >= newInterval[0] && interval[0] <= newInterval[0]){
        //             newInterval[0] = Math.min(newInterval[0], interval[0]);
        //             newInterval[1] = Math.max(newInterval[1], interval[1]);
        //             System.out.println(newInterval[0] + " " + newInterval[1]);
        //         } else if(interval[0] > newInterval[1]){
        //             list.add(newInterval);
        //             list.add(interval);
        //             newInterval = null;
        //         }
        //     }
        // }

        // if(newInterval != null) list.add(newInterval);

        //     // int[][] ans = new int[list.size()][2];
        //     // for(int i=0; i<list.size(); i++){
        //     //     ans[i]  = (list.get(i));
        //     // }
        //     return list.toArray(new int[list.size()][]);
        // }

        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}

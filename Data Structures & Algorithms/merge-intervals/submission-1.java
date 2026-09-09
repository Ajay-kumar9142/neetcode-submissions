class Solution {
    public int[][] merge(int[][] intervals) {
        Map<Integer, Integer> m = new TreeMap<>();
        List<int[]> ans = new ArrayList<>();

        for(int i=0; i<intervals.length; i++){
            m.put(intervals[i][0], m.getOrDefault(intervals[i][0], 0)+1);
            m.put(intervals[i][1], m.getOrDefault(intervals[i][1], 0)-1);
        }

        int active = 0;
        int[] interval = new int[2];

        for(int point : m.keySet()){
            if(active == 0) interval[0] = point;
            active += m.get(point);
            if(active == 0){
                interval[1] = point;
                ans.add(new int[]{interval[0], interval[1]});

            }
        }
        return ans.toArray(new int[ans.size()-1][]);
    }
}

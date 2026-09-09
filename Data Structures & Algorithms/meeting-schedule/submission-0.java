/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
       Map<Integer, Integer> m = new TreeMap<>();

       for(int i=0; i<intervals.size(); i++){
        Interval curr = intervals.get(i);
        m.put(curr.start, m.getOrDefault(curr.start, 0)+1);
        m.put(curr.end, m.getOrDefault(curr.end, 0)-1);
       }

       int overlap = 0;
       for(int key : m.keySet()){
         overlap += m.get(key);
         if(overlap > 1) return false;
       }
       return true;
    }
}

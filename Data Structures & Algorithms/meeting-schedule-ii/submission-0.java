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
    public int minMeetingRooms(List<Interval> intervals) {
     Map<Integer, Integer> m = new TreeMap<>();

     for(Interval it : intervals){
        m.put(it.start, m.getOrDefault(it.start, 0)+1);
        m.put(it.end, m.getOrDefault(it.end, 0)-1);
     }

     int ans = 0;
     int rooms = 0;
     for(int key : m.keySet()){
        rooms += m.get(key);
        ans = Math.max(ans, rooms);
     }
     return ans;
    }
}

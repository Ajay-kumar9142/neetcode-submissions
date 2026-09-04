class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> m = new HashMap<>();
        int maxFreq = 0;
        int ans = 0;

        int i=0, j=0;
        while(j<s.length()){
            m.put(s.charAt(j), m.getOrDefault(s.charAt(j), 0)+1);
            maxFreq = Math.max(maxFreq, m.get(s.charAt(j)));

            while(j-i+1 - maxFreq > k){
                m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0)-1);
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;

        }
        return ans;
    }
}

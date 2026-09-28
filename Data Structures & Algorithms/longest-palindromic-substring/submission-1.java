class Solution {
    public String longestPalindrome(String s) {
        int[] p = manacher(s);
        int resLen = 0, centerIdx = 0;

        for(int i=0; i<p.length; i++){
            if(p[i] > resLen) {
                resLen = p[i];
                centerIdx = i;
            }
        }
        int resIdx = (centerIdx - resLen)/2;
        return s.substring(resIdx, resIdx + resLen);
    }

    private int[] manacher(String s){
        StringBuilder str = new StringBuilder("#");
        
        for(char c : s.toCharArray()) {
            str.append(c).append("#");
        }

        int n = str.length();
        int[] p = new int[n];

        int l = 0, r = 0;

        for(int i=0; i<n; i++){
            p[i] = (i < r) ? Math.min(r-i, p[l + (r - i)]) : 0;

            while(i + p[i] + 1 <n && i-p[i]-1 >=0 && str.charAt(i + p[i] +1) == str.charAt(i -p[i]-1)){
                p[i]++;
            }

            if(i + p[i] > r){
                l = i - p[i];
                r = i + p[i];
            }
        }

        return p;
    }
}

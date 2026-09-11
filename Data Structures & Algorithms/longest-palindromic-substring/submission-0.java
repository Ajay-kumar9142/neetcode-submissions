class Solution {
    public String longestPalindrome(String s) {
      int length = 0;
      int startIdx = 0;
       
       //odd length
       for(int i=0; i<s.length(); i++){
        int l=i, r=i;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if(length < (r-l+1)){
                length = r-l+1;
                startIdx = l;
            }
            l--;
            r++;
        }
       }

       //even length
       for(int i=0; i<s.length()-1; i++){
        int l=i, r=i+1;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if(length < (r-l+1)){
                length = r-l+1;
                startIdx = l;
            }
            l--;
            r++;
        }
       }

       return s.substring(startIdx, startIdx+length);
    }
}

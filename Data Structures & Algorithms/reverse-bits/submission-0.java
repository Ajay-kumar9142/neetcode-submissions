class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int i = 0;
        
        while(i < 32) {
          //   ans = ans << 1;
          // if((n & 1) == 1) {
          //   ans = (ans | 1);
          // }
          // i++;
          int bit = (n >> i) & 1;
          ans = ans | (bit << (31-i));
          i++;
        }
        return ans;
    }
}

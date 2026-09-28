class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0) return 0;
        Map<String, Integer> memo = new HashMap<>();

        return helper(text1, text2, 0, 0, memo);
    }

    private int helper(String text1, String text2, int curr1, int curr2, Map<String, Integer> memo){
        if(curr1 >= text1.length() || curr2 >= text2.length()) return 0;

        String key = curr1 + "-" + curr2;
        if(memo.containsKey(key)) return memo.get(key);

        int match = 0;
        if(text1.charAt(curr1) == text2.charAt(curr2)){
            match = 1 + helper(text1, text2, curr1+1, curr2+1, memo);
        }

        int move1 = helper(text1, text2, curr1+1, curr2, memo);
        int move2 = helper(text1, text2, curr1, curr2+1, memo);

        memo.put(key, Math.max(match, Math.max(move1, move2)));

        return memo.get(key);
    }
}

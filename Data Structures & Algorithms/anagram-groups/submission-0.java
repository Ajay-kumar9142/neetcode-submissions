class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            m.putIfAbsent(sortedStr, new ArrayList<>());
            m.get(sortedStr).add(s);
        }

        return new ArrayList<>(m.values());
    }
}

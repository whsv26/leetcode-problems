// https://leetcode.com/problems/group-anagrams

void main() {
    assert new Solution().groupAnagrams(new String[]{"abc", "acb", "ac"})
        .equals(List.of(List.of("abc", "acb"), List.of("ac")));
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagrams = new HashMap<String, List<String>>();
        for (var str : strs) {
            var frequencies = new char[26];
            for (int i = 0; i < str.length(); i++) {
                frequencies[str.charAt(i) - 'a']++;
            }
            var key = String.valueOf(frequencies);
            anagrams.computeIfAbsent(key, _ -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }
}
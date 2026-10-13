void main() {
    assert new Solution().findAnagrams("cbaebabacd", "abc").equals(List.of(0, 6));
    assert new Solution().findAnagrams("abab", "ab").equals(List.of(0, 1, 2));
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        var result = new ArrayList<Integer>();

        var targetFrequencies = new int[26];
        for (int i = 0; i < p.length(); i++) {
            targetFrequencies[p.charAt(i) - 'a']++;
        }

        var left = 0;
        var frequencies = new int[26];
        for (int right = 0; right < s.length(); right++) {
            frequencies[s.charAt(right) - 'a']++;

            if ((right - left) == p.length()) {
                frequencies[s.charAt(left++) - 'a']--;
            }

            if (Arrays.equals(frequencies, targetFrequencies)) {
                result.add(left);
            }
        }

        return result;
    }
}


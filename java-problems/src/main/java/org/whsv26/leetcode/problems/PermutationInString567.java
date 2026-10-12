void main() {
    assert new Solution().checkInclusion("ab", "eidbaooo");
    assert !new Solution().checkInclusion("ab", "eidboaoo");
    assert new Solution().checkInclusion("a", "ab");
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        var targetFrequencies = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            targetFrequencies[s1.charAt(i) - 'a']++;
        }

        var frequencies = new int[26];
        var left = 0;

        for (int right = 0; right < s2.length(); right++) {
            frequencies[s2.charAt(right) - 'a']++;

            if (right - left == s1.length()) {
                frequencies[s2.charAt(left++) - 'a']--;
            }

            if (Arrays.equals(frequencies, targetFrequencies)) {
                return true;
            }
        }

        return false;
    }
}
void main() {
    assert 3 == new Solution().lengthOfLongestSubstring("abcabcbb");
    assert 2 == new Solution().lengthOfLongestSubstring("ccbbcc");
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        var lastSeen = new HashMap<Character, Integer>();
        var max = 0;
        var left = 0;

        for (int right = 0; right < s.length(); right++) {
            var ch = s.charAt(right);

            if (lastSeen.containsKey(ch)) {
                left = Math.max(left, lastSeen.get(ch) + 1);
            }

            lastSeen.put(ch, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

class SolutionSlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        var window = new ArrayDeque<Character>();
        var set = new HashSet<Character>();
        var maxWindow = 0;

        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                char pc;
                do {
                    pc = window.poll();
                    set.remove(pc);
                } while (pc != c);
                set.add(c);
            }

            window.offer(c);
            maxWindow = Math.max(maxWindow, window.size());
        }

        return maxWindow;
    }
}
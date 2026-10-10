void main() {
    assert 4 == new Solution().characterReplacement("ABAB", 2);
    assert 4 == new Solution().characterReplacement("AABABBA", 1);
    assert 4 == new Solution().characterReplacement("AAAA", 2);
}

class Solution {
    public int characterReplacement(String s, int k) {
        var frequencies = new int[26];
        var max = 0;
        var maxFreq = 0;
        var left = 0;

        for (int right = 0; right < s.length(); right++) {
            var rightChar = s.charAt(right) - 'A';
            frequencies[rightChar]++;
            maxFreq = Math.max(maxFreq, frequencies[rightChar]);

            if ((right - left + 1) - maxFreq > k) {
                frequencies[s.charAt(left++) - 'A']--;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

class SolutionHashMapToArray {
    public int characterReplacement(String s, int k) {
        var frequencies = new int[26];
        var max = 0;
        var left = 0;

        for (int right = 0; right < s.length(); right++) {
            frequencies[s.charAt(right) - 'A']++;

            int maxFreq = Arrays.stream(frequencies).max().orElse(0);

            while ((right - left + 1) - maxFreq > k) {
                frequencies[s.charAt(left++) - 'A']--;
                maxFreq = Arrays.stream(frequencies).max().orElse(0);
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

class SolutionDequeToDoublePointer {
    public int characterReplacement(String s, int k) {
        var frequencies = new HashMap<Character, Integer>();
        var max = 0;
        var left = 0;

        for (int right = 0; right < s.length(); right++) {
            frequencies.merge(s.charAt(right), 1, Integer::sum);

            int maxFreq = frequencies.values().stream().max(Integer::compareTo).orElse(0);

            while ((right - left + 1) - maxFreq > k) {
                var pc = s.charAt(left++);
                frequencies.merge(pc, -1, Integer::sum);
                maxFreq = frequencies.values().stream().max(Integer::compareTo).orElse(0);
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

class SolutionDeque {
    public int characterReplacement(String s, int k) {
        var window = new ArrayDeque<Character>();
        var frequencies = new HashMap<Character, Integer>();
        var max = 0;

        for (char c : s.toCharArray()) {
            window.offer(c);
            frequencies.merge(c, 1, Integer::sum);

            int maxFreq = frequencies.values().stream().max(Integer::compareTo).orElse(0);

            while (window.size() - maxFreq > k) {
                var pc = window.poll();
                frequencies.merge(pc, -1, Integer::sum);
                maxFreq = frequencies.values().stream().max(Integer::compareTo).orElse(0);
            }

            max = Math.max(max, window.size());
        }

        return max;
    }
}
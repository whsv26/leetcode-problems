import java.util.HashMap;

void main() {
    assert (11 == longestPalindrome("aaabbbccddee"));
    assert (11 == longestPalindrome("aaabbccddee"));
    assert (7 == longestPalindrome("xqaaaddee"));
    assert (1 == longestPalindrome("abcde"));
}

int longestPalindrome(String s) {
    var occurByChar = new HashMap<Integer, Integer>();
    s.chars().forEach(c -> occurByChar.merge(c, 1, Integer::sum));

    var occurSum = occurByChar.values().stream()
        .mapToInt(n -> n % 2 == 0 ? n : n - 1)
        .sum();

    return occurSum < s.length() ? occurSum + 1 : occurSum;
}
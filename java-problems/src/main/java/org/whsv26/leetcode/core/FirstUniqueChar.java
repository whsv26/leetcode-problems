void main() {
    assert firstUniqueCharMap("leetcode") == 0;
    assert firstUniqueCharMap("loveleetcode") == 2;
    assert firstUniqueCharMap("aabb") == -1;

    assert firstUniqueCharArray("leetcode") == 0;
    assert firstUniqueCharArray("loveleetcode") == 2;
    assert firstUniqueCharArray("aabb") == -1;
}

int firstUniqueCharMap(String s) {
    var map = new HashMap<Character, Integer>();

    for (int i = 0; i < s.length(); i++) {
        // insert 1, or add 1 to the existing value.
        map.merge(s.charAt(i), 1, Integer::sum);
    }

    for (int i = 0; i < s.length(); i++) {
        if (map.get(s.charAt(i)) == 1) {
            return i;
        }
    }

    return -1;
}

int firstUniqueCharArray(String s) {
    var frequencies = new int[26]; // 26 is alphabet size

    for (int i = 0; i < s.length(); i++) {
        frequencies[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s.length(); i++) {
        if (frequencies[s.charAt(i) - 'a'] == 1) {
            return i;
        }
    }

    return -1;
}
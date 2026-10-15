void main() {
    assert 3 == new Solution().totalFruit(new int[]{1, 2, 1});
    assert 3 == new Solution().totalFruit(new int[]{0, 1, 2, 2});
    assert 4 == new Solution().totalFruit(new int[]{1, 2, 3, 2, 2});
}

class Solution {
    public int totalFruit(int[] fruits) {
        var frequencies = new HashMap<Integer, Integer>();
        var max = 0;

        for (int left = 0, right = 0; right < fruits.length; right++) {
            frequencies.merge(fruits[right], 1, Integer::sum);

            while (frequencies.size() > 2) {
                var fruit = fruits[left++];
                var count = frequencies.merge(fruit, -1, Integer::sum);
                if (count == 0) {
                    frequencies.remove(fruit);
                }
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

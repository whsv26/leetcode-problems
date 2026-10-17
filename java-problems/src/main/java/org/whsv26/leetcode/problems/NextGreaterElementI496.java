void main() {
    assert Arrays.equals(
        new Solution().nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}),
        new int[]{-1,3,-1}
    );
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var map = new HashMap<Integer, Integer>();
        var stack = new ArrayDeque<Integer>();
        var result = new int[nums1.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                var popped = stack.pop();
                var idx = map.get(popped);
                if (idx != null) {
                    result[idx] = num;
                }
            }
            stack.push(num);
        }

        return result;
    }
}
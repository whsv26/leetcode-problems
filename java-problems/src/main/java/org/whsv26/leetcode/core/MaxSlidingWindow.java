void main() {
    assert Arrays.equals(
        maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3),
        new int[]{3, 3, 5, 5, 6, 7}
    );
}

int[] maxSlidingWindow(int[] nums, int k) {
    var windowsCount = nums.length - k + 1;
    var result = new int[windowsCount];
    var queue = new ArrayDeque<Integer>();
    var write = 0;

    for (int i = 0; i < nums.length; i++) {

        // This removes indices that are no longer inside the current window.
        while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
            queue.pollFirst();
        }

        // This removes elements that can never become a maximum anymore.
        // If nums[i] is larger than something behind it,
        // that older smaller element is useless because nums[i] will stay in the window longer.
        while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
            queue.pollLast();
        }

        queue.offerLast(i);

        if (i >= k - 1) {
            result[write++] = nums[queue.peekFirst()];
        }
    }

    return result;
}

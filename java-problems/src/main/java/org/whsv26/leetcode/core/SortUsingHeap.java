void main() {
    assert Arrays.equals(sortUsingHeap(new int[]{3, 1, 2, 0}), new int[]{0, 1, 2, 3});
}

int[] sortUsingHeap(int[] nums) {
    var minHeap = new PriorityQueue<Integer>();

    for (int num : nums) {
        minHeap.offer(num);
    }

    var sorted = new int[nums.length];
    var i = 0;

    while (!minHeap.isEmpty()) {
        sorted[i++] = minHeap.poll();
    }

    return sorted;
}
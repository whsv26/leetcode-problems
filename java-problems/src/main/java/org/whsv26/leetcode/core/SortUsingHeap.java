void main() {
    assert Arrays.equals(sortUsingHeapAsc(new int[]{3, 1, 2, 0}), new int[]{0, 1, 2, 3});
    assert Arrays.equals(sortUsingHeapDesc(new int[]{3, 1, 2, 0}), new int[]{3, 2, 1, 0});
}

int[] sortUsingHeapAsc(int[] nums) {
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

int[] sortUsingHeapDesc(int[] nums) {
    var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

    for (int num : nums) {
        maxHeap.offer(num);
    }

    var sorted = new int[nums.length];
    var i = 0;

    while (!maxHeap.isEmpty()) {
        sorted[i++] = maxHeap.poll();
    }

    return sorted;
}
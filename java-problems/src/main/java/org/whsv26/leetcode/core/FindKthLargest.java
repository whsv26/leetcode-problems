void main() {
    assert findKthLargestNaive(new int[]{3, 2, 1, 5, 6, 4}, 2) == 5;
    assert findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2) == 5;
}

int findKthLargest(int[] nums, int k) {
    var heap = new PriorityQueue<Integer>(k);

    for (int num : nums) {
        if (heap.size() < k) {
            heap.offer(num);
        } else if (heap.peek() < num) {
            heap.poll();
            heap.offer(num);
        }
    }

    return heap.peek();
}

int findKthLargestNaive(int[] nums, int k) {
    var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());

    for (int num : nums) {
        heap.offer(num);
    }

    return pollNth(heap, k - 1);
}

<T> T pollNth(Queue<T> queue, int nth) {
    for (int i = 0; i < nth; i++) {
        if (queue.poll() == null) {
            return null;
        }
    }
    return queue.poll();
}
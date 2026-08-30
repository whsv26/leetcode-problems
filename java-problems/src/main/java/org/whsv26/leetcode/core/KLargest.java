void main() {
    assert kLargestNaive(new int[]{7, 2, 10, 4, 8}, 3).equals(List.of(10, 8, 7));
    assert kLargestNaive(new int[]{7, 2, 10, 4, 8}, 2).equals(List.of(10, 8));

    assert kLargest(new int[]{7, 2, 10, 4, 8}, 3).equals(List.of(10, 8, 7));
    assert kLargest(new int[]{7, 2, 10, 4, 8}, 2).equals(List.of(10, 8));
}

List<Integer> kLargest(int[] nums, int k) {
    var heap = new PriorityQueue<Integer>(k);

    for (int num : nums) {
        if (heap.size() < k) {
            heap.offer(num);
        } else if (heap.peek() < num) {
            heap.poll();
            heap.offer(num);
        }
    }

    return pollN(heap, k).reversed();
}

List<Integer> kLargestNaive(int[] nums, int k) {
    var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());

    for (int num : nums) {
        heap.offer(num);
    }

    return pollN(heap, k);
}

<T> List<T> pollN(Queue<T> queue, int n) {
    var result = new ArrayList<T>(n);
    for (int i = 0; i < n && !queue.isEmpty(); i++) {
        result.add(queue.poll());
    }
    return result;
}
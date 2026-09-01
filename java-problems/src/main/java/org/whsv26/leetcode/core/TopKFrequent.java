void main() {
    assert Arrays.equals(
        topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2),
        new int[]{1, 2}
    );
}

int[] topKFrequent(int[] nums, int k) {
    var frequencies = new HashMap<Integer, Integer>();
    var comparator = Map.Entry.<Integer, Integer>comparingByValue();
    var minHeap = new PriorityQueue<>(k, comparator);

    for (int num : nums) {
        frequencies.merge(num, 1, Integer::sum);
    }

    frequencies.forEach((num, frequency) -> {
        if (minHeap.size() < k) {
            minHeap.offer(Map.entry(num, frequency));
        } else if (minHeap.peek().getValue() < frequency) {
            minHeap.poll();
            minHeap.offer(Map.entry(num, frequency));
        }
    });

    var result = new int[k];

    for (int i = k - 1; i >= 0; i--) {
        result[i] = minHeap.poll().getKey();
    }

    return result;
}

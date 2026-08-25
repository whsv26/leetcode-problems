void main() {
    assert process(new int[]{1, 2, 3})
        .equals(List.of(2, 4, 6));
}

List<Integer> process(int[] nums) {
    // ArrayDeque is dynamically resized and doesn't shrink after removals.
    Queue<Integer> queue = new ArrayDeque<>();
    ArrayList<Integer> result = new ArrayList<>();

    for (var num : nums) {
        // Queue.offer() returns false if a capacity-restricted queue is full,
        // while Queue.add() throws IllegalStateException.
        // ArrayDeque is not capacity-restricted and always return true.
        queue.offer(num);
    }

    while (!queue.isEmpty()) {
        // poll() returns null if the queue is empty,
        // while remove() throws NoSuchElementException.
        var num = queue.poll();
        result.add(num * 2);
    }

    return result;
}
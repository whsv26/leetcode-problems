void main() {
    int[] nums = {-2, 4, 0, 7, -1};

    assert Arrays.equals(
        new int[]{4, 7},
        toArray(positiveNumbers(nums))
    );

    assert Arrays.equals(
        new int[]{4, 7},
        toArray(positiveNumbers1(nums))
    );
}

List<Integer> positiveNumbers(int[] nums) {
    return Arrays.stream(nums)
        .filter(num -> num > 0)
        .boxed()
        .toList();
}

List<Integer> positiveNumbers1(int[] nums) {
    var positiveNums = new ArrayList<Integer>();
    for (var num : nums) {
        if (num > 0) {
            positiveNums.add(num);
        }
    }
    return positiveNums;
}

int[] toArray(List<Integer> nums) {
    return nums.stream()
        .mapToInt(Integer::intValue)
        .toArray();
}
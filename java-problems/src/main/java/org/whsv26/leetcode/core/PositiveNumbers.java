void main() {
    int[] nums = {-2, 4, 0, 7, -1};
    int[] positiveNums = positiveNumbers(nums)
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();

    assert Arrays.equals(positiveNums, new int[]{4, 7});
}

List<Integer> positiveNumbers(int[] nums) {
    var result = new ArrayList<Integer>();
    for (var num : nums) {
        if (num > 0) {
            result.add(num);
        }
    }
    return result;
}
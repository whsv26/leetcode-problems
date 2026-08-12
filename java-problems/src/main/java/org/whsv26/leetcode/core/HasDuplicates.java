void main() {
    assert !hasDuplicates(new int[]{1, 2, 3});
    assert hasDuplicates(new int[]{1, 2, 3, 2});
}

boolean hasDuplicates(int[] nums) {
    var seen = new HashSet<Integer>();
    for (var num : nums) {
        if (seen.contains(num)) {
            return true;
        }
        seen.add(num);
    }
    return false;
}
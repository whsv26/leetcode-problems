void main() {
    assert containsDuplicate(new int[]{1,3,2,1,0});
    assert !containsDuplicate(new int[]{1,3,2,4,0});
    assert !containsDuplicate(new int[]{1});
    assert !containsDuplicate(new int[]{});
}

boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] == nums[i + 1]) {
            return true;
        }
    }

    return false;
}

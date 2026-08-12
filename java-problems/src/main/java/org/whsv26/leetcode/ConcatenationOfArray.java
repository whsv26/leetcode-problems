import java.util.Arrays;

void main() {
    assert (Arrays.equals(
        new int[]{1, 2, 1, 1, 2, 1},
        getConcatenation(new int[]{1, 2, 1})
    ));

    assert (Arrays.equals(
        new int[]{1, 2, 1, 1, 2, 1},
        getConcatenationSlow(new int[]{1, 2, 1})
    ));
}

int[] getConcatenation(int[] nums) {
    var res = new int[nums.length * 2];
    System.arraycopy(nums, 0, res, 0, nums.length);
    System.arraycopy(nums, 0, res, nums.length, nums.length);
    return res;
}

int[] getConcatenationSlow(int[] nums) {
    var res = new int[nums.length * 2];

    for (int i = 0; i < nums.length * 2; i++) {
        res[i] = nums[i % nums.length];
    }

    return res;
}

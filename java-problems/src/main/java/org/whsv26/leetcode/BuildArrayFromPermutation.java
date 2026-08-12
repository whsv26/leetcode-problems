import java.util.Arrays;

void main() {
    assert (Arrays.equals(
        new int[]{0,1,2,4,5,3},
        buildArray(new int[]{0,2,1,5,3,4})
    ));

    assert (Arrays.equals(
        new int[]{0,1,2,4,5,3},
        buildArrayExtraSpace(new int[]{0,2,1,5,3,4})
    ));
}

// 3 + 1000 * (5 % 1000) = 5003
// 5003 % 1000 = 3 (oldValue)
// 5003 / 1000 = 5 (newValue)
int[] buildArray(int[] nums) {
    var n = nums.length;

    for (int i = 0; i < nums.length; i++) {
        var newValue = nums[nums[i]] % n;
        var oldValue = nums[i];
        nums[i] = oldValue + n * newValue;
    }

    for (int i = 0; i < nums.length; i++) {
        nums[i] = nums[i] / n;
    }

    return nums;
}

int[] buildArrayExtraSpace(int[] nums) {
    var res = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
        res[i] = nums[nums[i]];
    }

    return res;
}

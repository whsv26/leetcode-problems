// https://leetcode.com/problems/longest-consecutive-sequence

void main() {
    assert Arrays.equals(
        new Solution().productExceptSelf(new int[]{1, 2, 3, 4}),
        new int[]{24,12,8,6}
    );

    assert Arrays.equals(
        new DumbSolution().productExceptSelf(new int[]{1, 2, 3, 4}),
        new int[]{24,12,8,6}
    );
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}

class DumbSolution {
    public int[] productExceptSelf(int[] nums) {
        var running = new long[nums.length];
        running[0] = pack(1, 1);
        running[nums.length - 1] = pack(1, 1);

        var result = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            var j = nums.length - i - 1;

            running[i + 1] = pack(
                unpackLow(running[i]) * nums[i],
                unpackHigh(running[i + 1])
            );

            running[j - 1] = pack(
                unpackLow(running[j - 1]),
                unpackHigh(running[j]) * nums[j]
            );
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = unpackLow(running[i]) * unpackHigh(running[i]);
        }

        return result;
    }

    private static long pack(int low, int high) {
        return ((long) high << 32) | (low & 0xFFFFFFFFL);
    }

    private static int unpackLow(long packed) {
        return (int) packed;
    }

    private static int unpackHigh(long packed) {
        return (int) (packed >> 32);
    }
}
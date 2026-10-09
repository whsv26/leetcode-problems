void main() {
    var in1 = new int[]{2, 0, 2, 1, 1, 0};
    new Solution().sortColors(in1);
    assert Arrays.equals(in1, new int[]{0, 0, 1, 1, 2, 2});

    var in2 = new int[]{1, 0};
    new Solution().sortColors(in2);
    assert Arrays.equals(in2, new int[]{0, 1});

    var in3 = new int[]{2, 1};
    new Solution().sortColors(in3);
    assert Arrays.equals(in3, new int[]{1, 2});

    var in4 = new int[]{1, 2, 0};
    new Solution().sortColors(in4);
    assert Arrays.equals(in4, new int[]{0, 1, 2});
}

class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, hight = nums.length - 1;
        while (mid <= hight) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, hight);
                hight--;
            } else {
                mid++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        var tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
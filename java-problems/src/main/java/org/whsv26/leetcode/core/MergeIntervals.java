void main() {
    int[][] res = mergeIntervals(new int[][]{{8, 10}, {1, 3}, {2, 6}, {15, 18}});
    assert Arrays.deepEquals(
        res,
        new int[][]{{1, 6}, {8, 10}, {15, 18}}
    );
}

int[][] mergeIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

    var write = 0;

    for (int read = 1; read < intervals.length; read++) {
        if (intervals[write][1] >= intervals[read][0]) {
            intervals[write] = extend(intervals[write], intervals[read]);
        } else {
            intervals[++write] = intervals[read];
        }
    }

    return Arrays.copyOf(intervals, write + 1);
}

int[] extend(int[] a, int[] b) {
    return new int[]{a[0], Math.max(a[1], b[1])};
}

void main() {
    var spanner = new StockSpanner();
    var result = new ArrayList<Integer>();
    result.add(spanner.next(100));
    result.add(spanner.next(80));
    result.add(spanner.next(60));
    result.add(spanner.next(70));
    result.add(spanner.next(60));
    result.add(spanner.next(75));
    result.add(spanner.next(85));

    assert result.equals(List.of(1, 1, 1, 2, 1, 4, 6));
}

class StockSpanner {

    private ArrayDeque<int[]> stack;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        var span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }
}

class StockSpannerIndex {

    private ArrayDeque<int[]> stack;
    private int right;

    public StockSpannerIndex() {
        this.stack = new ArrayDeque<>();
        this.right = 0;
    }

    public int next(int price) {

        while (!stack.isEmpty() && stack.peek()[1] <= price) {
            stack.pop();
        }

        var left = stack.peek() != null ? stack.peek()[0] : -1;

        stack.push(new int[]{right, price});

        return (right++) - left;
    }
}

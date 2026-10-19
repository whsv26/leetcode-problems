void main() {
    assert 3 == new Solution().carFleet(
        12,
        new int[]{10,8,0,5,3},
        new int[]{2,4,1,1,3}
    );
    assert 1 == new Solution().carFleet(
        100,
        new int[]{0,2,4},
        new int[]{4,2,1}
    );
    assert 2 == new Solution().carFleet(
        10,
        new int[]{6,8},
        new int[]{3,2}
    );
    assert 1 == new Solution().carFleet(
        10,
        new int[]{0,4,2},
        new int[]{2,1,3}
    );


}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        var cars = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, Comparator.comparingInt(car -> car[0]));

        var maxArrivalTime = 0.0;
        var count = 0;

        for (int i = position.length - 1; i >= 0; i--) {
            var arrivalTime = (double) (target - cars[i][0]) / cars[i][1];

            if (arrivalTime > maxArrivalTime) {
                count++;
                maxArrivalTime = arrivalTime;
            }

        }

        return count;
    }
}

class SolutionStack {
    public int carFleet(int target, int[] position, int[] speed) {
        var stack = new ArrayDeque<Double>();
        var cars = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, Comparator.comparingInt(car -> car[0]));

        for (int i = 0; i < position.length; i++) {
            var arrivalTime = (double) (target - cars[i][0]) / cars[i][1];

            while (!stack.isEmpty() && stack.peek() <= arrivalTime) {
                stack.pop();
            }

            stack.push(arrivalTime);
        }

        return stack.size();
    }
}
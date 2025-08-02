package golang_problems

import (
	"fmt"
	"testing"
)

func Test_summaryRangesString(t *testing.T) {
	tests := []struct {
		Nums     []int
		Expected string
	}{
		{[]int{0, 1, 2, 4, 5, 7}, "0->2,4->5,7"},
		{[]int{0, 2, 3, 4, 6, 8, 9}, "0,2->4,6,8->9"},
		{[]int{}, ""},
		{[]int{1}, "1"},
		{[]int{1, 2}, "1->2"},
		{[]int{1, 3}, "1,3"},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			actual := summaryRangesString(test.Nums)

			if actual != test.Expected {
				t.Errorf("Expected %v, got %v", test.Expected, actual)
			}
		})
	}
}

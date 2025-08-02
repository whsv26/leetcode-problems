// https://leetcode.com/problems/summary-ranges/description/

package golang_problems

import (
	"fmt"
	"sort"
	"strings"
)

func summaryRanges(nums []int) []string {
	var ranges []string

	for i, j := 0, 0; i < len(nums); j++ {

		if j+1 < len(nums) && nums[j+1]-nums[j] == 1 {
			continue
		}

		if j == i {
			ranges = append(ranges, fmt.Sprintf("%d", nums[i]))
		} else {
			ranges = append(ranges, fmt.Sprintf("%d->%d", nums[i], nums[j]))
		}
		i = j + 1
	}

	return ranges
}

func summaryRangesString(nums []int) string {
	sort.Ints(nums)
	var sb strings.Builder

	for i := 0; i < len(nums); i++ {

		num := nums[i]

		for i+1 < len(nums) && nums[i+1]-nums[i] == 1 {
			i++
		}

		if num == nums[i] {
			sb.WriteString(fmt.Sprintf("%d", nums[i]))
		} else {
			sb.WriteString(fmt.Sprintf("%d->%d", num, nums[i]))
		}

		if i+1 != len(nums) {
			sb.WriteString(",")
		}
	}

	return sb.String()
}

func summaryRangesStringOld(nums []int) string {
	sort.Ints(nums)
	var sb strings.Builder

	for i, j := 0, 0; i < len(nums); j++ {

		if j+1 < len(nums) && nums[j+1]-nums[j] == 1 {
			continue
		}

		if j == i {
			sb.WriteString(fmt.Sprintf("%d", nums[i]))
		} else {
			sb.WriteString(fmt.Sprintf("%d->%d", nums[i], nums[j]))
		}

		i = j + 1

		if i < len(nums) {
			sb.WriteString(",")
		}
	}

	return sb.String()
}

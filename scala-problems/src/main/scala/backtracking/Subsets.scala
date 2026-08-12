package org.whsv26.leetcode
package backtracking

object Subsets extends App {
  assert {
    ListSolution.subsets(Array(1, 2, 3)) == List(
      List(1, 2, 3),
      List(2, 3),
      List(1, 3),
      List(3),
      List(1, 2),
      List(2),
      List(1),
      List(),
    )
  }

  private object ListSolution {
    def subsets(nums: Array[Int]): List[List[Int]] = {
      def loop(numbers: List[Int]): List[List[Int]] =
        numbers match {
          case Nil => List(Nil)
          case number :: tail =>
            loop(tail).flatMap(subset => Array(number :: subset, subset))
        }

      loop(nums.toList)
    }
  }

  private object ArraySolution {
    def subsets(nums: Array[Int]): List[List[Int]] =
      nums match {
        case Array() => List(Nil)
        case Array(num, _*) =>
          subsets(nums.tail)
            .flatMap(subset => Array(num :: subset, subset))
      }
  }
}

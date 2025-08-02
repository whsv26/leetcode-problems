// https://leetcode.com/problems/summary-ranges/

object Solution {
  def summaryRanges(nums: Array[Int]): List[String] = {

    def loop(n: Int): List[Int] => List[String] = {
      case x1 :: x2 :: xs if x1 + 1 == x2 => loop(n + 1)(x2 :: xs)
      case x :: xs if n == 0 => s"$x" :: loop(0)(xs)
      case x :: xs => s"${x - n}->$x" :: loop(0)(xs)
      case Nil => Nil
    }

    loop(0)(nums.sorted.toList)
  }
}

assert(List("0->2", "4->5", "7") == Solution.summaryRanges(Array(0, 1, 2, 4, 5, 7)))
assert(List("0", "2->4", "6", "8->9") == Solution.summaryRanges(Array(0, 2, 3, 4, 6, 8, 9)))

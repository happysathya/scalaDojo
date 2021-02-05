package com.happysathya.playground

object StringZipOptimiser {

  def optimisedZip(s: String, charactersToRemove: Int): (String, (Int, Int)) = {
    0.until(s.length)
      .map(index => (index, index + charactersToRemove - 1))
      .filter(t => t._2 < s.length)
      .map(t => (s.substring(0, t._1) + s.substring(t._2 + 1), (t._1, t._2)))
      .map(r => (zip(r._1 + " "), r._2))
      .reduceLeft((a, b) => if (a._1.length < b._1.length) a else b)
  }

  private def zip(s: String): String = {

    def zip(current: Int, lastCharLength: Int, acc: String): String = {
      if (current == s.length) {
        acc
      } else {
        if (current == 0) {
          zip(current + 1, 1, "")
        } else {
          if (s.charAt(current) != s.charAt(current - 1)) {
            zip(current + 1, 1, s"${acc}${s.charAt(current - 1)}$lastCharLength")
          } else {
            zip(current + 1, lastCharLength + 1, acc)
          }
        }
      }
    }

    zip(0, 0, "")
  }

}

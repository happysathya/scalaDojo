package com.happysathya.playground

object StringToCamelCase {

  def toCamelCase(str: String): String = {

    def concat[T](tail: List[T]): String = {
      tail.foldLeft("")((a, b) => a + b)
    }

    def singleWordToCamelCase(word: String): String = {
      word.toList match {
        case head :: tail if tail.nonEmpty => head.toUpper + concat {
          tail
        }
        case head :: Nil => head + ""
      }
    }

    str.split("[-_]").toList match {
      case Nil => ""
      case head :: Nil => head
      case head :: tail => head + concat {
        tail.map(s => singleWordToCamelCase(s))
      }
    }
  }
}

package com.happysathya.playground

object FirstUniqueCharacter extends App {

  def findFirstUniqueCharacter(data: String): Either[String, Char] = {
    data
      .groupMap(c => c)(c => c)
      .view
      .mapValues(seq => seq.size)
      .find(tuple => tuple._2 == 1)
      .map(tuple => tuple._1)
      .toRight("No unique characters")
  }

}

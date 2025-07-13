package com.happysathya.playground.strings

import scala.collection.mutable

object FirstUniqueCharacter extends App:

  def findFirstUniqueCharacter(data: String): Either[String, Char] =
    data
      .groupMap(c => c)(c => c)
      .view
      .mapValues(seq => seq.size)
      .find(_._2 == 1)
      .map(_._1)
      .toRight("No unique characters")

  def findFirstUniqueCharacterUsingLinkedHashMap(data: String): Either[String, Char] =
    val linkedHashMap = new mutable.LinkedHashMap[Char, Int]
    data.foreach(c => linkedHashMap.put(c, linkedHashMap.getOrElse(c, 0) + 1))
    linkedHashMap.find(_._2 == 1).map(_._1).toRight("No unique characters")

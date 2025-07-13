package com.happysathya.playground.utilities

object DataCleanup:

  def emailCleanup(data: String): String =
    Option(data)
      .map(nonNullData =>
        nonNullData
          .replace("@googlemail", "@gmail")
          .replace("@hotmail.co.uk", "@hotmail.com")
      )
      .orNull

  def emailSpecialCharactersCleanup(data: String): String =
    Option(data)
      .map(email =>
        val atIndex = email.indexOf("@")
        if atIndex == -1 then email
        else
          val emailBeforeAt = email.substring(0, atIndex)
          val emailAfterAt  = email.substring(atIndex)

          emailBeforeAt.replaceAll("[-/.]", "") + emailAfterAt
      )
      .orNull

  def mergeMaps(values: Seq[Map[String, Int]], threshold: Int): Int =
    values
      .reduce((map1, map2) =>
        (map1.keySet ++ map2.keySet).map { key =>
          (key, map1.getOrElse(key, 0) + map2.getOrElse(key, 0))
        }.toMap
      )
      .filter { case (_, score) => score >= threshold }
      .keys
      .toList
      .map(_.toInt)
      .sorted
      .headOption
      .getOrElse(0)
end DataCleanup

package com.happysathya.playground.utilities

import scala.annotation.tailrec

object ProcessLogs:

  def processLogs(logs: Array[String], threshold: Int): Array[String] =
    val regex = """(\d*) (\d*) (\d*)""".r

    @tailrec
    def processLogsInline(logs: Array[String], acc: Map[String, Int]): Map[String, Int] =
      logs.headOption match
        case Some(log) =>
          log match
            case regex(senderId, recipientId, _) =>
              val senderCount    = acc.getOrElse(senderId, 0)
              val recipientCount = acc.getOrElse(recipientId, 0)
              processLogsInline(
                logs.tail,
                acc ++ Map(senderId -> (senderCount + 1), recipientId -> (recipientCount + 1))
              )
            case _ => processLogsInline(logs.tail, acc)
        case None => acc

    processLogsInline(logs, Map.empty)
      .filter(_._2 >= threshold)
      .toSeq
      .sortWith(_._2 < _._2)
      .map(_._1)
      .toArray

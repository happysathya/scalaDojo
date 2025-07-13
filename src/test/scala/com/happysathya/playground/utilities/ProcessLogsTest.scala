package com.happysathya.playground.utilities

import com.happysathya.playground.utilities.ProcessLogs.processLogs
import weaver.FunSuite

object ProcessLogsTest extends FunSuite:

  test("process logs") {
    expect.all(
      processLogs(Array("88 99 200", "88 99 300", "99 32 100", "12 12 15"), 2).toList == List(
        "88",
        "99"
      ),
      processLogs(Array("9 7 50", "22 7 20", "33 7 50", "22 7 30"), 3).toList == List("7"),
      processLogs(Array("1 2 50", "1 7 70", "1 3 20", "2 2 17"), 2).toList == List("2", "1")
    )
  }

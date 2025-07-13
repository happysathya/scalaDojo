package com.happysathya.playground.math

import weaver.SimpleIOSuite

object GcdAndLcmEuclideanTest extends SimpleIOSuite:

  test("greatest common divisor using euclidean algorithm") {
    for
      result1 <- GcdAndLcmEuclidean.greatestCommonDivisor(48, 14)
      result2 <- GcdAndLcmEuclidean.greatestCommonDivisor(18, 48)
      result3 <- GcdAndLcmEuclidean.greatestCommonDivisor(2, 2)
      result4 <- GcdAndLcmEuclidean.greatestCommonDivisor(0, 1)
      result5 <- GcdAndLcmEuclidean.greatestCommonDivisor(1, 0)
      result6 <- GcdAndLcmEuclidean.greatestCommonDivisor(5, 0)
      result7 <- GcdAndLcmEuclidean.greatestCommonDivisor(5, 1)
    yield expect.all(
      result1 == 2,
      result2 == 6,
      result3 == 2,
      result4 == 1,
      result5 == 1,
      result6 == 5,
      result7 == 1
    )
  }

  test("least common multiplier using euclidean algorithm") {
    for
      result1 <- GcdAndLcmEuclidean.leastCommonMultiple(21, 6)
      result2 <- GcdAndLcmEuclidean.leastCommonMultiple(48, 14)
    yield expect.all(
      result1 == 42,
      result2 == 336
    )
  }
end GcdAndLcmEuclideanTest

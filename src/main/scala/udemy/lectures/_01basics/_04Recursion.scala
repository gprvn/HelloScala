package udemy.lectures._01basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object _04Recursion extends App{

  def factorial(n: Int): BigInt = {
    if(n <= 1) {
      println("computed factorial for: "+n)
      1
    }
    else{
      println("Computing factorial of "+ n + "- I first need factorial of "+(n-1))
      val result = n * factorial(n-1)
      println("computed factorial for: "+n)

      result
    }
  }

  //This is a better approach to solve recursive problems
  //When we need LOOPS, we should use tail recursion
  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if(x<=1) accumulator
      else factHelper(x - 1, x * accumulator) //Tail Recursion = use Recursive call as the LAST Expression
    factHelper(n, 1)
  }

  println(anotherFactorial(10000))

  /**
   *  how anotherFactorial function is working: step-by-step
   *
   *  anotherFactorial(10) = factHelper(10,1)
   *  factHelper(9, 10 * 1)
   *  factHelper(8, 9 * 10 * 1)
   *  factHelper(7, 8 * 9 * 10 * 1)
   *  .
   *  .
   *  .
   *  .
   *  .
   *  .
   *  factHelper(2, 3 * 4 * ...... * 10 * 1)
   *  factHelper(1, 1 * 2 * 3 * 4 * ..... * 10 * 1)
   *  1 * 2 * 3 * 4 * ..... * 10 * 1 // final factorial value, which is required
   *
   */

//  println(factorial(10))
//  println(factorial(8000))


  /**
   *  Coding Exercise::
   *
   *  1.  Concatenate a string n times
   *  2.  IsPrime function tail recursive
   *  3.  Fibonacci function, tail recursive
   */

  //Solution - 1

  def concatenateTrainRec(aString: String, n: Int, accumulator: String): String = {
    if(n<=0) accumulator
    else concatenateTrainRec(aString,n-1, aString + accumulator)
  }

  println(concatenateTrainRec("hello",3,""))

  //Solution - 2
  def primeNumberTrailRec(num: Int): Boolean = {
    @tailrec
    def isPrimeTrailRec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if(t<=1) true
      else isPrimeTrailRec(t - 1, num % t != 0 && isStillPrime)

    isPrimeTrailRec(num / 2, true)
  }

  println(primeNumberTrailRec(17))
  println(primeNumberTrailRec(10))

  //Solution - 3

  def fibonacci(n: Int): Int = {
    def fiboTrailRec(i: Int, last:Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTrailRec(i + 1, last + nextToLast, last)

    if(n <= 2) 1
    else fiboTrailRec(2,1,1)
  }

  println(fibonacci(8 ))
}

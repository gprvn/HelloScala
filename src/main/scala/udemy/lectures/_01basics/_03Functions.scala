package udemy.lectures._01basics

object _03Functions extends App {

  def aFunction(a: String, b: Int): String = {

    a + " " + b
//    a + " aged " + b

  }

  println(aFunction("praveen",36))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
//  println(aParameterlessFunction)


  def aRepeatedFunction(a: String, n: Int): String = {

    if(n==1) a
    else a + aRepeatedFunction(a, n-1)

  }
  //WHEN YOU NEED LOOPS, USE RECURSION
  print(aRepeatedFunction("hello", 3))

  def aFunctionWithSideEffects(n: Int) = println(n)

  def aBigFunction(n: Int) = {

    def aSmallerFunction(a: Int, b:Int): Int =
      a + b

    aSmallerFunction(n, n-1)

  }

  println(aBigFunction(5))


  /**
   * Excersise:
   *
   * 1. A Greeting function (name, age) => Hi, my name is $name and i'm $age years old.
   *
   * 2. A factorial function, to calculate factorial of given n number 1 * 2 * 3 * 4...
   *
   * 3. A Fibonacci function
   *    f(1) = 1
   *    f(2) = 1
   *    f(n) = f(n-1) + f(n-2)
   *
   * 4. Test if a number is prime
   */


  //Solution 1:

  def greetings(name: String, age: Int):String =
    "Hi my name is "+name+" and I'm "+age+" years old"

  println(greetings("Praveen", 36))

  //Solution 2:
  def aFactorial(n: Int): Int = {
    if (n <= 0) 1
    else n * aFactorial(n-1)
  }
  println(aFactorial(4))

  //Solution 3:
  def aFibonacci(n: Int):Int =
    if(n <= 2) 1
    else aFibonacci(n -1) + aFibonacci(n - 2)

  println(aFibonacci(5))

  //Solution 4:
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(17))
  println(isPrime(6))

}


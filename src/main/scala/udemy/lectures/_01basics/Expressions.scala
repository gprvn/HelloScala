package udemy.lectures._01basics

object Expressions extends App{

  val x = 1 + 2 //expressions
  println(x)

  println(2 + 3 * 4)
  // + - / * / & | ^ << >>  >>> (right shift with zero extension)

  println(1 == x)

  println(! (1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 //also works with -= *= /=
  println(aVariable)

  // Instructions (DO) Vs Expression (Value)

  //if expression

  val aCondition = true;
  val aConditionValue = if(aCondition) 5 else 3
  println(aConditionValue)

  println(if(aCondition) 5 else 3)

  var y = 0;
  while(y <= 10){
    println(y)
    y+=1
  }

  //avoid while loops in Scala

  //Everything in Scala is an Expression

  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)

  //side effects: println(), whiles, reassigning, expressions return Unit

  //Code Block

  val aCodeBlock = {
    val i = 2
    val b = 3
    if(b > 2) "hello" else "bye"
  }

  println(aCodeBlock)

  val someValue = {
    2 < 3
  }

  println(someValue)

  val someOtherValue = {
    if(someValue) 256 else 196
    43
    45
  }

  println(someOtherValue)

  val newThing = println("hello world")
  println(newThing)



}

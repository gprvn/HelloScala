/*
Conditional expression in scala
 */
var x = -1

if x > 5 then 1 else -1

var t = 0
if x > 0 then t = 1 else t = -1

if x > 0 then "positive" else -1

if x > 0 then "positive"

println(if x > 0 then "positive")

if x < 0 then println("negative")

if x > 0 then 1 else
if x == 0 then 0 else -1
/*
statement termination
*/
var n = 1
var r = 2;

if n > 0 then { r = r * n; n -= 1 }
print(r,n)
var d = r*n+5+n-2+
  r*n-r
print(d)

/*
* Block expression and assignments
* */

//block with {}
var a = 10
var a0 = 12
var b = 20
var b0 = 22

{print("hello"); print("hello")}

val result = {val dx = a-a0; val dy = b-b0; scala.math.sqrt(dx*dx + dy*dy)}

//block with identation
var result2 =
  val xx = a-a0;
  val yy = b-b0;
  scala.math.sqrt(xx*xx + yy*yy)

var number = 11
if number % 2 == 0 then
  a = a*a
  number += 2
else
  b = b*b
  number -= 1

{2*2; 1+1}

{2*2;
1*1;
3*3}


/**
Input & Output with Scala
**/

print("answer")
println(42)
println("answer:"+42)
var age = 24
var name = "praveen"

println(f"Hello, $$$name! in six months, you'll be${age + 0.5}%7.2f years old. An increase of %%5")


/**
 * Loops
 * */

var num = 5
while(num >=1)
  println(num);
  num -= 1

var num1 = 15
while(num1 >=1)
  println(num1);
  num1 -= 1
end while

for i <- 1 to 10 do
  print("num1 is:"+i)

print("done")
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


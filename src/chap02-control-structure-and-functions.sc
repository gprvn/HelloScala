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



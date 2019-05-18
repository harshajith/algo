package cs2

/**
  * Created by Harsha on 25/12/16.
  */
object Solution {

  def solution(a: Int, b: Int): Int = {

    var x = 0.0
    var y = 0.0
    if(a > 0){
      x = Math.sqrt(a.toDouble)
    }else {
      x = 1.0
    }


    if(b > 0){
      y = Math.sqrt(b.toDouble)
    }else {
      return -1
    }


    //print(x +" --- " + y)

    return (y - x + 1).toInt


    // write your code in Scala 2.12
  }

  def main(args : Array[String]) {

    print(Solution.solution(3,28))

    //print("X")
  }
}

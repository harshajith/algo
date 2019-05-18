package cs2

/**
  * Created by Harsha on 25/12/16.
  */
object AdjacentCoinProblem {


  object Solution {
    def solution(A: Array[Int]): Int = {
      var n = A.length;
      var result = 0;
      var i = 0;


      while (i < n - 1) { //length -1
        if (A(i) == A(i + 1)){
          result = result + 1;
        }
        i = i + 1;
      }

      println("result: " + result)

      var result2 = 0;

      i = 0;


      while (i < n) {
        var count = 0;
        if (i > 0) {
          if ((A(i - 1) != A(i)))
            count = count + 1;
          else
            count = count - 1;
        }
        if (i < n-1) {
          if (A(i + 1) != A(i))
            count = count + 1;
          else
            count = count - 1;
        }

        result2 = Math.max(result2, count);
        println(result2)

        i = i + 1;
      }

      if(A.size == 1) return 0;
      return result + result2;
    }
  }


  def main(args : Array[String]){

    val x = Array(1,1,0,0,0,1)
    print(Solution.solution(x))

  }

}

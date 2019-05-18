package cs2

/**
  * Created by Harsha on 25/12/16.
  */
object TestNOON {


  def checkIfUpperCasePresent(longestSubstring: mutable.MutableList[Char]) : Boolean = {

    for(char <- longestSubstring){
      if(char.isUpper) return true
    }

    return false

  }

  def solution(s: String): Int = {

    var longestSubstring = mutable.MutableList[Char]()
    var resultList = mutable.MutableList[Int]()
    var longestSubstringLength = 0

    for(i <- s.indices){
      if(s(i).isDigit){

        if(checkIfUpperCasePresent(longestSubstring)){
          resultList += longestSubstring.size
          longestSubstring = mutable.MutableList[Char](); //initialise again
        }else {
          longestSubstring = mutable.MutableList[Char](); //initialise again
          resultList += -1
        }

      }else {
        longestSubstring += s(i)
        if(i == s.length-1){ //last element
          if(checkIfUpperCasePresent(longestSubstring)){
            resultList += longestSubstring.size
            longestSubstring = mutable.MutableList[Char](); //initialise again
          }else {
            resultList += -1
          }
        }
      }
    }
    resultList.max
  }


  def main(args : Array[String])  {

    print(TestNOON.solution("222GSdds22"))
  }

}

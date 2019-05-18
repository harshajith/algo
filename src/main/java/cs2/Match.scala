package cs2

/**
  * Created by Harsha on 25/12/16.
  */
object Match {


  def makeFullString(s:String) : String = {
    val sb = new StringBuilder
    for(i <- s.indices){

      if(s(i).isDigit){
        for(x <- 1 to s(i).asDigit){
          sb += '?'
        }
      }else {
        sb += s(i)
      }
    }
    sb.mkString
  }

  def isValidEnglishLetter(c: Char) = c.isLetter && c <= 'z'

  def checkIfMatching(z: Char, k: Char) : Boolean= {
    if(z.equals(k) || (z.equals('?') && isValidEnglishLetter(k)) || (isValidEnglishLetter(z) && k.equals('?'))) return true else false
  }

  def solution(s: String, t: String): Boolean = {

    if(s.length < 1 || t.length <1){
      return false
    }
    val x = makeFullString(s)
    val y = makeFullString(t)

    if(x.length != y.length) return false

    for(i <- x.indices){

      val z = x(i) // first char of string A
      val k = y.charAt(i) // char in the same position as in string A

      if(!checkIfMatching(z, k)) return false

    }

    true
  }

  def main(args: Array[String]) {

    print(Match.solution("3x2x", "8"))

  }

}

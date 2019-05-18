package cs2

/**
  * Created by Harsha on 24/12/16.
  */
object CheckParanthesis {


  /**
    * O(n)
    * @param str
    * @return
    */
  def checkIfValidString(str:String) : Boolean = {

    val openers = List("[", "{", "(")
    val closers = List("]", "}", ")")

    var stack = new mutable.Stack[String]()

    for(x <- str){

      if(openers.contains(x.toString)){
        stack.push(x.toString)

      }else if(closers.contains(x.toString)){
        val y = stack.pop()
        if(!openers.indexOf(y).equals(closers.indexOf(x.toString))){
          return false;
        }
      }
    }

    if(stack.length == 0)return true else false
  }

  def main(args: Array[String]){

    val str = "[](){{{}}} {}[]"
    println(CheckParanthesis.checkIfValidString(str))


  }

}

package leetcode.feb;


import java.util.Stack;

/**
 * Simplify Path
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 *
 *
 *
 * Example 1:
 *
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 *
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 *
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * Example 4:
 *
 * Input: path = "/a/./b/../../c/"
 * Output: "/c"
 *
 *
 * Constraints:
 *
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 */
public class SimplifyPath {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        if(path.charAt(0) != '/') return "";
        Stack<String> stack = new Stack<>();
        stack.push("/"); // push the start '/' into the stack.

        for(int i=0; i<names.length; i++){
            if(names[i].equals("") || names[i].equals(".")){ // Consecutive '/' found
                continue;
            }else if(names[i].equals("..") && stack.size() > 2){ // '..' found
                stack.pop();
                stack.pop();
            }else if(names[i].equals("..") && (stack.size() < 2)){ // '..' found and only first '/' is present.
                continue;
            }else { // valid name found
                stack.push(names[i]);
                stack.push("/");
            }
        }
        String result = "";
        if(stack.size() < 2) {
            return "/";
        }else{
            stack.pop(); // remove the top '/'
            Stack<String> resultStack = new Stack<>();
            while(!stack.isEmpty()){
                resultStack.push(stack.pop());// reverse the stack.
            }
            while(!resultStack.isEmpty()){
                result += resultStack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args){
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home/../"));
    }
}

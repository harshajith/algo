package leetcode.random;

import java.util.*;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *
 * Constraints:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class LogFiles {


    public static void main(String[] args){
        List<String> input = Arrays.asList("al 9 2 3 1", "gl act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo");
        List<String> output = reorderLogFiles(input);

        for(String str: output){
            System.out.println(output);
        }
    }


    public static List<String> reorderLogFiles(List<String> logLines){
        if(logLines.size() > 100) throw new RuntimeException("Logs are above 100");


        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] a1 = o1.split(" ");
                String[] a2 = o2.split(" ");

                for(int i=1; i<a1.length && i<a2.length; i++){
                    if(a1[i].equals(a2[i])) {
                        continue;
                    }else {
                        return a1[i].compareTo(a2[i]);
                    }
                }
                return a1[0].compareTo(a2[0]);
            }
        };
        int front = 0;
        int length = logLines.size();
        List<String> result = new ArrayList<>();

        List<String> sortable = new ArrayList<>();
        List<String> arrayWithDigits = new ArrayList<>();

        for(String log: logLines){
            String[] entries = log.split(" ");
            if(checkIfDigit(entries[1])){
                arrayWithDigits.add(log);
            }else {
                sortable.add(log);
            }
        }

        Collections.sort(sortable, comparator);
        for(String str: sortable){
            result.add(str);
        }
        for(String str: arrayWithDigits){
            result.add(str);
        }
        return result;
    }

    public static boolean checkIfDigit(String a){
        try{
            Integer.valueOf(a);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }


}

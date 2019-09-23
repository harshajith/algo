package aws.s3;

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
        String[] input = new String[]{"t kvr", "r 3 1", "i 403", "7 so", "t 54"};
        String[] output = reorderLogFiles(input);

        for(int i=0; i<output.length; i++){
            System.out.println(output[i]);
        }
    }

    private static Comparator<String[]> comparator = new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            for(int i=1; i<o1.length && i<o2.length; i++){
                if(o1[i].equals(o2[i])) {
                    continue;
                }else {
                    return o1[i].compareTo(o2[i]);
                }
            }
            return o1[0].compareTo(o2[0]);
        }
    };

    public static String[] reorderLogFiles(String[] logs){
        if(logs.length > 100) throw new RuntimeException("Logs are above 100");

        int front = 0;
        int length = logs.length;

        List<String[]> sortable = new ArrayList<>();
        List<String> arrayWithDigits = new ArrayList<>();

        for(int i=0; i<length; i++){
            String log = logs[i];
            String[] entries = log.split(" ");


            if(checkIfDigit(entries[1])){
                arrayWithDigits.add(log);
            }else {
                sortable.add(entries);
            }
        }

        Collections.sort(sortable, comparator);

        for(int i=0; i<sortable.size();i++){
            logs[i] = String.join(" ", sortable.get(i));
        }
        for(int i=0; i<arrayWithDigits.size(); i++){
            logs[i+sortable.size()] = arrayWithDigits.get(i);
        }
        return logs;
    }

    private static boolean checkIfDigit(String a){
        try{
            Integer.valueOf(a);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }


}

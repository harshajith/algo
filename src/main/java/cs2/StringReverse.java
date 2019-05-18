package cs2;

/**
 * Created by Harsha on 5/10/16.
 */
public class StringReverse {


    public static String reverse(String s){
        if(s == null || s.length() <= 1) return s;

        return (reverse(s.substring(1)) + s.charAt(0));
    }

    public static void main(String[] arss){
        //System.out.println(reverse("SFSDfsWEF"));

        String re = checkSubString("E");
        System.out.println(re);


    }



    public static String checkSubString(String s){
        return s.substring(1);
    }
}

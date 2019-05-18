package com.harsha.cs;

public class ReverseString {

    public static String reverseString(String str){
        System.out.println(str.length() + "::" + str);
        if(str.length() < 1) {
            return str;
        } else {
            return str.charAt(str.length()-1) + reverseString(str.substring(0, str.length()-1));
        }
    }

    public static void main(String[] args){
        //System.out.println(reverseString("SSFRRWWGGEAD"));
        String a = "A";
        System.out.println(a.substring(0,a.length()-1));
    }

}

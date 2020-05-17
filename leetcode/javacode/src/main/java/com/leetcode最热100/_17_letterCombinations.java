package com.leetcode最热100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_letterCombinations {


    static Map<String,String> phone = new HashMap<String,String>(){{
        put("2","abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }
    };

    static List<String> output = new ArrayList<>();

    public static void main(String[] args){
        letterCominations("23");
    }
    public static List<String> letterCominations(String digits){
        if(digits.length() != 0) {
            backtrack("",digits);
        }
        return output;
    }

    static int count =0;
    public static void backtrack(String combination,String next_digits){
        if(next_digits.length() == 0){
            System.out.println(" res ---------: " +combination);
            output.add(combination);
        }else {
            String digit = next_digits.substring(0,1);
            String letters = phone.get(digit);
            for (int i = 0; i <letters.length();i++){
                String letter = phone.get(digit).substring(i,i+1);
                System.out.println("combination : " + combination+letter +", count "+(++count)
                +", digit: " + digit);
                backtrack(combination+letter,next_digits.substring(1));
            }
        }
    }
}

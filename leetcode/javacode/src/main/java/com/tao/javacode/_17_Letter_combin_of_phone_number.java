package com.tao.javacode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * iven a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 2 - "abc", 3- "def", 4 - "ghi" ... , 9 - "wxyz"
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 * Created by SDT14324 on 2018/3/28.
 */

public class _17_Letter_combin_of_phone_number {

    public static void main(String[] args){
        String digits = "234";
        List<String> res = letterCombinations(digits);
        printList(res);
    }

    /**
     * 使用的是先进先出队列原理，
     * 第一轮，链表队列 a b c
     * 第二轮，移除头元素a，与def组合后形成 ad ae af，链表变成 b c ad ae af
     * 继续第二轮，移除头元素b，与def组合形成 bd be bf，链表变成 c ad ae af bd be bf
     * 继续移除c，链表变成 ad ae af bd be bf cd ce cf
     * 第三轮，移除ad，与ghi组合形成，adg adh adi,链表变成 ae af bd be bf cd ce cf adg adh adi
     * 依次类推。
     */
    private static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            System.out.println("x = "+x+", i = "+i);
            while(ans.peek().length()==i){
                System.out.println("ans peek = "+ans.peek());
                String t = ans.remove();
                System.out.println("t = "+t);
                for(char s : mapping[x].toCharArray()){
                    ans.add(t+s);
                    System.out.println("t = "+t+", s = "+s+", ts = "+(t+s));
                }

            }
        }
        return ans;
    }

    private static void printList(List<String> list){
        for(int i = 0 ; i < list.size(); i++){
            System.out.print(list.get(i)+",");
        }
        System.out.println();
    }
}

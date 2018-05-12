package com.tao.javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 * Created by SDT14324 on 2018/5/12.
 */

public class _49_group_anagrams {
    public static void main(String[] args){
        String[] ans = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(ans);
        printList(lists);
    }

    public static void printList(List<List<String>> list){
        /* for (int i = 0; i < list.size(); i++){

         }*/
         System.out.println(list.toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<String,List> ans = new HashMap<String,List>();
        for (String s:strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = new String(ca);
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}

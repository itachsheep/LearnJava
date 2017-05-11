package com.example;

/**
 * Created by taow on 2017/4/11.
 */

public class RemoveAsicDemo {
    public static void main(String[] args){
        String src = "\u0013CCTV-1 综合";
        String test = "CCTV-1 综合";



        char[] chars = src.toCharArray();
        System.out.println("-------------src-----length-1-----------------"+chars.length);
        for(int i = 0 ; i < src.length(); i++){
            System.out.println((int)chars[i]+" ------> ");
        }

        if(src.charAt(0)== 19){
            System.out.println("******************remove********************");
            src = src.substring(1);
        }
        char[] chars2 = src.toCharArray();
        System.out.println("-------------src-----length-2-----------------"+chars2.length);
        for(int i = 0 ; i < src.length(); i++){
            System.out.println((int)chars2[i]+" ------> ");
        }
//
//
//        char[] chars2 = test.toCharArray();
//        System.out.println("-------------test-----length------------------"+chars2.length);
//        for(int i = 0 ; i < test.length(); i++){
//            System.out.println(chars2[i]+" ------> ");
//        }
    }
}

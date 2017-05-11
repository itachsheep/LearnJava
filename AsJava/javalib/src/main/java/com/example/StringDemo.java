package com.example;

import java.util.ArrayList;
import java.util.Random;

/**
 * AsJava
 * Created by tw on 2017/3/9.
 */

public class StringDemo {
    public static void main(String[] args){

//        test();
//        String url = "http:/http://www.baiud.com";
//        System.out.println("index: "+url.indexOf("http://"));

        StringBuffer sb = new StringBuffer();
        String softwareVersion = "0808";

        // 版本转化的时候只要大于3位就可以了，实际应该是只会为4位

        sb.append(softwareVersion.substring(0, 2));
        sb.append(".");
        sb.append(softwareVersion.substring(2));

        System.out.println("sb : "+sb);

    }

    private static void substringtest() {
        String curUsingDir = "";
        String res = curUsingDir.substring(curUsingDir.lastIndexOf("/") + 1);
        System.out.println("res: "+res);
    }

    private static void test() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 20; i++){
            Random random = new Random();
            list.add(new Integer(random.nextInt(100)));
        }

        for(int i = 0 ; i < 20; i++){
            System.out.print(list.get(i)+", ");
        }
        System.out.println("");
        System.out.println("-------------------------------");
        Integer bookj,bookj1,booki;
        for(int i = 0 ; i < list.size() ; i++){
            for(int j = 0; j < list.size()-1; j++){
                bookj = list.get(j);
                bookj1 = list.get(j+1);
                if(bookj > bookj1){
                    list.set(j,bookj1);
                    list.set(j+1,bookj);
                }
            }
        }
        for(int i = 0 ; i < 20; i++){
            System.out.print(list.get(i)+", ");
        }
        System.out.println();
    }
}

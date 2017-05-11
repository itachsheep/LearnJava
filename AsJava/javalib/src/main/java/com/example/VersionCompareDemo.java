package com.example;

import java.io.File;

import sun.rmi.runtime.Log;

public class VersionCompareDemo {
    public static void main(String[] args){
//        String url = "http://183.224.42.218/upload/yunnanMango9505/jenkins-YUNNAN_MANGO-p201_iptv-ota-4.0.2.zip";
//        String res = url.substring(url.lastIndexOf("/") + 1);
////        int i = url.lastIndexOf("/");
//        System.out.println("res: "+res);

//        String localVer = "4.3.0" ;
//        String startVer = "4.1.9";
//        String endVer = "4.4.3";
//        if(isVersionBetweenStartAndEnd(localVer,startVer,endVer)){
//            System.out.println(localVer+" is in "+startVer+"--"+endVer);
//        }else{
//            System.out.println(localVer+" not in "+startVer+"--"+endVer);
//
//        }



    }

    /**
     *  如果在区间，则返回true，反正返回false
     *
     * @param localVer
     *      本地版本
     * @param startVer
     *      开始版本
     * @param endVer
     *      结束版本
     * @return
     */
    public static boolean isVersionBetweenStartAndEnd(String localVer,String startVer,String endVer){
        if(compareVersion(localVer,startVer)){
            //如果大于或等于开始版本
            System.out.println("isVersionBetweenStartAndEnd bigger than startVer");
            if(!compareVersion(localVer,endVer)){
                //如果小于结束版本
                System.out.println("isVersionBetweenStartAndEnd smaller than endVer");
                return true;
            }
        }
        return false;
    };

    /**
     * 比较两个版本号，本地版本大于或等于则返回 true，本地版本小则返回 false
     *
     * @param localVer
     *            本地版本号
     * @param startVer
     *            开始版本号
     * @return
     */
    public static boolean compareVersion(String localVer, String startVer) {
        System.out.println("compareVersion localVer: "+localVer+", startVer: "+startVer);
        if (localVer.equals(startVer))
        {
            System.out.println("compareVersion localVer: "+localVer+", startVer: "+startVer);
            return false;
        }


        String[] localArray = localVer.split("\\.");
        String[] onlineArray = startVer.split("\\.");

        int length = localArray.length < onlineArray.length ? localArray.length : onlineArray.length;

        for (int i = 0; i < length; i++)
        {
            System.out.println("compareVersion i "+i+",localArray: "+localArray[i]+
                    ", onlineArray "+onlineArray[i]);
            if (Integer.parseInt(onlineArray[i]) < Integer.parseInt(localArray[i])){
                //大于
                System.out.println("compareVersion i "+i+" bigger");
                return true;

            }else if (Integer.parseInt(onlineArray[i]) > Integer.parseInt(localArray[i])){
                //小于
                System.out.println("compareVersion i "+i+" smaller");
                return false;

            }
            // 相等 比较下一组值
        }
        System.out.println("compareVersion end ");
        return true;
    }
}

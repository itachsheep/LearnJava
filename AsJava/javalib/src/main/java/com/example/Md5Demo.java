package com.example;

import java.io.File;

/**
 * Created by taow on 2017/4/8.
 */

public class Md5Demo {
    public static void main(String[] args){


        new Thread(){
            @Override
            public void run() {
                String file = "D:\\111\\bcm_97439B0SFF_7251S-gehua_9512c2-ota-02.06_no_bolt-qin.zip";
                String md5 = MD5.md5Sum(file);
                System.out.println("md5: "+md5);
            }
        }.start();

    }
}

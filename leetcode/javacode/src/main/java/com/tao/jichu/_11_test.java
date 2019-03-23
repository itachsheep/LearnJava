package com.tao.jichu;

import com.tao.comm.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _11_test {
    public static void main(String[] args){
        List<String> target = new ArrayList<>();
        target.add("/color/product1.jpg");
        target.add("/color/product2.png");
        target.add("/color/product3.jpg");
        target.add("/color/product4.png");
        target.add("/os/inlay1.png");
        target.add("/os/inlay2.png");
        target.add("/os/inlay3.jpg");
        target.add("/os/inlay4.png");

        List<String> ref = new ArrayList<>();
        ref.add("inlay1");
        ref.add("inlay2");
        ref.add("product1");
        ref.add("product2");
        ref.add("product3");
        ref.add("product4");
        ref.add("inlay3");
        ref.add("inlay4");

        HashMap<String,String> map = new HashMap<>();
        for (int i = 0; i < target.size(); i++){
            String val = target.get(i);
            String key = val.substring(val.lastIndexOf("/")+1, val.lastIndexOf("."));
            map.put(key,val);
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < ref.size(); i++){
            res.add(map.get(ref.get(i)));
        }
    }
}

package com.odh.test;

public class Test{

    @org.junit.Test
    public void test1(){
        String line = "162240 99999  20190106    44.7 24    36.8 24  9999.9  0  9999.9  0  999.9  0    4.2 24    8.0  999.9    -52.7    -38.8*  0.00F 999.9  000000";
        String[] split = line.trim().split("\\s+");
        int count = 0;
//        for (String s : split) {
//            System.out.println("count = " + count++ + " " + s);
//        }

        System.out.println(split[2].substring(0,4));
        System.out.println(Double.parseDouble(split[17].substring(0,3)));
        System.out.println(Double.parseDouble(split[18].substring(0,3)));

    }
}

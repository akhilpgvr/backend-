package com.noblewalk.backend;

import java.util.Random;

public class Helper {

    private static Random random = new Random();
    public static String generateOrderNumber(String mobileNo){
        return "ORD"+random.nextInt(100)+mobileNo.substring(6);
    }
}

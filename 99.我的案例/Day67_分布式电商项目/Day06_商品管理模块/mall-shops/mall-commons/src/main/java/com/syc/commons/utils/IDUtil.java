package com.syc.commons.utils;

import java.util.Random;

public class IDUtil {

    /**
     * 生成随机id
     */
    public static long getRandomId() {
        long millis = System.currentTimeMillis();

        //加上两位随机数
        Random random = new Random();
        int value = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", value);
        return Long.parseLong(str);
    }

}


package io.renren.utils;

import java.util.Random;

/**
 * @author Jiang-gege
 * 2018/7/1715:06
 */
public class IdUtils {
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
package com.myzone.demoutils.utils;

import java.util.*;

public class RandomUtils {

    //数组去重
    public static String[] distinct(String[] str){
        List list = Arrays.asList(str);
        Set set = new HashSet(list);

        return (String[])set.toArray(new String[0]);
    }

    //生成应用管理中的密钥
    public static String getSecretKey(){
        return getStringRandom(12);
    }

    //生成应用管理中的appid
    public static String getAppId(){
        return getStringRandom(10);
    }

    //生成随机几位数
    private static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if("char".equalsIgnoreCase(charOrNum)){
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            }else if("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}

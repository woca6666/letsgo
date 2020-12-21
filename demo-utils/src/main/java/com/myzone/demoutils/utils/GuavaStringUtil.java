package com.myzone.demoutils.utils;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.*;

public class GuavaStringUtil {

    static void guava_joiner_test(){

        List<String> list = Lists.newArrayList("a", "b", "", "c", null, "d");
//        List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "", "c", null, "d"));

        //连接器
        String str = Joiner.on(",").skipNulls().join(list);//.useForNull("!")将null替换成!
        System.out.println(str);
    }

    static void guava_splitter_test(){
        String str = "a, b, , c";

        //分割器
        Splitter SPLITTER = Splitter.on(",").trimResults().omitEmptyStrings();

        for (String s: SPLITTER.split(str)) {
            System.out.println( "|" + s + "|");
        }
    }

    static void guava_MapJoinner_test(){

//        ImmutableMap.of("name", "zhangsan", "address", "nanjing");
        Map<String, String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("address","nanjing");

        //连接器
        String str = Joiner.on("&").withKeyValueSeparator("=").join(map);
        System.out.println(str);
    }

    static void guava_MapSplitter_test(){
        //分割器
        Map<String, String> map = Splitter.on("&").withKeyValueSeparator("=").split("name=zhangsan&address=nanjing");

        for (String key : map.keySet()) {
            System.out.println(key + "---->" + map.get(key));
        }
    }

    static void guava_charmatcher_any(){
        String str = "a, b, , c";
        //字符串匹配器
        CharMatcher.any();
    }

    static void guava_charmatcher_digit(){
        //字符串匹配器
        System.out.println(CharMatcher.digit().retainFrom("mahesh123"));
        System.out.println("-----------");
        System.out.println(CharMatcher.is('h').retainFrom("mahesh123"));
        System.out.println("-----------");
        System.out.println(CharMatcher.digit().replaceFrom("mahesh123", "*"));
        System.out.println("-----------");
        System.out.println(CharMatcher.digit().or(CharMatcher.javaLowerCase()).retainFrom("MAHESH--mahesh123"));
    }

    public static void main(String[] args) {

        //guava官网教程
        //http://www.bjpowernode.com/tutorial_guava/736.html

//        guava_joiner_test();

//        guava_splitter_test();

//        guava_MapJoinner_test();

//        guava_MapSplitter_test();

//        guava_charmatcher_any();

        guava_charmatcher_digit();
    }
}

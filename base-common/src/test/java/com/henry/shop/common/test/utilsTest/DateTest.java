package com.henry.shop.common.test.utilsTest;

import org.junit.jupiter.api.Test;

import java.util.List;

public class DateTest {
    @Test
    void test(){
        List<String> urlList = List.of("http://www.baidu.com","http://www.taobao.com","http://www.zhihu.com");
        String urls = String.join(",", urlList);
        System.out.println(urls);
    }
}

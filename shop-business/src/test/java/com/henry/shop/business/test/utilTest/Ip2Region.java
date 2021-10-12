package com.henry.shop.business.test.utilTest;

import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ip2Region {
    private static final Pattern ipv4 = Pattern.compile("^(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}$");
    @Test
    void test(){
        String ip = "240e:398:70ac:6130:f04f:a09c:cfeb:1789";
        System.out.println("百度===="+baidu(ip));
        System.out.println("高德===="+gaode(ip));
    }
    String baidu(String ip){
        String ak = "NsdefyudVxV7qou5WsC9UUBzNb1lUZcm";
        String url = "https://api.map.baidu.com/location/ip";
        Map<String ,Object> params = new HashMap<>();
        params.put("coor","bd09ll");
        params.put("ak",ak);
        params.put("ip",ip);
        return HttpUtil.get(url, params);
    }

    String gaode(String ip){
        String url = "https://restapi.amap.com/v5/ip";
        String key = "763528f098c7500d2d206f80df8c5681";
        Matcher matcher = ipv4.matcher(ip);
        String type = matcher.find() ? "4" : "6";
        Map<String ,Object> params = new HashMap<>();
        params.put("type",type);
        params.put("key",key);
        params.put("ip",ip);
        return HttpUtil.get(url,params);
    }
}

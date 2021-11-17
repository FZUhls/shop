package com.henry.shop.common.test.utilsTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EnumTest {
    @Test
    void test1(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("222");
        arrayList.add("333");
        ArrayList<?> clone = (ArrayList)arrayList.clone();
        System.out.println(clone);
    }
}

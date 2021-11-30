package com.henry.shop.common.test.serviceTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.test.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JsonTest extends BaseTest {
    @Autowired
    ObjectMapper objectMapper;
    @Test
    void test1() throws JsonProcessingException {
        String s = objectMapper.writeValueAsString(BaseResponse.error());
        System.out.println(s);
    }
}

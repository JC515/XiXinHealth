package com.xixinhealthcheckup;

import com.xixinhealthcheckup.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XixinHealthCheckupApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void MD5Test() {
        System.out.println(MD5Util.getMD5("123456aa", 20));
    }

}

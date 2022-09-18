package com.app.imagecompressor;

import com.app.imagecompressor.ultil.StringUtils;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void randomSid() {
        String s = StringUtils.randomSid();
        System.out.println("s = " + s);
    }
}

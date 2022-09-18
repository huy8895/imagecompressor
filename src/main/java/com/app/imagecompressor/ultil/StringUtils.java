package com.app.imagecompressor.ultil;

import org.apache.commons.lang3.RandomStringUtils;

public class StringUtils {
    /**
     * @return sid: 19afvcosrtb701ng
     */
    public static String randomSid(){
        return RandomStringUtils.random(16, true, true)
                                .toLowerCase();
    }

    /**
     * @return file id : file_g9ivcdajbb6815in1cun10vj1d
     */
    public static String randomFileId(){
        String generatedString = RandomStringUtils.random(26, true, true);
        return "file_".concat(generatedString)
                      .toLowerCase();
    }
}

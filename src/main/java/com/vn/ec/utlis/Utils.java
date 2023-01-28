package com.vn.ec.utlis;

import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;

public class Utils {
    private static ModelMapper mapper = new ModelMapper();
    public static String genRandomString() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }
}

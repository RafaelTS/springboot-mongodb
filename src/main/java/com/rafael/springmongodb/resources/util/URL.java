package com.rafael.springmongodb.resources.util;

import java.io.UnsupportedEncodingException;

import static java.net.URLDecoder.*;

public class URL {

    public static String decodeParam(String text) {
        try {
            return decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}

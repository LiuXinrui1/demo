package com.example.addition;

import antlr.InputBuffer;
import lombok.SneakyThrows;
import org.assertj.core.api.UrlAssert;
import org.hibernate.engine.jdbc.ReaderInputStream;

import java.io.*;
import java.net.URL;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月04日 11:07
 */
public class TestUrl {
    @SneakyThrows
    public static void main(String[] args) {
        URL url = new URL("http://www.baidu.com");
        InputStream inputStream = url.openStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String string;

        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }

    }
}

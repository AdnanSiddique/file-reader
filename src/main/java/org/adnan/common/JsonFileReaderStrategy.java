package org.adnan.common;

import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReaderStrategy<T> implements FileReaderStrategy<T> {
    /**
     *   This method is used to read Json format files
     **/
    @Override
    public T readFile(String fileName, Class<T> cls) throws Exception {
        T result = null;
        try {
            final String content = Files.readString(Paths.get(fileName), StandardCharsets.US_ASCII);
            result = new Gson().fromJson(content, cls);
        } catch (Exception ex) {
            System.out.println("**** Error while reading json file : " + fileName);
            System.out.println(ex.getMessage());
        }
        return result;
    }
}

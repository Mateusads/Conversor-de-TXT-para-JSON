package br.com.converter.json.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineFile {

    public String readingLineFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            return line;
        }
        return line;
    }
}

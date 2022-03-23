package br.com.converter.json.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineFile {

    public BufferedReader readingLineFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        return br;
    }
}

package br.com.converter.json.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineFile {

    private final ProcessingObject processingObject = new ProcessingObject();

    public BufferedReader readingLineFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        return br;
    }
}

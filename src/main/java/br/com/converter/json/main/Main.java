package br.com.converter.json.main;

import br.com.converter.json.service.ConverterToJson;
import br.com.converter.json.service.CreateObjects;
import br.com.converter.json.service.ExtractDataService;
import br.com.converter.json.service.ReadLineFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static String path = "./src/main/resources/fileTwoLine.txt";

    public static void main(String[] args) {
        try {
            ReadLineFile readLine = new ReadLineFile();
            ConverterToJson converterJson = new ConverterToJson();

            System.out.println("Start a pragram - JSON CONVERTER - ");
            var usersConverterJson = readLine.readingLineFile(path);
            var usersJson = converterJson.converter(usersConverterJson);
            System.out.print(usersJson);

        } catch (IOException e) {
            System.out.println("500: Server Error.");
        }
    }
}
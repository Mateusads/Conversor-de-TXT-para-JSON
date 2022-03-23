package br.com.converter.json.main;

import br.com.converter.json.controller.ResponseProcessUser;
import br.com.converter.json.service.ConverterToJson;
import br.com.converter.json.service.ReadLineFile;

import java.io.IOException;

public class Main {
    private static String path = "./src/main/resources/fileOneLine.txt";

    public static void main(String[] args) {
        try {
            ReadLineFile readLine = new ReadLineFile();
            ConverterToJson converterJson = new ConverterToJson();
            ResponseProcessUser responseConvertUserFromLine = new ResponseProcessUser();

            System.out.println("Start a pragram - JSON CONVERTER - ");
            var lineReader = readLine.readingLineFile(path);
            var usersConverterJson = responseConvertUserFromLine.process(lineReader);
            var usersJson = converterJson.converter(usersConverterJson);
            System.out.print(usersJson);
        } catch (IOException e) {
            System.out.println("500: Server Error.");
        }
    }
}
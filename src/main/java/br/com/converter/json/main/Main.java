package br.com.converter.json.main;

import br.com.converter.json.controller.ResponseProcessUser;
import br.com.converter.json.service.ConverterToJson;
import br.com.converter.json.service.ReadLineFile;

import java.io.IOException;

public class Main {
    private static String path = "./src/main/resources/fileTwoLine.txt";
    private static ReadLineFile readLine = new ReadLineFile();
    private static ConverterToJson converterJson = new ConverterToJson();
    private static ResponseProcessUser responseConvertLineInUsers = new ResponseProcessUser();
    
    public static void main(String[] args) {
        try {
            System.out.println("Start a pragram - JSON CONVERTER - ");
            if(args.length > 0){
                path = args[0];
            }
            var lineReader = readLine.readingLineFile(path);
            var usersConverterJson = responseConvertLineInUsers.process(lineReader);
            var usersJson = converterJson.converter(usersConverterJson);
            System.out.print(usersJson);
        } catch (IOException e) {
            System.out.println("500: Server Error.");
        }
    }
}
package br.com.converter.json.main;

import br.com.converter.json.controller.ResponseProcessUser;
import br.com.converter.json.service.*;

import java.io.IOException;

public class Main {
    private static String path = "./src/main/resources/fileTwoLine.txt";
    private static final ReadLineFile readLine = new ReadLineFile();
    private static final ConverterToJson converterJson = new ConverterToJson();
    private static final ExtractDataService extractDate = new ExtractDataService();;
    private static final ProcessingObject processingObjects = new ProcessingObject(extractDate);
    private static final ResponseProcessUser responseConvertLineInUsers = new ResponseProcessUser(processingObjects);
    
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
            System.out.println("404: File not found or in error.");
        }finally {
            System.out.print("End a program");
        }
    }
}
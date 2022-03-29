package br.com.converter.json.main;

import br.com.converter.json.controller.ResponseProcessUser;
import br.com.converter.json.service.*;

import java.io.IOException;

public class Main {
    private static String path = "./src/main/resources/fileTwoLine.txt";
    private static final ReadLineFileService readLine = new ReadLineFileService();
    private static final ConverterToJsonService converterJson = new ConverterToJsonService();
    private static final ExtractDataService extractDate = new ExtractDataService();
    private static final ProcessingObjectService PROCESSING_OBJECTS_SERVICE = new ProcessingObjectService(extractDate);
    private static final ResponseProcessUser responseConvertLineInUsers = new ResponseProcessUser(PROCESSING_OBJECTS_SERVICE);
    
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
            System.out.println("404: File not found or in incorrect path.");
        }finally {
            System.out.print("End a program");
        }
    }
}
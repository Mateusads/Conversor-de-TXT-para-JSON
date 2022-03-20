package br.com.converter.json.main;

import br.com.converter.json.service.CreateObjects;
import br.com.converter.json.service.ExtractDataService;
import br.com.converter.json.service.ReadLineFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            ReadLineFile readLine = new ReadLineFile();
            ExtractDataService extract = new ExtractDataService();
            CreateObjects createObjects = new CreateObjects();
            System.out.println("Start a pragram - JSON CONVERTER - ");

            var line = readLine.readingLineFile("./src/main/resources/fileTwoLine.txt");
            var valuesCreateObjects = extract.extractDataLine(line);
            var user = createObjects.create(valuesCreateObjects);

            System.out.print(user);

        } catch (IOException e) {
            System.out.println("500: Server Error.");
        }
    }
}
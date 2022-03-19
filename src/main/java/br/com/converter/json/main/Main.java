package br.com.converter.json.main;

import br.com.converter.json.service.ReadLineFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try{
            ReadLineFile readLine = new ReadLineFile();
            System.out.println("Start a pragram - JSON CONVERTER - ");
            var line = readLine.readingLineFile("./src/main/resources/fileOneLine.txt");
            System.out.println(line);
        }catch (IOException e){
            System.out.println("500: Server Error.");
        }


    }
}
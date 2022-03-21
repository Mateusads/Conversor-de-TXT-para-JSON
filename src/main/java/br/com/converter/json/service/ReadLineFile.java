package br.com.converter.json.service;

import br.com.converter.json.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ReadLineFile {

    private final ExtractDataService extract = new ExtractDataService();
    private final CreateObjects createObjects = new CreateObjects();
    private final Set<User> response = new HashSet<>();

    public Set<User> readingLineFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            var valuesCreateObjects = extract.extractDataLine(line);
            var user = createObjects.create(valuesCreateObjects);
            response.add(user);
        }
        return response;
    }
}

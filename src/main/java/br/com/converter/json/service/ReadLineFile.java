package br.com.converter.json.service;

import br.com.converter.json.model.Order;
import br.com.converter.json.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReadLineFile {

    private final ProcessingObject processingObject = new ProcessingObject();

    public Set<User> readingLineFile(String path) throws IOException {
        Set<User> users = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            var user = processingObject.processCreateObject(line);
            users.add(user);
        }
        return users;
    }
}

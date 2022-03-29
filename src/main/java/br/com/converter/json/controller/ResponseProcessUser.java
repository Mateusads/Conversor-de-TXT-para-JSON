package br.com.converter.json.controller;

import br.com.converter.json.model.User;
import br.com.converter.json.service.ProcessingObjectService;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class ResponseProcessUser {

    private ProcessingObjectService processingObjectService;

    public Set<User> process(BufferedReader bufferedReader) throws IOException {
        Set<User> users = new HashSet<>();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            var user = processingObjectService.processCreateObject(line);
            users.add(user);
        }
        return users;
    }
}

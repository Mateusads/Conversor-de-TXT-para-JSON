package br.com.converter.json.service;

import br.com.converter.json.model.User;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ConverterToJsonTest {

    private ConverterToJson converterJson = new ConverterToJson();

    @Test
    public void CreateUserForConvertToJsonTest(){

        var user = User.builder().id(1).name("Medeiros").build();
        Set<User> users = new HashSet<>();
        users.add(user);

        var responseJson = converterJson.converter(users);

    }

}
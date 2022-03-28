package br.com.converter.json.service;

import br.com.converter.json.model.User;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterToJsonTest {

    private ConverterToJson converterJson;

    @Before
    public void preparingTestScenario(){
        converterJson = new ConverterToJson();
    }

    @Test
    public void shouldCreateUserConvertToJson(){

        var user = User.builder().id(1).name("Medeiros").build();
        Set<User> users = new HashSet<>();
        users.add(user);

        var responseJson = converterJson.converter(users);

        assertThat(responseJson).isEqualTo("[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Medeiros\",\n" +
                "    \"orders\": []\n" +
                "  }\n" +
                "]");

    }
}
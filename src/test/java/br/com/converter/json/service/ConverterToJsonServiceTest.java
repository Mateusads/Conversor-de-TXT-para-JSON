package br.com.converter.json.service;

import br.com.converter.json.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterToJsonServiceTest {

    private ConverterToJsonService converterJson;

    @BeforeEach
    public void preparingTestScenario(){
        converterJson = new ConverterToJsonService();
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
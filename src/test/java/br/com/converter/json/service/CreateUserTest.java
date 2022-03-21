package br.com.converter.json.service;

import br.com.converter.json.model.User;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserTest {

    @Test
    public void testCreatingUserForBuilder(){
        var user = User.builder()
                        .id(1)
                        .name("Medeiros")
                        .build();

        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getName()).isEqualTo("Medeiros");
    }

}
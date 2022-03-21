package br.com.converter.json.service;

import br.com.converter.json.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUser {

    public User create(int userId, String userName) {
        return User.builder()
                .id(userId)
                .name(userName)
                .build();
    }
}

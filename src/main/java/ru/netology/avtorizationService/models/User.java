package ru.netology.avtorizationService.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 20)
    private String login;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 30)
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

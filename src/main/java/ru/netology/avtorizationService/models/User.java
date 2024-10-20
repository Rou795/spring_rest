package ru.netology.avtorizationService.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User {

    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 20)
    private String user;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 30)
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user1)) return false;
        return Objects.equals(user, user1.user) && Objects.equals(password, user1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

    @Override
    public String toString() {
        return "User: " + user;
    }
}

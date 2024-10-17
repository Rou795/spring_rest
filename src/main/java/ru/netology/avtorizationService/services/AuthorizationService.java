package ru.netology.avtorizationService.services;

import org.springframework.stereotype.Service;
import ru.netology.avtorizationService.exceptions.InvalidCredentials;
import ru.netology.avtorizationService.exceptions.UnauthorizedUser;
import ru.netology.avtorizationService.models.Authorities;
import ru.netology.avtorizationService.repositories.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }
}

package ru.netology.avtorizationService.repositories;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.netology.avtorizationService.models.Authorities;
import ru.netology.avtorizationService.models.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    ConcurrentHashMap<String, String> passwordRepository = new ConcurrentHashMap<>();
    ConcurrentHashMap<User, List<Authorities>> authoritiesRepository = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(User user) {
        return authoritiesRepository.get(user);
    }

    public boolean isAuthorised(String user, String password) {
        return passwordRepository.get(user).equals(password);
    }

    public void putPasswordRepository(String user, String password) {
        passwordRepository.put(user, password);
    }

    public void putAuthoritiesRepository(User user, List<Authorities> authorities) {
        authoritiesRepository.put(user, authorities);
    }
}

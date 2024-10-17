package ru.netology.avtorizationService.repositories;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.netology.avtorizationService.models.Authorities;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    ConcurrentHashMap<String, String> passwordRepository = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, List<Authorities>> authoritiesRepository = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (isAuthorised(user, password)) {
            return authoritiesRepository.get(user);
        } else {
            return null;
        }
    }

    public boolean isAuthorised(String user, String password) {
        return passwordRepository.get(user).equals(password);
    }

    public void putPasswordRepository(String user, String password) {
        passwordRepository.put(user, password);
    }

    public void putAuthoritiesRepository(String user, List<Authorities> authorities) {
        authoritiesRepository.put(user, authorities);
    }
}

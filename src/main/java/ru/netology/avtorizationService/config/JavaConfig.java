package ru.netology.avtorizationService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.netology.avtorizationService.controllers.AuthorizationController;
import ru.netology.avtorizationService.models.Authorities;
import ru.netology.avtorizationService.models.User;
import ru.netology.avtorizationService.repositories.UserRepository;
import ru.netology.avtorizationService.services.AuthorizationService;

import java.util.List;

@Configuration
public class JavaConfig {

//    @Value("${user-repository.testUser:rou}")
//    private String testUser;
//
//    @Value("${user-repository.testPassword:123}")
//    private String testPassword;

    private Authorities testAuthorities = Authorities.READ;

    @Bean
    public UserRepository repository() {
        UserRepository repository = new UserRepository();
        //repository.putPasswordRepository(testUser, testPassword);
        User testUser = new User("rou795", "123456789");
        repository.putAuthoritiesRepository(testUser, List.of(testAuthorities));
        return repository;
    }

    @Bean
    public AuthorizationService service(UserRepository repository) {
        return new AuthorizationService(repository);
    }

}

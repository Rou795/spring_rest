package ru.netology.avtorizationService.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.avtorizationService.exceptions.InvalidCredentials;
import ru.netology.avtorizationService.exceptions.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAuthorizationService {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> ieHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}

package ru.netology.avtorizationService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest
class DemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    private static final GenericContainer<?> devApp = new GenericContainer<>("devapp:latest")
            .withExposedPorts(8080);

    private static final GenericContainer<?> prodApp = new GenericContainer<>("prodapp:latest")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        devApp.start();
        prodApp.start();
    }

    @Test
    void contextLoads() {

        //ввел строку для теста сервиса авторизации
        String testUrlPart = "/authorize?user=rou&password=123456";
        ResponseEntity<String> forEntityDev = restTemplate.getForEntity("http://localhost:" + devApp.getMappedPort(8080), String.class);
        //System.out.println(forEntityDev.getBody());

        ResponseEntity<String> forEntityProd = restTemplate.getForEntity("http://localhost:" + prodApp.getMappedPort(8081), String.class);
        //System.out.println(forEntityProd.getBody());
        Assertions.assertEquals(forEntityProd.getBody(), forEntityProd.getBody());
    }
}
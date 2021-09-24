package br.com.itau.backendchallenge;

import br.com.itau.backendchallenge.controller.PasswordController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PasswordControllerTests {

    @Autowired
    private PasswordController passwordController;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
        assertThat(passwordController).isNotNull();
    }

    @Test
    void actuatorHealth() {
        assertThat(this.restTemplate.getForObject(String.format("http://localhost:%d/actuator/health", port),
                String.class)).contains("{\"status\":\"UP\"}");
    }

    @Test
    void password() {
        assertThat(this.restTemplate.getForObject(String.format("http://localhost:%d/api/password/%s", port, "AbTp9 fok"),
                Boolean.class)).isFalse();

        assertThat(this.restTemplate.getForObject(String.format("http://localhost:%d/api/password/%s", port, "AbTp9!fok"),
                Boolean.class)).isTrue();
    }



}

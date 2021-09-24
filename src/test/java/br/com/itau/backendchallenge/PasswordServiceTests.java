package br.com.itau.backendchallenge;

import br.com.itau.backendchallenge.service.PasswordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PasswordServiceTests {

    @Autowired
    private PasswordService passwordService;

    @Test
    void contextLoads() {
        assertThat(passwordService).isNotNull();
    }

    @Test
    void passwordServiceTest() {
        assertThat(passwordService.isValid("")).isFalse();
        assertThat(passwordService.isValid("aa")).isFalse();
        assertThat(passwordService.isValid("ab")).isFalse();
        assertThat(passwordService.isValid("AAAbbbCc")).isFalse();
        assertThat(passwordService.isValid("AbTp9!foo")).isFalse();
        assertThat(passwordService.isValid("AbTp9!foA")).isFalse();
        assertThat(passwordService.isValid("AbTp9 fok")).isFalse();
        assertThat(passwordService.isValid("AbTp9!fok")).isTrue();
    }

}

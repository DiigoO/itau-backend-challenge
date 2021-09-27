package br.com.itau.backendchallenge;

import br.com.itau.backendchallenge.dto.User;
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

        User user = new User();
        user.setNickname("rodrigo");
        user.setPassword("");
        assertThat(passwordService.validUser(user)).isFalse();
        user.setPassword("aa");
        assertThat(passwordService.validUser(user)).isFalse();
        user.setPassword("ab");
        assertThat(passwordService.validUser(user)).isFalse();
        user.setPassword("AAAbbbCc");
        assertThat(passwordService.validUser(user)).isFalse();
        user.setPassword("AbTp9!foo");
        assertThat(passwordService.validUser(user)).isFalse();
        user.setPassword("AbTp9!foA");
        assertThat(passwordService.validUser(user)).isFalse();
        user.setPassword("AbTp9 fok");
        assertThat(passwordService.validUser(user)).isFalse();
        user.setPassword("AbTp9!fok");
        assertThat(passwordService.validUser(user)).isTrue();
    }

}

package br.com.itau.backendchallenge.service;

import br.com.itau.backendchallenge.dto.User;
import br.com.itau.backendchallenge.util.ValidPasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PasswordService {
    public Boolean validUser(User pass) {
        log.info("The PasswordService was invoked. Method: validUser()");
        return ValidPasswordUtil.isValid(pass.getPassword());
    }
}

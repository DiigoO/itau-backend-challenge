package br.com.itau.backendchallenge.service;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PasswordService {

    public static final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-+])(?=\\S+$).{9,}$";

    public Boolean isValid(String pass) {
        var validRepeatChar = pass.chars()
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .values()
                .stream()
                .anyMatch(i -> i > 1);

        return !validRepeatChar && pass.matches(PATTERN);
    }
}

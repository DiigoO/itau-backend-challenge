package br.com.itau.backendchallenge.util;

import java.util.stream.Collectors;

public class ValidPasswordUtil {

    private ValidPasswordUtil() {}

    public static final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-+])(?=\\S+$).{9,}$";

    public static Boolean isValid(String pass) {
        var validRepeatChar = pass.chars()
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .values()
                .stream()
                .anyMatch(i -> i > 1);

        return !validRepeatChar && pass.matches(PATTERN);
    }
}

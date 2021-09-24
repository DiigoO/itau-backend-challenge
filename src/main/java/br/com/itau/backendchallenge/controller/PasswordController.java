package br.com.itau.backendchallenge.controller;

import br.com.itau.backendchallenge.service.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PasswordController {

    private final PasswordService passwordService;

    @GetMapping("/api/password/{pass}")
    public ResponseEntity<Object> validPassword(@PathVariable("pass") String pass) {
        return new ResponseEntity<>(passwordService.isValid(pass), HttpStatus.OK);
    }

}

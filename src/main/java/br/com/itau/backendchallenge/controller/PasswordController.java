package br.com.itau.backendchallenge.controller;

import br.com.itau.backendchallenge.dto.User;
import br.com.itau.backendchallenge.service.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class PasswordController {

    private final PasswordService passwordService;

    @PostMapping("/api/password")
    public ResponseEntity<Object> validPassword(@RequestBody @Valid User user, @ApiIgnore Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(passwordService.validUser(user), HttpStatus.OK);
        }
    }

}

package br.com.itau.backendchallenge.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User {
    private String nickname;
    @NotBlank
    private String password;
}

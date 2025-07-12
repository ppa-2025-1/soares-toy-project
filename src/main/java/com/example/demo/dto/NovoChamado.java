package com.example.demo.dto;

import com.example.demo.model.entity.User;
import com.example.demo.model.enums.Situacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NovoChamado (
        @NotBlank(message = "A ação é de preenchimento obrigatório")
        String acao,

        @NotBlank(message = "O objeto é de preenchimento obrigatório")
        String objeto,

        @NotBlank(message = "O detalhamento é de preenchimento obrigatório")
        String detalhamento,

        @NotNull(message = "O usuário é de preenchimento obrigatório")
        Integer usuarioId
)  {

}
package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.entity.Profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// CLASSE (RECORD OU STRUCT) QUE NÃO POSSUI LÓGICA DE NEGÓCIO
// E É USADA PARA "CARREGAR" OU "TRANSFERIR" DADOS ENTRE CAMADAS
// É CHAMADO DTO: 
// Data Transfer Object -> Objeto de Transferência de Dados
public record NewUser (
        String name,
        String handle,
        // VALIDAÇÃO É UM CROSS-CUTTING CONCERN
        // validação através de metadados (annotation)
        @NotNull(message = "O e-mail é obrigatório")
        @NotBlank(message = "O e-mail não pode ser vazio")
        String email,
        @NotNull(message = "A senha é obrigatória")
        @NotBlank(message = "A senha não pode ser vazia")
        String password,
        String company,
        Profile.AccountType type,
        List<String> roles
)  {

}

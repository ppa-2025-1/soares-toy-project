package com.example.demo.exceptions;

import com.example.demo.model.enums.Situacao;

public class SituacaoDeChamadoInvalidaException extends RuntimeException {
    public SituacaoDeChamadoInvalidaException(Situacao atual, Situacao proxima) {
        super("Não é possível alterar a situação do chamado de '" + atual + "' para '" + proxima + "'.");
    }
}
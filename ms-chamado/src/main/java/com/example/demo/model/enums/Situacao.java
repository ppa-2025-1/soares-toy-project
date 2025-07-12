package com.example.demo.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Situacao {

    RESOLVIDO,
    CANCELADO,
    ANDAMENTO(CANCELADO, RESOLVIDO),
    NOVO(ANDAMENTO, CANCELADO);

    List<Situacao> possiveisSituacoes;

    Situacao(Situacao... possiveisSituacoes) {
        this.possiveisSituacoes = Arrays.asList(possiveisSituacoes);
    }

    public boolean podeAvancar(Situacao situacao) {
        return this.possiveisSituacoes.contains(situacao);
    }
}

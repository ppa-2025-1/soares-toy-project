package com.example.demo.dto;

import com.example.demo.model.enums.Situacao;

import java.time.LocalDateTime;

public record ChamadoById (
        Integer id,
        LocalDateTime updatedAt,
        LocalDateTime createdAt,
        String acao,
        String objeto,
        String detalhamento,
        Situacao situacao

) {}

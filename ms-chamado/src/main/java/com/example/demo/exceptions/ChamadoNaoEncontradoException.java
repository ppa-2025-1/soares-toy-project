package com.example.demo.exceptions;

public class ChamadoNaoEncontradoException extends RuntimeException {
    public ChamadoNaoEncontradoException(Integer id) {
        super("Chamado com o ID " + id + " não foi encontrado.");
    }
}
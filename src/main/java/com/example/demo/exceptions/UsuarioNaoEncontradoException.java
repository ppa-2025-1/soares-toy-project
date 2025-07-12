package com.example.demo.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(Integer id) {
        super("Usuário com o ID " + id + " não foi encontrado.");
    }

    public UsuarioNaoEncontradoException() {
        super("Usuário não informado.");
    }
}
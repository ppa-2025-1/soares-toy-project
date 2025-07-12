package com.example.demo.model.entity;

import com.example.demo.model.enums.Situacao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "chamados")
public class Chamado extends BaseEntity {
    @Column(nullable = false, unique = true, length = 100)
    private String acao;

    @Column(nullable = false, length = 100)
    private String objeto;

    @Column(nullable = false, length = 500)
    private String detalhamento;

    @Column
    private Situacao situacao;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @PrePersist
    public void atualizaCreated() {
        setCreatedAt(LocalDateTime.now());
        setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void atualizaUpdated() {
        setUpdatedAt(LocalDateTime.now());
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.model.entity.Chamado;

public interface ChamadoRepository extends BaseRepository<Chamado, Integer> {

    Optional<Chamado> findByAcao(String acao);
    // This interface will automatically provide CRUD operations for the Chamado entity
    // You can add custom query methods here if needed

    // Optional<Chamado> findByHandle(String handle);

    // boolean existsByHandle(String handle);
}

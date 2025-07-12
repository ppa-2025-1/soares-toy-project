package com.example.demo.mapper;

import com.example.demo.dto.ChamadoById;
import com.example.demo.dto.NovoChamado;
import com.example.demo.model.entity.Chamado;
import com.example.demo.model.enums.Situacao;

public class ChamadoMapper {

    public static Chamado converte(NovoChamado novoChamado) {
        Chamado chamado = new Chamado();
        chamado.setAcao(novoChamado.acao());
        chamado.setObjeto(novoChamado.objeto());
        chamado.setDetalhamento(novoChamado.detalhamento());
        chamado.setSituacao(Situacao.NOVO);
        return chamado;
    }

    public static ChamadoById converte(Chamado chamado) {
        return new ChamadoById(
                chamado.getId(),
                chamado.getUpdatedAt(),
                chamado.getCreatedAt(),
                chamado.getAcao(),
                chamado.getObjeto(),
                chamado.getDetalhamento(),
                chamado.getSituacao()
        );
    }
}
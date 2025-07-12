package com.example.demo.listener;

import com.example.demo.dto.NovoChamado;
import com.example.demo.model.business.ChamadoBusiness;
import com.example.demo.model.entity.Chamado;
import com.example.demo.model.entity.User;
import com.example.demo.model.enums.Situacao;
import jakarta.persistence.PostPersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class UserListener {

    private ChamadoBusiness chamadoBusiness;

    public UserListener(ChamadoBusiness chamadoBusiness) {
        this.chamadoBusiness = chamadoBusiness;
    }


    public void afterSave(User user) {
        criaChamado(user);
    }

    private void criaChamado(User user) {
        Chamado chamado = new Chamado();
        chamado.setAcao("Criar");
        chamado.setObjeto("E-mail");
        chamado.setDetalhamento("Criar e-mail para novo usuário");
        chamado.setSituacao(Situacao.NOVO);
        chamado.setUser(user);

        chamadoBusiness.criaChamado(chamado, user);
    }
}
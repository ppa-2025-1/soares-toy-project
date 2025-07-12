package com.example.demo.model.business; 

import com.example.dto.ChamadoById;
import com.example.dto.NovoChamado;
import com.example.exception.ChamadoNaoEncontradoException;
import com.example.exception.SituacaoDeChamadoInvalidaException;
import com.example.mapper.ChamadoMapper;
import com.example.entity.Chamado;
import com.example.model.enums.Situacao;
import com.example.repository.ChamadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChamadoBusiness {

    private final ChamadoRepository chamadoRepository;

    public ChamadoBusiness(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    public void criarChamado(NovoChamado novoChamado) {
        Chamado chamado = ChamadoMapper.converte(novoChamado);
        
        chamado.setUserId(novoChamado.usuarioId());
        
        chamadoRepository.save(chamado);
    }

    public List<ChamadoById> getChamados() {
        return chamadoRepository.findAll().stream()
                .map(ChamadoMapper::converte)
                .collect(Collectors.toList());
    }

    public ChamadoById getChamadoById(Integer id) {
        return chamadoRepository.findById(id)
                .map(ChamadoMapper::converte)
                .orElseThrow(() -> new ChamadoNaoEncontradoException(id));
    }

    public void atualizaSituacao(Integer id, Situacao novaSituacao) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new ChamadoNaoEncontradoException(id));

        if (chamado.getSituacao().podeAvancar(novaSituacao)) {
            chamado.setSituacao(novaSituacao);
            chamadoRepository.save(chamado);
        } else {
            throw new SituacaoDeChamadoInvalidaException(chamado.getSituacao(), novaSituacao);
        }
    }
}
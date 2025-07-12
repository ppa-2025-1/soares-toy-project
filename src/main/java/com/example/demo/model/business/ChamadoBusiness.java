package com.example.demo.model.business;

import com.example.demo.dto.ChamadoById;
import com.example.demo.dto.NovoChamado;
import com.example.demo.exceptions.ChamadoNaoEncontradoException;
import com.example.demo.exceptions.SituacaoDeChamadoInvalidaException;
import com.example.demo.exceptions.UsuarioNaoEncontradoException;
import com.example.demo.mapper.ChamadoMapper;
import com.example.demo.model.entity.Chamado;
import com.example.demo.model.entity.User;
import com.example.demo.model.enums.Situacao;
import com.example.demo.repository.ChamadoRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChamadoBusiness {

    private final ChamadoRepository chamadoRepository;
    private final UserRepository userRepository;

    public ChamadoBusiness(ChamadoRepository chamadoRepository, UserRepository userRepository) {
        this.chamadoRepository = chamadoRepository;
        this.userRepository = userRepository;
    }

    public void criarChamado(NovoChamado novoChamado) {
        User user = userRepository.findById(novoChamado.usuarioId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(novoChamado.usuarioId()));
        Chamado chamado = ChamadoMapper.converte(novoChamado);
        chamado.setUser(user);
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
    
    public void criaChamado(Chamado chamado, User user) {
        if(user != null && user.getId() != null) {
            chamado.setUser(user);
            chamadoRepository.save(chamado);
        } else {
            throw new UsuarioNaoEncontradoException();
        }
    }
}
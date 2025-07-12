package com.example.demo.controller;

import com.example.demo.dto.AtualizaSituacao;
import com.example.demo.dto.ChamadoById;
import com.example.demo.dto.NovoChamado;
import com.example.demo.model.business.ChamadoBusiness;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chamados")
public class ChamadoController extends AbstractController {

    private final ChamadoBusiness chamadoBusiness;

    public ChamadoController(ChamadoBusiness chamadoBusiness) {
        this.chamadoBusiness = chamadoBusiness;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criarNovoChamado(@Valid @RequestBody NovoChamado novoChamado) {
        chamadoBusiness.criarChamado(novoChamado);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChamadoById> getChamados() {
        return chamadoBusiness.getChamados();
    }

    @GetMapping(path = "/{idDoChamado}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ChamadoById getChamadoById(@PathVariable Integer idDoChamado) {
        return chamadoBusiness.getChamadoById(idDoChamado);
    }

    @PatchMapping(path = "/{idDoChamado}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void atualizaSituacao(@RequestBody AtualizaSituacao request, @PathVariable Integer idDoChamado) {
        chamadoBusiness.atualizaSituacao(idDoChamado, request.situacao());
    }
}
package com.fiapadj.fase1.controller;

import com.fiapadj.fase1.dominio.Endereco;
import com.fiapadj.fase1.dominio.Pessoas;
import com.fiapadj.fase1.services.PessoaInvalidoException;
import com.fiapadj.fase1.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<?> cadastrarPessoa(@RequestBody Pessoas pessoa) {
        try {
            pessoaService.validarPessoa(pessoa);
            pessoaService.salvarPessoa(pessoa);
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
        }
        catch (PessoaInvalidoException p){
            return ResponseEntity.badRequest().body(p.getMessage());

        }
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<Pessoas> consultarPessoaPorId(@PathVariable Integer idPessoa) {
        Pessoas pessoa = pessoaService.buscarPessoaPorId(idPessoa);
        if (pessoa != null) {
            return ResponseEntity.ok().body(pessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

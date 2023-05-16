package com.fiapadj.fase1.controller;

import com.fiapadj.fase1.dominio.Endereco;
import com.fiapadj.fase1.services.EnderecoInvalidoException;
import com.fiapadj.fase1.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<?> cadastrarEndereco(@RequestBody Endereco endereco) {
        try {
            enderecoService.validarEndereco(endereco);
            enderecoService.salvarEndereco(endereco);
            return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
        } catch (EnderecoInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/{idEndereco}")
    public ResponseEntity<Endereco> consultarEnderecoPorId(@PathVariable Integer idEndereco) {
        Endereco endereco = enderecoService.buscarEnderecoPorId(idEndereco);
            if (endereco != null) {
                return ResponseEntity.ok().body(endereco);
            } else {
                return ResponseEntity.notFound().build();
            }
    }
}



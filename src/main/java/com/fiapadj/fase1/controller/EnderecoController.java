package com.fiapadj.fase1.controller;

import com.fiapadj.fase1.controller.form.EnderecoForm;
import com.fiapadj.fase1.dominio.Endereco;
import com.fiapadj.fase1.services.EnderecoInvalidoException;
import com.fiapadj.fase1.services.EnderecoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<?> cadastrarEndereco(@RequestBody @Valid EnderecoForm enderecoForm) {
        try {
            Endereco endereco = enderecoForm.toEndereco();
            enderecoService.salvarEndereco(endereco);

            return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
        } catch (EnderecoInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{idEndereco}")
    public ResponseEntity<EnderecoForm> consultarEnderecoPorId(@PathVariable Integer idEndereco) {
        EnderecoForm endereco = enderecoService.buscarEnderecoPorId(idEndereco);

        if (endereco != null) {
            return ResponseEntity.ok().body(endereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

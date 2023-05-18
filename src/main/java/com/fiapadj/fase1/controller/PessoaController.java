package com.fiapadj.fase1.controller;

import com.fiapadj.fase1.controller.form.PessoasForm;
import com.fiapadj.fase1.dominio.Pessoas;
import com.fiapadj.fase1.services.PessoaService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @PostMapping
    public ResponseEntity<?> cadastrarPessoa(@RequestBody PessoasForm pessoasForm) {

        Set<ConstraintViolation<PessoasForm>> violacoes = Validation.buildDefaultValidatorFactory().getValidator().validate(pessoasForm);
        Map<Path,String> violacoesToMap = violacoes.stream().collect(Collectors.toMap(violacao -> violacao.getPropertyPath(), violacao -> violacao.getMessage()));

        if(!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }

        Pessoas pessoa = pessoasForm.toPessoa();
        pessoaService.salvarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);

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

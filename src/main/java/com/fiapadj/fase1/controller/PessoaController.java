package com.fiapadj.fase1.controller;

import com.fiapadj.fase1.controller.form.PessoasForm;
import com.fiapadj.fase1.dominio.Pessoas;
import com.fiapadj.fase1.services.PessoaInvalidoException;
import com.fiapadj.fase1.services.PessoaService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<?> cadastrarPessoa(@RequestBody @Valid PessoasForm pessoasForm) {
        try {
            Set<ConstraintViolation<PessoasForm>> violacoes = Validation
                    .buildDefaultValidatorFactory().getValidator().validate(pessoasForm);
            Map<Path, String> violacoesToMap = violacoes.stream()
                    .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));

            if (!violacoesToMap.isEmpty()) {
                return ResponseEntity.badRequest().body(violacoesToMap);
            }

            
            Pessoas pessoa = new Pessoas(pessoasForm);
            pessoaService.salvarPessoa(pessoa);

            return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
        } catch (PessoaInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{idPessoa}")
    public ResponseEntity<PessoasForm> consultarPessoaPorId(@PathVariable Integer idPessoa) {
        PessoasForm pessoa = pessoaService.buscarPessoaPorId(idPessoa);

        if (pessoa != null) {
            return ResponseEntity.ok().body(pessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

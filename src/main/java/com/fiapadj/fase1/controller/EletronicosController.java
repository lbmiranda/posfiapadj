package com.fiapadj.fase1.controller;

import com.fiapadj.fase1.controller.form.EletronicosForm;
import com.fiapadj.fase1.dominio.Eletronicos;
import com.fiapadj.fase1.services.EletronicosInvalidoException;
import com.fiapadj.fase1.services.EletronicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/eletronicos")
public class EletronicosController {

    @Autowired
    private EletronicosService eletronicosService;

    @PostMapping
    public ResponseEntity<?> cadastrarEletronico(@RequestBody EletronicosForm eletronicoForm) {
            Eletronicos eletronico = eletronicoForm.toEletronicos();
            try {
                eletronicosService.validarEletronicos(eletronico);
                eletronicosService.salvarEletronico(eletronico);
                return ResponseEntity.status(HttpStatus.CREATED).body(eletronico);
            } catch (EletronicosInvalidoException e){
                return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{idEletronico}")
    public ResponseEntity<Eletronicos> consultarEletronicoPorId (@PathVariable Integer idEletronico) {
        Eletronicos eletronico = eletronicosService.buscarEletronicoPorId(idEletronico);
        if (eletronico != null) {
            return ResponseEntity.ok().body(eletronico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

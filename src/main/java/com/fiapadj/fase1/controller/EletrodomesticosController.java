package com.fiapadj.fase1.controller;

import com.fiapadj.fase1.controller.form.EletrodomesticosForm;
import com.fiapadj.fase1.dominio.Eletrodomesticos;
import com.fiapadj.fase1.services.EletrodomesticosInvalidoException;
import com.fiapadj.fase1.services.EletrodomesticosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("eletrodomesticos")
@RequiredArgsConstructor
public class EletrodomesticosController {

    private final EletrodomesticosService eletrodomesticosService;

    @PostMapping
    public ResponseEntity<?> cadastrarEletrodomestico(@RequestBody EletrodomesticosForm eletrodomesticoForm) {
        try {
            Eletrodomesticos eletrodomestico = eletrodomesticoForm.toEletrodomestico();
            eletrodomesticosService.salvarEletrodomestico(eletrodomestico);

            return ResponseEntity.status(HttpStatus.CREATED).body(eletrodomestico);
        } catch (EletrodomesticosInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{idEletrodomestico}")
    public ResponseEntity<Eletrodomesticos> consultarEletronicoPorId(@PathVariable Integer idEletrodomestico) {
        Eletrodomesticos eletrodomestico = eletrodomesticosService.consultarEletrodomesticoPorId(idEletrodomestico);

        if (eletrodomestico != null) {
            return ResponseEntity.ok().body(eletrodomestico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

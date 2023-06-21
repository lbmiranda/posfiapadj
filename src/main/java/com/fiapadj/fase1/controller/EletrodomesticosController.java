package com.fiapadj.fase1.controller;

import com.fiapadj.fase1.controller.form.EletrodomesticosForm;
import com.fiapadj.fase1.dominio.Eletrodomesticos;
import com.fiapadj.fase1.services.EletrodomesticosInvalidoException;
import com.fiapadj.fase1.services.EletrodomesticosService;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> cadastrarEletrodomestico(@RequestBody @Valid EletrodomesticosForm eletrodomesticoForm) {
        try {
            Eletrodomesticos eletrodomestico = eletrodomesticoForm.toEletrodomestico();
            
            eletrodomesticosService.salvarEletrodomestico(eletrodomestico);

            return ResponseEntity.status(HttpStatus.CREATED).body(eletrodomestico);
        } catch (EletrodomesticosInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{idEletrodomestico}")
    public ResponseEntity<EletrodomesticosForm> consultarEletronicoPorId(@PathVariable Integer idEletrodomestico) {
        EletrodomesticosForm eletrodomestico = eletrodomesticosService.consultarEletrodomesticoPorId(idEletrodomestico);

        return ResponseEntity.ok(eletrodomestico);
    }
}

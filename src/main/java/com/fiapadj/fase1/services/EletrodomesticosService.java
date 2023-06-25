package com.fiapadj.fase1.services;

import com.fiapadj.fase1.controller.form.EletrodomesticosForm;
import com.fiapadj.fase1.dominio.Eletrodomesticos;
import com.fiapadj.fase1.repository.EletrodomesticosRepositorio;
import com.fiapadj.fase1.services.exception.ControllerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class EletrodomesticosService {

    private final EletrodomesticosRepositorio repositorio;

    public void salvarEletrodomestico(Eletrodomesticos eletrodomestico) {
        
        Set<Eletrodomesticos> eletrodomesticos = repositorio.listarEletrodomesticos();

        eletrodomestico.setIdEletrodomestico(eletrodomesticos.size());
        eletrodomesticos.add(eletrodomestico);
    }

    public EletrodomesticosForm consultarEletrodomesticoPorId(Integer idEletrodomestico) {
        Set<Eletrodomesticos> eletrodomesticos = repositorio.listarEletrodomesticos();

        return eletrodomesticos.stream()
                .filter(eletrodomestico -> eletrodomestico.getIdEletrodomestico().equals(idEletrodomestico))
                .map(EletrodomesticosForm::new)
                .findFirst()
                .orElseThrow(() -> new ControllerNotFoundException("Eletrodoméstico não encontrado"));
    }
}

package com.fiapadj.fase1.services;

import com.fiapadj.fase1.dominio.Eletrodomesticos;
import com.fiapadj.fase1.repository.EletrodomesticosRepositorio;
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

    public Eletrodomesticos consultarEletrodomesticoPorId(Integer idEletrodomestico) {
        Set<Eletrodomesticos> eletrodomesticos = repositorio.listarEletrodomesticos();

        return eletrodomesticos.stream()
                .filter(eletrodomestico -> eletrodomestico.getIdEletrodomestico().equals(idEletrodomestico))
                .findFirst()
                .orElse(null);
    }
}

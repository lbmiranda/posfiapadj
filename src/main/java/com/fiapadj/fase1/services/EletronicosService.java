package com.fiapadj.fase1.services;


import com.fiapadj.fase1.dominio.Eletronicos;
import com.fiapadj.fase1.repository.EletronicosRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class EletronicosService {

    private final EletronicosRepositorio repositorio;

    public void salvarEletronico(Eletronicos eletronico) {
        Set<Eletronicos> eletronicos = repositorio.listarEletronicos();

        eletronico.setIdEletronico(eletronicos.size());
        eletronicos.add(eletronico);
    }

    public Eletronicos buscarEletronicoPorId(Integer idEletronico) {
        Set<Eletronicos> eletronicos = repositorio.listarEletronicos();

        return eletronicos.stream()
                .filter(eletronico -> eletronico.getIdEletronico().equals(idEletronico))
                .findFirst()
                .orElse(null);
    }
}

package com.fiapadj.fase1.repository;

import com.fiapadj.fase1.dominio.Eletronicos;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class EletronicosRepositorio {

    private final Set<Eletronicos> eletronicos = new HashSet<>();

    public Set<Eletronicos> listarEletronicos() {
        return eletronicos;
    }
}

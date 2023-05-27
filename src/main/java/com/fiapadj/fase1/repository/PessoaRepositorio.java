package com.fiapadj.fase1.repository;

import com.fiapadj.fase1.dominio.Pessoas;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class PessoaRepositorio {

    private final Set<Pessoas> pessoas = new HashSet<>();

    public Set<Pessoas> listarPessoas() {
        return pessoas;
    }
}

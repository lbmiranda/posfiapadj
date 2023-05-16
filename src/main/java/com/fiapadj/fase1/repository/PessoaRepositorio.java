package com.fiapadj.fase1.repository;

import com.fiapadj.fase1.dominio.Pessoas;

import java.util.HashSet;
import java.util.Set;

public class PessoaRepositorio {

    private Set<Pessoas> pessoas = new HashSet<>();

    public Set<Pessoas> listarPessoas() {
        return pessoas;
    }

}

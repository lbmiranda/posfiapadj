package com.fiapadj.fase1.repository;

import com.fiapadj.fase1.dominio.Endereco;

import java.util.HashSet;
import java.util.Set;

public class EnderecoRepositorio {
    private Set<Endereco> enderecos = new HashSet<>();

    public Set<Endereco> listarEnderecos() {
        return enderecos;
    }
}



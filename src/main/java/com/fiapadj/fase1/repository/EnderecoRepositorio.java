package com.fiapadj.fase1.repository;

import com.fiapadj.fase1.dominio.Endereco;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class EnderecoRepositorio {

    private final Set<Endereco> enderecos = new HashSet<>();

    public Set<Endereco> listarEnderecos() {
        return enderecos;
    }
}

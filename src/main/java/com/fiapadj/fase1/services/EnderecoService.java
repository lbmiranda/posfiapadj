package com.fiapadj.fase1.services;

import com.fiapadj.fase1.dominio.Endereco;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EnderecoService {

    public void validarEndereco(Endereco endereco) throws EnderecoInvalidoException {
        if (endereco.getRua() == null || endereco.getRua().isEmpty()) {
            throw new EnderecoInvalidoException("Rua é obrigatório");
        }
        if (endereco.getNumero() == null) {
            throw new EnderecoInvalidoException("Número é obrigatório");
        }
        if (endereco.getBairro() == null || endereco.getBairro().isEmpty()) {
            throw new EnderecoInvalidoException("Bairro é obrigatório");
        }
        if (endereco.getCidade() == null || endereco.getCidade().isEmpty()) {
            throw new EnderecoInvalidoException("Cidade é obrigatório");
        }
        if (endereco.getEstado() == null || endereco.getEstado().isEmpty()) {
            throw new EnderecoInvalidoException("Estado é obrigatório");
        }
    }

    private Set<Endereco> enderecos = new HashSet<>();

    public void salvarEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }

    public Set<Endereco> listarEnderecos() {
        return enderecos;
    }
}
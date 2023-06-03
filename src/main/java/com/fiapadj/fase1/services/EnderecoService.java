package com.fiapadj.fase1.services;

import com.fiapadj.fase1.controller.form.EnderecoForm;
import com.fiapadj.fase1.dominio.Endereco;
import com.fiapadj.fase1.repository.EnderecoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepositorio repositorio;

    public void salvarEndereco(Endereco endereco) {
        Set<Endereco> enderecos = repositorio.listarEnderecos();

        endereco.setIdEndereco(enderecos.size());
        enderecos.add(endereco);
    }

    public EnderecoForm buscarEnderecoPorId(Integer idEndereco) {
        Set<Endereco> enderecos = repositorio.listarEnderecos();

        return enderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .map(EnderecoForm::new)
                .findFirst()
                .orElse(null);
    }
}

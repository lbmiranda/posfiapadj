package com.fiapadj.fase1.services;

import com.fiapadj.fase1.controller.form.PessoasForm;
import com.fiapadj.fase1.dominio.Pessoas;
import com.fiapadj.fase1.repository.PessoaRepositorio;
import com.fiapadj.fase1.services.exception.ControllerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepositorio repositorio;

    public void salvarPessoa(Pessoas pessoa) {
        Set<Pessoas> pessoas = repositorio.listarPessoas();

        pessoa.setIdPessoa(pessoas.size());
        pessoas.add(pessoa);
    }

    public PessoasForm buscarPessoaPorId(Integer idPessoa) {
        Set<Pessoas> pessoas = repositorio.listarPessoas();

        return pessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .map(PessoasForm::new)
                .findFirst().orElseThrow(() -> new ControllerNotFoundException("Pessoa não encontrada"));
    }
}

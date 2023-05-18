package com.fiapadj.fase1.services;

import com.fiapadj.fase1.dominio.Pessoas;
import com.fiapadj.fase1.repository.PessoaRepositorio;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PessoaService {

    PessoaRepositorio repositorio = new PessoaRepositorio();
    Set<Pessoas> pessoas = repositorio.listarPessoas();

    public void salvarPessoa(Pessoas pessoa) {

        pessoa.setIdPessoa(pessoas.size());
        pessoas.add(pessoa);

    }

    public Pessoas buscarPessoaPorId(Integer idPessoa) {
        for (Pessoas pessoa : pessoas) {
            if (pessoa.getIdPessoa().equals(idPessoa)) {
                return pessoa;
            }
        }
        return null;
    }

}

package com.fiapadj.fase1.services;

import com.fiapadj.fase1.dominio.Endereco;
import com.fiapadj.fase1.dominio.Pessoas;
import com.fiapadj.fase1.repository.EnderecoRepositorio;
import com.fiapadj.fase1.repository.PessoaRepositorio;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PessoaService {

    public void validarPessoa(Pessoas pessoa) throws PessoaInvalidoException {
        if (pessoa.getDataNascimento() == null) {
            throw new PessoaInvalidoException("Data de nascimento é obrigatória");
        }
        if (pessoa.getNome() == null || pessoa.getNome().isEmpty()){
            throw new PessoaInvalidoException("Nome é obrigatório");
        }
        if (pessoa.getIdade() == null) {
            throw new PessoaInvalidoException("Idade é obrigatória");
        }
        if (pessoa.getParentesco() == null) {
            throw new PessoaInvalidoException("Parentesco é obrigatório");
        }
        if (pessoa.getSexo() == null) {
            throw new PessoaInvalidoException("Campo sexo é obrigatório");
        }
    }

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

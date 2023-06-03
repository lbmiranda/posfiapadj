package com.fiapadj.fase1.dominio;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import com.fiapadj.fase1.controller.form.PessoasForm;

@Getter
@Setter
@EqualsAndHashCode(of = { "idPessoa" })
public class Pessoas {

    private String nome;
    private Date dataNascimento;
    private Sexo sexo;
    private Parentesco parentesco;
    private Integer idade;
    private Integer idPessoa;

    public Pessoas(PessoasForm dados) {
        this.nome = dados.getNome();
        this.dataNascimento = dados.getDataNascimento();
        this.sexo = dados.getSexo();
        this.parentesco = dados.getParentesco();
        this.idade = dados.getIdade();
    }

    public enum Parentesco {
        PAI, MAE, FILHO, FILHA, IRMÃO, IRMÃ, AVÓS, TIO, TIA, PRIMO, PRIMA, SOBRINHO, SOBRINHA, OUTRO
    }

    public enum Sexo {
        MASCULINO, FEMININO, NAO_BINARIE
    }
}

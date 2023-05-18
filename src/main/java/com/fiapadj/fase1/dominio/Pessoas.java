package com.fiapadj.fase1.dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Pessoas {

    private String nome;
    private Date dataNascimento;
    private Sexo sexo;
    private Parentesco parentesco;
    private Integer idade;
    private Integer idPessoa;

    public Pessoas(String nome, Date dataNascimento, Sexo sexo, Parentesco parentesco, Integer idade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
        this.idade = idade;
    }

    public enum Parentesco {
        PAI,
        MAE,
        FILHO,
        FILHA,
        IRMÃO,
        IRMÃ,
        AVÓS,
        TIO,
        TIA,
        PRIMO,
        PRIMA,
        SOBRINHO,
        SOBRINHA,
        OUTRO
    }

    public enum Sexo {
        MASCULINO,
        FEMININO,
        NAO_BINARIE
    }
}



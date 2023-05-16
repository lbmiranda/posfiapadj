package com.fiapadj.fase1.dominio;

import java.util.Date;

public class Pessoas {

    private String nome;
    private Date dataNascimento;
    private Sexo sexo;
    private Parentesco parentesco;
    private Integer idade;
    private Integer idPessoa;

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

    public String getNome() {return nome;}
    public Date getDataNascimento(){return dataNascimento;}
    public Sexo getSexo(){return sexo;}
    public Parentesco getParentesco(){return parentesco;}
    public Integer getIdade(){return idade;}
    public Integer getIdPessoa(){return idPessoa;}


    public Integer setIdPessoa(Integer idPessoa){return this.idPessoa = idPessoa;}
}



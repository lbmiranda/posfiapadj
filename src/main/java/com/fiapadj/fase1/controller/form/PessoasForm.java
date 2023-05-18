package com.fiapadj.fase1.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Endereco;
import com.fiapadj.fase1.dominio.Pessoas;

import java.util.Date;

public class PessoasForm {

    @JsonProperty
    private String nome;
    @JsonProperty
    private Date dataNascimento;
    @JsonProperty
    private Pessoas.Sexo sexo;
    @JsonProperty
    private Pessoas.Parentesco parentesco;
    @JsonProperty
    private Integer idade;

    public Pessoas toPessoa() {
        return new Pessoas(nome,dataNascimento,sexo,parentesco,idade);
    }


}

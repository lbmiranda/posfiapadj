package com.fiapadj.fase1.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Pessoas;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class PessoasForm {

    @JsonProperty
    @NotNull(message = "Nome é obrigatório")
    private String nome;
    @JsonProperty
    @NotNull(message = "Data de nascimento é obrigatória")
    private Date dataNascimento;
    @JsonProperty
    @NotNull(message = "Campo 'sexo' é obrigatório")
    private Pessoas.Sexo sexo;
    @JsonProperty
    @NotNull(message = "Parentesco é obrigatório")
    private Pessoas.Parentesco parentesco;
    @JsonProperty
    @NotNull(message = "Idade é obrigatório")
    private Integer idade;

    public Pessoas toPessoa() {
        return new Pessoas(nome,dataNascimento,sexo,parentesco,idade);
    }


}

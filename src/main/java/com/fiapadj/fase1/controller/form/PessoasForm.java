package com.fiapadj.fase1.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Parentesco;
import com.fiapadj.fase1.dominio.Pessoas;
import com.fiapadj.fase1.dominio.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;

import java.util.Date;

@Getter
public class PessoasForm {

    @JsonProperty
    @NotBlank(message = "{nome.obrigatorio}")
    private String nome;
    @JsonProperty
    @NotNull
    @PastOrPresent(message = "{dataNascimento.obrigatorio}")
    private Date dataNascimento;
    @JsonProperty
    @NotNull(message = "{sexo.obrigatorio}")
    private Sexo sexo;
    @JsonProperty
    @NotNull(message = "{parentesco.obrigatorio}")
    private Parentesco parentesco;
    @JsonProperty
    @NotNull(message = "{idade.obrigatorio}")
    private Integer idade;

    public PessoasForm(Pessoas pessoa) {
        this(pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getSexo(), pessoa.getParentesco(), pessoa.getIdade());
    }

    public PessoasForm(String nome, Date dataNascimento, Sexo sexo, Parentesco parentesco, Integer idade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.parentesco = parentesco;
        this.idade = idade;
    }
}

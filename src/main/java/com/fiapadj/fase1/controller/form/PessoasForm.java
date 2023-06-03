package com.fiapadj.fase1.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Pessoas;
import com.fiapadj.fase1.dominio.Pessoas.Parentesco;
import com.fiapadj.fase1.dominio.Pessoas.Sexo;

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

    // public Pessoas toPessoa() {
    //     // Pessoas.Sexo sexoEnum = verificarSexo(this.sexo);
    //     // Pessoas.Parentesco parentescoEnum = verificarParentesco(this.parentesco);

    //     // return new Pessoas(nome, dataNascimento, sexoEnum, parentescoEnum, idade);
    //     return new Pessoas(nome, dataNascimento, sexo, parentesco, idade);
    // }

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

    // private Pessoas.Sexo verificarSexo(String valor) {
    //     try {
    //         return Pessoas.Sexo.valueOf(valor.toUpperCase());
    //     } catch (IllegalArgumentException e) {
    //         throw new PessoaInvalidoException("Sexo inválido: " + valor);
    //     }
    // }

    // private Pessoas.Parentesco verificarParentesco(String valor) {
    //     try {
    //         return Pessoas.Parentesco.valueOf(valor.toUpperCase());
    //     } catch (IllegalArgumentException e) {
    //         throw new PessoaInvalidoException("Parentesco inválido: " + valor);
    //     }
    // }
}

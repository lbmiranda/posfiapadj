package com.fiapadj.fase1.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Pessoas;
import com.fiapadj.fase1.services.PessoaInvalidoException;
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
    private String sexo;
    @JsonProperty
    @NotNull(message = "Parentesco é obrigatório")
    private String parentesco;
    @JsonProperty
    @NotNull(message = "Idade é obrigatório")
    private Integer idade;

    public Pessoas toPessoa() {
        Pessoas.Sexo sexoEnum = verificarSexo(this.sexo);
        Pessoas.Parentesco parentescoEnum = verificarParentesco(this.parentesco);

        return new Pessoas(nome, dataNascimento, sexoEnum, parentescoEnum, idade);
    }

    private Pessoas.Sexo verificarSexo(String valor) {
        try {
            return Pessoas.Sexo.valueOf(valor.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new PessoaInvalidoException("Sexo inválido: " + valor);
        }
    }

    private Pessoas.Parentesco verificarParentesco(String valor) {
        try {
            return Pessoas.Parentesco.valueOf(valor.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new PessoaInvalidoException("Parentesco inválido: " + valor);
        }
    }
}

package com.fiapadj.fase1.controller.form;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Endereco;
import com.fiapadj.fase1.services.EnderecoInvalidoException;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoForm {

    @JsonProperty
    @NotBlank (message = "{rua.obrigatorio}")
    private String rua;
    @JsonProperty
    @NotNull (message = "{numero.obrigatorio}")
    private Integer numero;
    @JsonProperty
    @NotBlank (message = "{bairro.obrigatorio}")
    private String bairro;
    @JsonProperty
    @NotBlank (message = "{cidade.obrigatorio}")
    private String cidade;
    @NotBlank (message = "{estado.obrigatorio}")
    @JsonProperty
    private String estado;

    public Endereco toEndereco() {
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
        validarEndereco(endereco);

        return endereco;
    }

    public EnderecoForm(Endereco endereco) {
        this(endereco.getRua(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado());
    }

    public EnderecoForm(String rua, Integer numero, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    private void validarEndereco(Endereco endereco) throws EnderecoInvalidoException {
        if (endereco.getRua() == null || endereco.getRua().isEmpty()) {
            throw new EnderecoInvalidoException("Rua é obrigatório");
        }
        if (endereco.getNumero() == null) {
            throw new EnderecoInvalidoException("Número é obrigatório");
        }
        if (endereco.getBairro() == null || endereco.getBairro().isEmpty()) {
            throw new EnderecoInvalidoException("Bairro é obrigatório");
        }
        if (endereco.getCidade() == null || endereco.getCidade().isEmpty()) {
            throw new EnderecoInvalidoException("Cidade é obrigatório");
        }
        if (endereco.getEstado() == null || endereco.getEstado().isEmpty()) {
            throw new EnderecoInvalidoException("Estado é obrigatório");
        }
    }
}

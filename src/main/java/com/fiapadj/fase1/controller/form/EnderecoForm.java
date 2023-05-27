package com.fiapadj.fase1.controller.form;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Endereco;
import com.fiapadj.fase1.services.EnderecoInvalidoException;

public class EnderecoForm {

    @JsonProperty
    private String rua;
    @JsonProperty
    private Integer numero;
    @JsonProperty
    private String bairro;
    @JsonProperty
    private String cidade;
    @JsonProperty
    private String estado;

    public Endereco toEndereco() {
        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
        validarEndereco(endereco);

        return endereco;
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

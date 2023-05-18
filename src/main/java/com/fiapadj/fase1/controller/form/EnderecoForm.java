package com.fiapadj.fase1.controller.form;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Endereco;


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
        return new Endereco(rua,numero,bairro,cidade,estado);
    }
}

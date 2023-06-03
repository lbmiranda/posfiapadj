package com.fiapadj.fase1.dominio;

import lombok.EqualsAndHashCode;
@EqualsAndHashCode(of = {"idEndereco"})
public class Endereco {

    private final String rua;
    private final Integer numero;
    private final String bairro;
    private final String cidade;
    private final String estado;
    private Integer idEndereco;

    public Endereco(String rua, Integer numero, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    
}

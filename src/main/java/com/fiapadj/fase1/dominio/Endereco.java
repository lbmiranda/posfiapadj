package com.fiapadj.fase1.dominio;



public class Endereco {

    private Integer idEndereco;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Integer getIdEndereco() { return idEndereco; }
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

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
}


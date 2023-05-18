package com.fiapadj.fase1.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eletronicos {

    private String nome;
    private String modelo;
    private String marca;
    private Tensao tensao;
    private Integer potencia;

    public enum Tensao {
        _110v,
        _220v
    }

    public Eletronicos (String nome, String modelo, String marca, Tensao tensao, Integer potencia) {
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.tensao = tensao;
        this.potencia = potencia;
    }

}

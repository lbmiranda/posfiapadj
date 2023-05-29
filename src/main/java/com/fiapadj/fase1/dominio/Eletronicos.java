package com.fiapadj.fase1.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eletronicos {

    private Integer idEletronico;
    private String nome;
    private String modelo;
    private String marca;
    private Tensao tensao;
    private Integer potencia;

    public Eletronicos(String nome, String modelo, String marca, Tensao tensao, Integer potencia) {
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.tensao = tensao;
        this.potencia = potencia;
    }

    public enum Tensao {
        _110v("110v"), _220v("220v");

        private final String value;

        Tensao(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}

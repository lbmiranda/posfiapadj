package com.fiapadj.fase1.dominio;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"idEletrodomestico"})
public class Eletrodomesticos {

    private Integer idEletrodomestico;
    private String nome;
    private String modelo;
    private String marca;
    private Tensao tensao;
    private Integer potencia;

    public Eletrodomesticos(String nome, String modelo, String marca, Tensao tensao, Integer potencia) {
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

package com.fiapadj.fase1.dominio;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}

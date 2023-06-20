package com.fiapadj.fase1.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Eletrodomesticos;
import com.fiapadj.fase1.dominio.Tensao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EletrodomesticosForm {

    @JsonProperty
    @NotBlank(message = "{nome.obrigatorio}")
    private String nome;
    @JsonProperty
    @NotBlank(message = "{modelo.obrigatorio}")
    private String modelo;
    @JsonProperty
    @NotBlank(message = "{marca.obrigatorio}")
    private String marca;
    @JsonProperty
    @NotNull(message = "tensao.obrigatorio")
    private Tensao tensao;
    @JsonProperty
    @NotNull(message = "{potencia.obrigatorio}")
    private Integer potencia;

    public Eletrodomesticos toEletrodomestico() {
        return new Eletrodomesticos(nome, modelo, marca, tensao, potencia);
    }

    public EletrodomesticosForm(String nome, String modelo, String marca, Tensao tensao, Integer potencia) {
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.tensao = tensao;
        this.potencia = potencia;
    }

    public EletrodomesticosForm(Eletrodomesticos eletrodomesticos) {
        this(eletrodomesticos.getNome(), eletrodomesticos.getModelo(), eletrodomesticos.getMarca(),
                eletrodomesticos.getTensao(), eletrodomesticos.getPotencia());
    }

}

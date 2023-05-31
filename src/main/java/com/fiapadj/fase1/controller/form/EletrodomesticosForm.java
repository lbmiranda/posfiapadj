package com.fiapadj.fase1.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Eletrodomesticos;
import com.fiapadj.fase1.services.EletrodomesticosInvalidoException;

public class EletrodomesticosForm {

    @JsonProperty
    private String nome;
    @JsonProperty
    private String modelo;
    @JsonProperty
    private String marca;
    @JsonProperty
    private String tensao;
    @JsonProperty
    private Integer potencia;

    public Eletrodomesticos toEletrodomestico() {
        Eletrodomesticos.Tensao tensaoEnum = verificarTensao(this.tensao);
        Eletrodomesticos eletrodomesticos = new Eletrodomesticos(nome, modelo, marca, tensaoEnum, potencia);
        validarEletrodomestico(eletrodomesticos);

        return eletrodomesticos;
    }

    private void validarEletrodomestico(Eletrodomesticos eletrodomestico) throws EletrodomesticosInvalidoException {
        if (eletrodomestico.getNome() == null || eletrodomestico.getNome().isEmpty()) {
            throw new EletrodomesticosInvalidoException("Nome é obrigatório");
        }
        if (eletrodomestico.getModelo() == null || eletrodomestico.getModelo().isEmpty()) {
            throw new EletrodomesticosInvalidoException("Modelo é obrigatório");
        }
        if (eletrodomestico.getMarca() == null || eletrodomestico.getMarca().isEmpty()) {
            throw new EletrodomesticosInvalidoException("Marca é obrigatória");
        }
        if (eletrodomestico.getPotencia() == null) {
            throw new EletrodomesticosInvalidoException("Potência é obrigatória");
        }
    }

    private Eletrodomesticos.Tensao verificarTensao(String valor) {
        if (valor == null) {
            throw new EletrodomesticosInvalidoException("Tensão é obrigatória e aceita apenas os valores _110v ou _220v");
        }
        try {
            return Eletrodomesticos.Tensao.valueOf(valor);
        } catch (IllegalArgumentException e) {
            throw new EletrodomesticosInvalidoException("Tensão inválida: " + valor);
        }
    }
}

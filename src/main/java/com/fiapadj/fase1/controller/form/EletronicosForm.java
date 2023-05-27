package com.fiapadj.fase1.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Eletronicos;
import com.fiapadj.fase1.services.EletronicosInvalidoException;

public class EletronicosForm {

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

    public Eletronicos toEletronicos() {
        Eletronicos.Tensao tensaoEnum = verificarTensao(this.tensao);
        Eletronicos eletronicos = new Eletronicos(nome, modelo, marca, tensaoEnum, potencia);
        validarEletronicos(eletronicos);

        return eletronicos;
    }

    private void validarEletronicos(Eletronicos eletronico) throws EletronicosInvalidoException {
        if (eletronico.getNome() == null || eletronico.getNome().isEmpty()) {
            throw new EletronicosInvalidoException("Nome é obrigatório");
        }
        if (eletronico.getModelo() == null || eletronico.getModelo().isEmpty()) {
            throw new EletronicosInvalidoException("Modelo é obrigatório");
        }
        if (eletronico.getMarca() == null || eletronico.getMarca().isEmpty()) {
            throw new EletronicosInvalidoException("Marca é obrigatória");
        }
        if (eletronico.getTensao() == null) {
            throw new EletronicosInvalidoException("Tensão é obrigatória e aceita apenas os valores _110v ou _220v");
        }
        if (eletronico.getPotencia() == null) {
            throw new EletronicosInvalidoException("Potência é obrigatória");
        }
    }

    private Eletronicos.Tensao verificarTensao(String valor) {
        if (valor == null) {
            throw new EletronicosInvalidoException("Tensão é obrigatória");
        }
        try {
            return Eletronicos.Tensao.valueOf(valor.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new EletronicosInvalidoException("Tensão inválida: " + valor);
        }
    }
}


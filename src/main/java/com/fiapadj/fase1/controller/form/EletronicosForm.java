package com.fiapadj.fase1.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiapadj.fase1.dominio.Eletronicos;

public class EletronicosForm {

        @JsonProperty
        private String nome;
        @JsonProperty
        private String modelo;
        @JsonProperty
        private String marca;
        @JsonProperty
        private Eletronicos.Tensao tensao;
        @JsonProperty
        private Integer potencia;

        public Eletronicos toEletronicos(){
            return new Eletronicos(nome, modelo,marca,tensao,potencia);
        }
}

package com.fiapadj.fase1.dominio;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"idEndereco"})
public class Endereco {

    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private Integer idEndereco;

    public Endereco(String rua, Integer numero, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
}

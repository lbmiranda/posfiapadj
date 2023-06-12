package com.fiapadj.fase1.dominio;

import com.fiapadj.fase1.controller.form.PessoasForm;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"idPessoa"})
public class Pessoas {

    private String nome;
    private Date dataNascimento;
    private Sexo sexo;
    private Parentesco parentesco;
    private Integer idade;
    private Integer idPessoa;

    public Pessoas(PessoasForm dados) {
        this.nome = dados.getNome();
        this.dataNascimento = dados.getDataNascimento();
        this.sexo = dados.getSexo();
        this.parentesco = dados.getParentesco();
        this.idade = dados.getIdade();
    }
}

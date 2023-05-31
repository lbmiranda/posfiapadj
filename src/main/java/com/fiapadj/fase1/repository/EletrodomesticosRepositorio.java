package com.fiapadj.fase1.repository;

import com.fiapadj.fase1.dominio.Eletrodomesticos;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class EletrodomesticosRepositorio {

    private Set<Eletrodomesticos> eletrodomesticos = new HashSet<>();

    public Set<Eletrodomesticos> listarEletrodomesticos() {return eletrodomesticos;}


}

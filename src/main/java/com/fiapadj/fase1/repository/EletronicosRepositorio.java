package com.fiapadj.fase1.repository;

import com.fiapadj.fase1.dominio.Eletronicos;

import java.util.HashSet;
import java.util.Set;

public class EletronicosRepositorio {

    private Set<Eletronicos> eletronicos = new HashSet<>();

    public Set<Eletronicos> listarEletronicos() {return eletronicos;}


}

package com.fiapadj.fase1.services;


import com.fiapadj.fase1.dominio.Eletronicos;
import com.fiapadj.fase1.repository.EletronicosRepositorio;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EletronicosService {

    public void validarEletronicos(Eletronicos eletronico) throws EletronicosInvalidoException {
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

    EletronicosRepositorio repositorio = new EletronicosRepositorio();
    Set<Eletronicos> eletronicos = repositorio.listarEletronicos();

    public void salvarEletronico(Eletronicos eletronico) {

        eletronico.setIdEletronico(eletronicos.size());
        eletronicos.add(eletronico);

    }

    public Eletronicos buscarEletronicoPorId(Integer idEletronico) {
        for (Eletronicos eletronico : eletronicos) {
            if (eletronico.getIdEletronico().equals(idEletronico)) {
                return eletronico;
            }
        }
        return null;
    }
}

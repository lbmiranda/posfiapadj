package com.fiapadj.fase1.services;


import com.fiapadj.fase1.dominio.Eletronicos;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EletronicosService {

//    public void validarEletronicos(Eletronicos eletronico) throws EletronicosInvalidoException {
//        if (eletronico.getNome() == null || eletronico.getNome().isEmpty()) {
//            throw new EnderecoInvalidoException("Rua é obrigatório");
//        }
//        if (endereco.getNumero() == null) {
//            throw new EnderecoInvalidoException("Número é obrigatório");
//        }
//        if (endereco.getBairro() == null || endereco.getBairro().isEmpty()) {
//            throw new EnderecoInvalidoException("Bairro é obrigatório");
//        }
//        if (endereco.getCidade() == null || endereco.getCidade().isEmpty()) {
//            throw new EnderecoInvalidoException("Cidade é obrigatório");
//        }
//        if (endereco.getEstado() == null || endereco.getEstado().isEmpty()) {
//            throw new EnderecoInvalidoException("Estado é obrigatório");
//        }
//    }
//
//    EnderecoRepositorio repositorio = new EnderecoRepositorio();
//    Set<Endereco> enderecos = repositorio.listarEnderecos();
//
//    public void salvarEndereco(Endereco endereco) {
//
//        endereco.setIdEndereco(enderecos.size());
//        enderecos.add(endereco);
//
//    }
//
//    public Endereco buscarEnderecoPorId(Integer idEndereco) {
//        for (Endereco endereco : enderecos) {
//            if (endereco.getIdEndereco().equals(idEndereco)) {
//                return endereco;
//            }
//        }
//        return null;
//    }
}
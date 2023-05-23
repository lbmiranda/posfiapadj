package com.fiapadj.fase1.services;

public class EnderecoInvalidoException extends RuntimeException{

    public EnderecoInvalidoException(String mensagem) {
        super(mensagem);
    }
}

package com.example.demo.dto;

public record CepRecordDTO(String cep, String logradouro, String complemento, String bairro, String localidade) {

    public CepRecordDTO(String cep, String logradouro, String complemento, String bairro, String localidade) {
        this.logradouro = logradouro.toLowerCase();
        this.cep = cep;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
    }
}

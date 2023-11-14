package com.example.demo.controller;

import com.example.demo.dto.CepRecordDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class ConsultaCepControllerTest{

    @Mock
    private RestTemplate restTemplateMock;

    @InjectMocks
    private ConsultaCepController ConsultaCepController;

    @Test
    void consultaCep() {
        String cep = "01001000";
        RestTemplate restTemplateMock = new RestTemplate();
        ResponseEntity<CepRecordDTO> response = restTemplateMock.getForEntity("http://viacep.com.br/ws/"+cep+"/json/", CepRecordDTO.class);

        assertEquals("01001-000", response.getBody().cep());
    }

    @Test
    void consultaLogradouro() {
        String cep = "01001000";
        RestTemplate restTemplateMock = new RestTemplate();
        ResponseEntity<CepRecordDTO> response = restTemplateMock.getForEntity("http://viacep.com.br/ws/"+cep+"/json/", CepRecordDTO.class);

        assertEquals("praça da sé", response.getBody().logradouro());
    }
}
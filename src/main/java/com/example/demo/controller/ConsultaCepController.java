package com.example.demo.controller;

import com.example.demo.dto.CepRecordDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("cep-cliente")
public class ConsultaCepController {

    @GetMapping("{cep}")
    public CepRecordDTO consultaCep (@PathVariable("cep") String cep){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepRecordDTO> response = restTemplate.getForEntity("http://viacep.com.br/ws/"+cep+"/json/", CepRecordDTO.class);
        return response.getBody();
    }
}

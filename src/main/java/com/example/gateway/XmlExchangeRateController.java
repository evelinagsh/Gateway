package com.example.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xml_api")
public class XmlExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @PostMapping(value = "/command", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<XmlCommandResponse> handleXmlCommandRequest(@RequestBody XmlCommandRequest request) {
        return exchangeRateService.handleXmlCommandRequest(request);
    }

    
}

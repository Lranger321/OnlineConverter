package main.controllers;

import main.dto.request.GetConversionRequest;
import main.dto.response.GetConversionResponse;
import main.dto.response.StatisticsResponse;
import main.peristanse.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralApiController {

    private final ConverterService converterService;

    @Autowired
    public GeneralApiController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @PostMapping("/exchange")
    public GetConversionResponse getConversion(@RequestBody GetConversionRequest request){
        return converterService.getConversion(request);
    }

    @GetMapping("/stats")
    public StatisticsResponse getStat(){
        return converterService.getStat();
    }
}

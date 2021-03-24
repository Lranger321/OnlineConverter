package main.peristanse.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Api {

    @Value("${api.key}")
    private String apiKey;

}

package main.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetConversionResponse {

    private long id;

    private double value;

}

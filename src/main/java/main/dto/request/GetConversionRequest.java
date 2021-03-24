package main.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetConversionRequest {

    private String from;

    private String to;

    private double value;

    @JsonProperty("user_id")
    private int id;

}

package main.dto.request;

import lombok.Data;

@Data
public class GetConversionRequest {

    private String from;

    private String to;

    private double value;

    private int id;

}

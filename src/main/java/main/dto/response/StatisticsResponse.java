package main.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class StatisticsResponse {

    @JsonProperty("summary_stat")
    List<Long> summaryStat;

    List<Long> stat;

}

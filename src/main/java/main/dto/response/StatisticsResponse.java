package main.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class StatisticsResponse {

    List<Long> summaryStat;

    List<Long> stat;

}

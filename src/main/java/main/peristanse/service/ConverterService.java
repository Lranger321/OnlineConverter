package main.peristanse.service;

import main.dto.request.GetConversionRequest;
import main.dto.response.GetConversionResponse;
import main.dto.response.StatisticsResponse;
import main.peristanse.entity.Conversion;
import main.peristanse.repository.ConversionRepository;
import main.peristanse.repository.StatRepository;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ConverterService {

    private final Api api;
    private final ConversionRepository repository;
    private final StatRepository statRepository;

    @Autowired
    public ConverterService(Api api, ConversionRepository repository, StatRepository statRepository) {
        this.api = api;
        this.repository = repository;
        this.statRepository = statRepository;
    }

    public GetConversionResponse getConversion(GetConversionRequest request) {
        double convertValue;
        double conversionToUSD;
        try {
            convertValue = getConversion(request.getFrom(), request.getTo()) * request.getValue();
            conversionToUSD = getConversion(request.getFrom(), "USD") * request.getValue();
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
            return null;
        }
        Conversion conversion = new Conversion();
        conversion.setFromCurrency(request.getFrom());
        conversion.setFromValue(request.getValue());
        conversion.setUser(request.getId());
        conversion.setUsdValue(conversionToUSD);
        conversion.setToValue(convertValue);
        conversion.setToCurrency(request.getTo());
        long id = repository.save(conversion).getId();
        return new GetConversionResponse(id, convertValue);
    }

    private double getConversion(String from, String to) throws IOException, ParseException {
        String fromTo = from.toUpperCase() + "_" + to.toUpperCase();
        StringBuilder url = new StringBuilder("https://free.currconv.com/api/v7/convert?");
        url.append("q=").append(fromTo)
                .append("&")
                .append("compact=ultra")
                .append("&")
                .append("apiKey=").append(api.getApiKey());
        final Content getResult = Request.Get(url.toString()).execute().returnContent();
        JSONParser jsonParser = new JSONParser();
        JSONObject json = (JSONObject) jsonParser.parse(getResult.asString());
        return (double) json.get(fromTo);
    }

    public StatisticsResponse getStat() {
        List<Long> summaryStat = statRepository.getUsersSummaryMoreConversion();
        List<Long> stat = statRepository.getUserMoreConversion();
        return new StatisticsResponse(summaryStat, stat);
    }

}

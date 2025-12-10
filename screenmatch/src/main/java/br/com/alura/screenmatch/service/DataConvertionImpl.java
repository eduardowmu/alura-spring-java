package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class DataConvertionImpl implements DataConvertion {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getDatas(String json, Class<T> typeClass) {
        try {
            return this.mapper.readValue(json, typeClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
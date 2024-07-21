package ru.stroganov.test.titanic.convert_passengers_dto_to_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import ru.stroganov.test.titanic.rest.dtos.PassengerDto;

import java.util.Collection;

public class PassengersDtosToJsonConverter {
    @Autowired
    ObjectMapper mapper;


}

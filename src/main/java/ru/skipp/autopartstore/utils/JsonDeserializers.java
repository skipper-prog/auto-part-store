package ru.skipp.autopartstore.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.skipp.autopartstore.config.WebSecurityConfig;

import java.io.IOException;

public class JsonDeserializers {

    @Autowired
    public static PasswordEncoder passwordEncoder;

    public static class PasswordDeserializer extends JsonDeserializer<String> {

        @Override
        public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            String rawPassword = node.asText();

//            return WebSecurityConfig.PASSWORD_ENCODER.encode(rawPassword);
            return passwordEncoder.encode(rawPassword);
        }
    }
}

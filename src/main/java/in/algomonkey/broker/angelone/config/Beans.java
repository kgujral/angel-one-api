package in.algomonkey.broker.angelone.config;

import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.warrenstrange.googleauth.GoogleAuthenticator;

@Configuration
public class Beans {

  @Bean
  ObjectMapper mapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

    mapper.setTimeZone(TimeZone.getTimeZone("+5:30"));
    return mapper;
  }

  @Bean
  GoogleAuthenticator gAuth() {
    return new GoogleAuthenticator();
  }
}

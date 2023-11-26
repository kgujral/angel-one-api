package in.algomonkey.broker.angelone.config;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sixsprints.json.util.ApiFactory;

import in.algomonkey.broker.angelone.service.api.AngelOneApiService;
import in.algomonkey.broker.angelone.service.api.AngelOneInstrumentApiService;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;

@Configuration
@RequiredArgsConstructor
public class ApiConfig {

  private final ObjectMapper mapper;
  private static final String ENDPOINT = "https://apiconnect.angelbroking.com";
  private static final String INS_ENDPOINT = "https://margincalculator.angelbroking.com";

  private static final Map<String, String> HEADERS = Map.of(
    "X-UserType", "USER",
    "X-SourceID", "WEB",
    "X-ClientLocalIP", "",
    "X-ClientPublicIP", "",
    "X-MACAddress", "");

  @Bean
  AngelOneApiService angelOneApiService() {

    return ApiFactory.retrofit(ENDPOINT, mapper)
      .client(getHttpClient()).build()
      .create(AngelOneApiService.class);
  }

  @Bean
  AngelOneInstrumentApiService angelOneInstrumentApiService() {

    return ApiFactory.retrofit(INS_ENDPOINT, mapper)
      .build()
      .create(AngelOneInstrumentApiService.class);
  }

  @Bean
  OkHttpClient getHttpClient() {

    return new OkHttpClient.Builder()
      .connectTimeout(10, TimeUnit.SECONDS)
      .callTimeout(60, TimeUnit.SECONDS)
      .writeTimeout(60, TimeUnit.SECONDS)
      .readTimeout(60, TimeUnit.SECONDS)
      .addInterceptor(chain -> {
        Request request = chain.request();
        Builder newReq = request.newBuilder();
        HEADERS.keySet().forEach(key -> newReq.addHeader(key, HEADERS.get(key)));
        request = newReq.build();
        return chain.proceed(request);
      }).build();
  }

}

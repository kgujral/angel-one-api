package in.algomonkey.broker.angelone.util;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.sixsprints.json.dto.ApiCall;
import com.sixsprints.json.exception.ApiException;
import com.sixsprints.json.util.ApiFactory;

import in.algomonkey.broker.angelone.dto.AngelOneApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiUtilService {

  private final ObjectMapper mapper;

  private static final TypeFactory FACTORY = TypeFactory.defaultInstance();

  public <T> T makeCall(Call<String> call, Class<T> clazz) {
    JavaType type = FACTORY.constructParametricType(AngelOneApiResponseDto.class, clazz);
    return validateReponse(executeApiCall(call, type));
  }

  public <T> List<T> makeCallForList(Call<String> call, Class<T> clazz) {
    JavaType listType = FACTORY.constructCollectionType(List.class, clazz);
    JavaType type = FACTORY.constructParametricType(AngelOneApiResponseDto.class, listType);
    return validateReponse(executeApiCall(call, type));
  }

  public <T> T makeCallCustomResponseType(Call<String> call, TypeReference<T> type) {
    return executeApiCall(call, FACTORY.constructType(type));
  }

  private <T> T executeApiCall(Call<String> call, JavaType type) {
    try {
      return ApiFactory.makeCallAndTransform(ApiCall.builder().call(call).mapper(mapper).build(), type);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ApiException e) {
      throw new RuntimeException(e);
    }
  }

  private <T> T validateReponse(AngelOneApiResponseDto<T> response) {
    if (response.getSuccess() == Boolean.FALSE) {
      log.error("{}", response);
      throw new RuntimeException(response.getErrorCode() + ": " + response.getMessage());
    }
    return response.getData();
  }

}

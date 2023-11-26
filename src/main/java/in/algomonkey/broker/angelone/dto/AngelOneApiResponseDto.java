package in.algomonkey.broker.angelone.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AngelOneApiResponseDto<T> {

  @JsonAlias("status")
  private Boolean success;

  private String message;

  @JsonAlias("errorcode")
  private String errorCode;

  private T data;

}
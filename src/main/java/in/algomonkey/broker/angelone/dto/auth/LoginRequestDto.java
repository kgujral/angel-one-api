package in.algomonkey.broker.angelone.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

  @JsonProperty("clientcode")
  private String clientCode;

  private String password;

  private String totp;
}
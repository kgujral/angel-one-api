package com.vriksh.broker.angelone.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AngelOneUser {

  private String id;

  private String clientCode;

  private String apiKey;

  private String mPin;

  private String tOtpSecretKey;

  private String jwtToken;

  private String feedToken;
}

package com.vriksh.broker.angelone.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

  private String jwtToken;

  private String refreshToken;

  private String feedToken;
}
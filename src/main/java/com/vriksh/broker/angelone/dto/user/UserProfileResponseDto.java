package com.vriksh.broker.angelone.dto.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponseDto {

  @JsonProperty("clientcode")
  private String clientCode;

  private String name;

  private String email;

  @JsonProperty("mobileno")
  private String mobileNo;

  private List<String> exchanges;

  private List<String> products;

  @JsonProperty("lastlogintime")
  private String lastLoginTime;

  @JsonProperty("broker")
  private String broker;
}

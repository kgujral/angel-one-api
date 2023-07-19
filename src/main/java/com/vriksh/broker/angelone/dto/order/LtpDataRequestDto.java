package com.vriksh.broker.angelone.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vriksh.broker.angelone.dto.enums.Exchange;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LtpDataRequestDto {

  private Exchange exchange;

  @JsonProperty("symboltoken")
  private String token;

  @JsonProperty("tradingsymbol")
  private String symbol;

}

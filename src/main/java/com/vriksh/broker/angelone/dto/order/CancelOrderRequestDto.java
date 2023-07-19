package com.vriksh.broker.angelone.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vriksh.broker.angelone.dto.enums.OrderVariety;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CancelOrderRequestDto {

  private OrderVariety variety;

  @JsonProperty("orderid")
  private String orderId;

}

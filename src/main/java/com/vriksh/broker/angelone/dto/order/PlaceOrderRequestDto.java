package com.vriksh.broker.angelone.dto.order;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vriksh.broker.angelone.dto.enums.Exchange;
import com.vriksh.broker.angelone.dto.enums.OrderDuration;
import com.vriksh.broker.angelone.dto.enums.OrderProductType;
import com.vriksh.broker.angelone.dto.enums.OrderTransactionType;
import com.vriksh.broker.angelone.dto.enums.OrderType;
import com.vriksh.broker.angelone.dto.enums.OrderVariety;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderRequestDto {

  private OrderVariety variety;

  @JsonProperty("tradingsymbol")
  private String tradingSymbol;

  @JsonProperty("symboltoken")
  private String symbolToken;

  @JsonProperty("transactiontype")
  private OrderTransactionType transactionType;

  private Exchange exchange;

  @JsonProperty("ordertype")
  private OrderType orderType;

  @JsonProperty("producttype")
  private OrderProductType productType;

  private OrderDuration duration;

  private BigDecimal price;

  @JsonProperty("triggerprice")
  @Builder.Default
  private BigDecimal triggerPrice = BigDecimal.ZERO;

  @JsonProperty("squareoff")
  @Builder.Default
  private BigDecimal squareOff = BigDecimal.ZERO;

  @JsonProperty("stoploss")
  @Builder.Default
  private BigDecimal stopLoss = BigDecimal.ZERO;

  /**
   * This is a simple quantity variable. In case applicable, multiply by lot size
   * before placing the request.
   */
  private Integer quantity;

}

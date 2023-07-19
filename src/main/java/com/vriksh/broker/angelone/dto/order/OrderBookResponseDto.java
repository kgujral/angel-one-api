package com.vriksh.broker.angelone.dto.order;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.vriksh.broker.angelone.dto.enums.Exchange;
import com.vriksh.broker.angelone.dto.enums.OrderOptionType;
import com.vriksh.broker.angelone.dto.enums.OrderProductType;
import com.vriksh.broker.angelone.dto.enums.OrderTransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderBookResponseDto {

  private Exchange exchange;

  @JsonAlias("producttype")
  private OrderProductType productType;

  @JsonAlias("tradingsymbol")
  private String tradingSymbol;

  @JsonAlias("instrumenttype")
  private String instrumentType;

  @JsonAlias("symbolgroup")
  private String symbolGroup;

  @JsonAlias("strikeprice")
  private BigDecimal strikePrice;

  @JsonAlias("optiontype")
  private OrderOptionType optionType;

  @JsonAlias("expirydate")
  private String expiryDate;

  @JsonAlias("marketlot")
  private Integer marketLot;

  private Integer precision;

  private Integer multiplier;

  @JsonAlias("tradevalue")
  private BigDecimal tradeValue;

  @JsonAlias("transactiontype")
  private OrderTransactionType transactionType;

  @JsonAlias("fillprice")
  private BigDecimal fillPrice;

  @JsonAlias("fillsize")
  private Integer fillSize;

  @JsonAlias("orderid")
  private String orderId;

  @JsonAlias("fillid")
  private String fillId;

  @JsonAlias("filltime")
  private String fillTime;

}

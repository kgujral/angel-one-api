package com.vriksh.broker.angelone.dto.order;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.vriksh.broker.angelone.dto.enums.Exchange;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionResponseDto {

  private Exchange exchange;

  @JsonAlias("symboltoken")
  private String symbolToken;

  @JsonAlias("producttype")
  private String productType;

  @JsonAlias("tradingsymbol")
  private String tradingSymbol;

  @JsonAlias("symbolname")
  private String symbolName;

  @JsonAlias("instrumenttype")
  private String instrumentType;

  @JsonAlias("priceden")
  private BigDecimal priceDen;

  @JsonAlias("pricenum")
  private BigDecimal priceNum;

  @JsonAlias("genden")
  private BigDecimal genDen;

  @JsonAlias("gennum")
  private BigDecimal genNum;

  private Integer precision;

  private BigDecimal multiplier;

  @JsonAlias("boardlotsize")
  private Integer boardLotSize;

  @JsonAlias("buyqty")
  private Integer buyQty;

  @JsonAlias("sellqty")
  private Integer sellQty;

  @JsonAlias("buyAmount")
  private BigDecimal buyAmount;

  @JsonAlias("sellamount")
  private BigDecimal sellAmount;

  @JsonAlias("symbolgroup")
  private String symbolGroup;

  @JsonAlias("strikeprice")
  private BigDecimal strikePrice;

  @JsonAlias("optiontype")
  private String optionType;

  @JsonAlias("expirydate")
  private String expiryDate;

  @JsonAlias("lotsize")
  private Integer lotSize;

  @JsonAlias("cfBuyQty")
  private Integer cfBuyQty;

  @JsonAlias("cfSellQty")
  private Integer cfSellQty;

  @JsonAlias("cfbuyamount")
  private BigDecimal cfBuyAmount;

  @JsonAlias("cfsellamount")
  private BigDecimal cfSellAmount;

  @JsonAlias("buyavgprice")
  private BigDecimal buyAvgPrice;

  @JsonAlias("sellavgprice")
  private BigDecimal sellAvgPrice;

  @JsonAlias("avgnetprice")
  private BigDecimal avgNetPrice;

  @JsonAlias("netvalue")
  private String netValue;

  @JsonAlias("netqty")
  private Integer netQty;

  @JsonAlias("totalbuyvalue")
  private BigDecimal totalBuyValue;

  @JsonAlias("totalsellvalue")
  private BigDecimal totalSellValue;

  @JsonAlias("cfbuyavgprice")
  private BigDecimal cfBuyAvgPrice;

  @JsonAlias("cfsellavgprice")
  private BigDecimal cfSellAvgPrice;

  @JsonAlias("totalbuyavgprice")
  private BigDecimal totalBuyAvgPrice;

  @JsonAlias("totalsellavgprice")
  private BigDecimal totalSellAvgPrice;

  @JsonAlias("netprice")
  private BigDecimal netPrice;

}

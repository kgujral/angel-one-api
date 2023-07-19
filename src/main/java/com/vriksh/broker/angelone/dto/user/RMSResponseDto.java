package com.vriksh.broker.angelone.dto.user;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RMSResponseDto {

  private BigDecimal net;

  @JsonProperty("availablecash")
  private BigDecimal availableCash;

  @JsonProperty("availableintradaypayin")
  private BigDecimal availableIntradayPayin;

  @JsonProperty("availablelimitmargin")
  private BigDecimal availableLimitMargin;

  @JsonProperty("collateral")
  private BigDecimal collateral;

  @JsonProperty("m2munrealized")
  private BigDecimal m2mUnrealized;

  @JsonProperty("m2mrealized")
  private BigDecimal m2mRealized;

  @JsonProperty("utiliseddebits")
  private BigDecimal utilisedDebits;

  @JsonProperty("utilisedspan")
  private BigDecimal utilisedSpan;

  @JsonProperty("utilisedoptionpremium")
  private BigDecimal utilisedOptionPremium;

  @JsonProperty("utilisedholdingsales")
  private BigDecimal utilisedHoldingSales;

  @JsonProperty("utilisedexposure")
  private BigDecimal utilisedExposure;

  @JsonProperty("utilisedturnover")
  private BigDecimal utilisedTurnover;

  @JsonProperty("utilisedpayout")
  private BigDecimal utilisedPayout;
}

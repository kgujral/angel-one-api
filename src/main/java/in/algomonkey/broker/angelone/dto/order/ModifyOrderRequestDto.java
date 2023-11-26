package in.algomonkey.broker.angelone.dto.order;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import in.algomonkey.broker.angelone.dto.enums.Exchange;
import in.algomonkey.broker.angelone.dto.enums.OrderDuration;
import in.algomonkey.broker.angelone.dto.enums.OrderProductType;
import in.algomonkey.broker.angelone.dto.enums.OrderType;
import in.algomonkey.broker.angelone.dto.enums.OrderVariety;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModifyOrderRequestDto {

  private OrderVariety variety;

  @JsonProperty("tradingsymbol")
  private String tradingSymbol;

  @JsonProperty("symboltoken")
  private String symbolToken;

  @JsonProperty("orderid")
  private String orderId;

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

  /**
   * This is a simple quantity variable. In case applicable, multiply by lot size
   * before placing the request.
   */
  private Integer quantity;

}

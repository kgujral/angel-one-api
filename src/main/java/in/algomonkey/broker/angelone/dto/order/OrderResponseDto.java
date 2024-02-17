package in.algomonkey.broker.angelone.dto.order;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

  @JsonAlias("orderid")
  private String orderId;

  @JsonAlias("uniqueorderid")
  private String uniqueOrderId;

  private String script;

}

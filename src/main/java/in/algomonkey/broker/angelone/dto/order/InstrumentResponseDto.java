package in.algomonkey.broker.angelone.dto.order;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentResponseDto {

  private String token;

  private String symbol;

  private String name;

  private String expiry;

  private BigDecimal strike;

  @JsonAlias("lotsize")
  private Integer lotSize;

  @JsonAlias("instrumenttype")
  private String instrumentType;

  @JsonAlias("exch_seg")
  private String exchSeg;

  @JsonAlias("tick_size")
  private String tickSize;

}

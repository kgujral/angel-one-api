package in.algomonkey.broker.angelone.dto.order;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAlias;

import in.algomonkey.broker.angelone.dto.enums.Exchange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LtpDataResponseDto {

  private Exchange exchange;

  @JsonAlias("symboltoken")
  private String token;

  @JsonAlias("tradingsymbol")
  private String symbol;

  private BigDecimal open;

  private BigDecimal high;

  private BigDecimal low;

  private BigDecimal close;

  private BigDecimal ltp;

}

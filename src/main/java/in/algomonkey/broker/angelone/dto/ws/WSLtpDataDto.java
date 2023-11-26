package in.algomonkey.broker.angelone.dto.ws;

import java.math.BigDecimal;

import com.angelbroking.smartapi.smartstream.models.ExchangeType;
import com.angelbroking.smartapi.smartstream.models.TokenID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WSLtpDataDto {

  private ExchangeType exchange;

  private TokenID token;

  private long sequenceNumber;

  private BigDecimal ltp;

  private long exchangeFeedTimeEpochMillis;
}

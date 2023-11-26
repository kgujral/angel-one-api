package in.algomonkey.broker.angelone.dto.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import in.algomonkey.broker.angelone.dto.enums.CandlePriceInterval;
import in.algomonkey.broker.angelone.dto.enums.Exchange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandleDataRequestDto {

  private Exchange exchange;

  @JsonProperty("symboltoken")
  private String symbolToken;

  private CandlePriceInterval interval;

  @JsonProperty("fromdate")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Kolkata")
  private Date fromDate;

  @JsonProperty("todate")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Kolkata")
  private Date toDate;

}

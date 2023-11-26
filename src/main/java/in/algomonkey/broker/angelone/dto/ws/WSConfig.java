package in.algomonkey.broker.angelone.dto.ws;

import java.util.Set;

import com.angelbroking.smartapi.smartstream.models.SmartStreamSubsMode;
import com.angelbroking.smartapi.smartstream.models.TokenID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WSConfig {

  private SmartStreamSubsMode subscriptionType;

  @Singular
  private Set<TokenID> tokens;

}

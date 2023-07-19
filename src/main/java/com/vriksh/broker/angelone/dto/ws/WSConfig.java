package com.vriksh.broker.angelone.dto.ws;

import java.util.Set;

import com.angelbroking.smartapi.smartstream.models.SmartStreamSubsMode;
import com.angelbroking.smartapi.smartstream.models.TokenID;
import com.vriksh.broker.angelone.dto.user.AngelOneUser;
import com.vriksh.broker.angelone.service.ws.AngelOneWSListener;

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

  private AngelOneUser user;

  private SmartStreamSubsMode subscriptionType;

  @Singular
  private Set<TokenID> tokens;

  private AngelOneWSListener listener;

}

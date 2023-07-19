package com.vriksh.broker.angelone.service.ws;

import com.angelbroking.smartapi.smartstream.ticker.SmartStreamTicker;
import com.vriksh.broker.angelone.dto.ws.SmartStreamListenerImpl;
import com.vriksh.broker.angelone.dto.ws.WSConfig;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class AngelOneWSClient {

  private final WSConfig wsConfig;

  private SmartStreamTicker ticker;

  public void subscribe() {
    try {

      ticker = new SmartStreamTicker(wsConfig.getUser().getClientCode(),
        wsConfig.getUser().getFeedToken(), new SmartStreamListenerImpl(wsConfig.getListener()));
      ticker.connect();
      ticker.subscribe(wsConfig.getSubscriptionType(), wsConfig.getTokens());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public boolean isConnectionOpen() {
    return ticker.isConnectionOpen();
  }

  public boolean isConnectionClosed() {
    return ticker.isConnectionClosed();
  }

  public void disconnect() {
    ticker.disconnect();
  }

}

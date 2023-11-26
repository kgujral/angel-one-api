package com.vriksh.broker.angelone.service.ws;

import com.vriksh.broker.angelone.dto.user.AngelOneUser;
import com.vriksh.broker.angelone.dto.ws.SmartStreamListenerImpl;
import com.vriksh.broker.angelone.dto.ws.WSConfig;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class AngelOneWSClient {

  private final AngelOneUser user;

  private final AngelOneWSListener listener;

  private SmartStreamTicker2 ticker;

  public void subscribe(WSConfig config) {
    try {
      if (ticker == null) {
        ticker = new SmartStreamTicker2(user.getClientCode(), user.getFeedToken(),
          new SmartStreamListenerImpl(listener));
        ticker.connect();
      }
      ticker.subscribe(config.getSubscriptionType(), config.getTokens());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void unsubscribe(WSConfig config) {
    ticker.unsubscribe(config.getSubscriptionType(), config.getTokens());
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

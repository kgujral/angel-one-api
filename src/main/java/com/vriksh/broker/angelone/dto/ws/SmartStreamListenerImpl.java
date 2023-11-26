package com.vriksh.broker.angelone.dto.ws;

import java.math.BigDecimal;

import com.angelbroking.smartapi.smartstream.models.Depth;
import com.angelbroking.smartapi.smartstream.models.LTP;
import com.angelbroking.smartapi.smartstream.models.Quote;
import com.angelbroking.smartapi.smartstream.models.SmartStreamError;
import com.angelbroking.smartapi.smartstream.models.SnapQuote;
import com.angelbroking.smartapi.smartstream.ticker.SmartStreamListener;
import com.vriksh.broker.angelone.service.ws.AngelOneWSListener;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SmartStreamListenerImpl implements SmartStreamListener {

  private final AngelOneWSListener listener;

  @Override
  public void onLTPArrival(LTP ltp) {
    listener.onLTPMessage(convert(ltp));
  }

  @Override
  public void onQuoteArrival(Quote quote) {
  }

  @Override
  public void onSnapQuoteArrival(SnapQuote snapQuote) {
  }

  @Override
  public void onConnected() {
    listener.onConnected();
  }

  @Override
  public void onError(SmartStreamError error) {
    listener.onError(error);
  }

  @Override
  public void onPong() {
    listener.onPong();
  }

  @Override
  public void onDisconnected() {
    listener.onDisconnected();
  }

  private WSLtpDataDto convert(LTP ltp) {
    return WSLtpDataDto.builder()
      .exchange(ltp.getExchangeType())
      .token(ltp.getToken())
      .sequenceNumber(ltp.getSequenceNumber())
      .ltp(BigDecimal.valueOf(ltp.getLastTradedPrice()).divide(BigDecimal.valueOf(100)))
      .exchangeFeedTimeEpochMillis(ltp.getExchangeFeedTimeEpochMillis())
      .build();
  }

  @Override
  public void onDepthArrival(Depth depth) {
    
  }

  @Override
  public SmartStreamError onErrorCustom() {
    return null;
  }

}
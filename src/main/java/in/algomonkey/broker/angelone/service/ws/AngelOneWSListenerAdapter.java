package in.algomonkey.broker.angelone.service.ws;

import com.angelbroking.smartapi.smartstream.models.SmartStreamError;

import in.algomonkey.broker.angelone.dto.ws.WSLtpDataDto;

public abstract class AngelOneWSListenerAdapter implements AngelOneWSListener {

  @Override
  public void onLTPMessage(WSLtpDataDto ltp) {
  }

  @Override
  public void onConnected() {
  }

  @Override
  public void onDisconnected() {
  }

  @Override
  public void onError(SmartStreamError error) {
  }

  @Override
  public void onPong() {
  }

}
package in.algomonkey.broker.angelone.service.ws;

import com.angelbroking.smartapi.smartstream.models.SmartStreamError;

import in.algomonkey.broker.angelone.dto.ws.WSLtpDataDto;

public interface AngelOneWSListener {

  void onLTPMessage(WSLtpDataDto ltp);

  void onConnected();

  void onDisconnected();

  void onError(SmartStreamError error);

  void onPong();

}
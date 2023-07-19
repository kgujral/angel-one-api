package com.vriksh.broker.angelone.mock;

import com.vriksh.broker.angelone.dto.ws.WSLtpDataDto;
import com.vriksh.broker.angelone.service.ws.AngelOneWSListener;
import com.vriksh.broker.angelone.service.ws.AngelOneWSListenerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MockLtpListener extends AngelOneWSListenerAdapter implements AngelOneWSListener {

  @Override
  public void onLTPMessage(WSLtpDataDto ltp) {
    log.info("{}", ltp);
  }

}

package com.vriksh.broker.angelone.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.angelbroking.smartapi.smartstream.models.ExchangeType;
import com.angelbroking.smartapi.smartstream.models.SmartStreamSubsMode;
import com.angelbroking.smartapi.smartstream.models.TokenID;
import com.vriksh.broker.angelone.AngelOneApiApplicationTests;
import com.vriksh.broker.angelone.dto.auth.LoginResponseDto;
import com.vriksh.broker.angelone.dto.data.CandleDataDto;
import com.vriksh.broker.angelone.dto.data.CandleDataRequestDto;
import com.vriksh.broker.angelone.dto.enums.CandlePriceInterval;
import com.vriksh.broker.angelone.dto.enums.Exchange;
import com.vriksh.broker.angelone.dto.enums.OrderDuration;
import com.vriksh.broker.angelone.dto.enums.OrderProductType;
import com.vriksh.broker.angelone.dto.enums.OrderTransactionType;
import com.vriksh.broker.angelone.dto.enums.OrderType;
import com.vriksh.broker.angelone.dto.enums.OrderVariety;
import com.vriksh.broker.angelone.dto.order.CancelOrderRequestDto;
import com.vriksh.broker.angelone.dto.order.InstrumentResponseDto;
import com.vriksh.broker.angelone.dto.order.LtpDataRequestDto;
import com.vriksh.broker.angelone.dto.order.LtpDataResponseDto;
import com.vriksh.broker.angelone.dto.order.ModifyOrderRequestDto;
import com.vriksh.broker.angelone.dto.order.OrderBookResponseDto;
import com.vriksh.broker.angelone.dto.order.OrderResponseDto;
import com.vriksh.broker.angelone.dto.order.PlaceOrderRequestDto;
import com.vriksh.broker.angelone.dto.order.PositionResponseDto;
import com.vriksh.broker.angelone.dto.user.AngelOneUser;
import com.vriksh.broker.angelone.dto.user.RMSResponseDto;
import com.vriksh.broker.angelone.dto.user.UserProfileResponseDto;
import com.vriksh.broker.angelone.dto.ws.WSConfig;
import com.vriksh.broker.angelone.mock.MockLtpListener;
import com.vriksh.broker.angelone.service.ws.AngelOneWSClient;

public class AngelOneBrokerServiceTest extends AngelOneApiApplicationTests {

  @Value("${totp.secret.key}")
  private String tOtpSecretKey;

  @Value("${mpin}")
  private String mPin;

  @Value("${client.code}")
  private String clientCode;

  @Value("${api.key}")
  private String apiKey;

  // Run shouldLogin() test case and copy and paste the token here.
  // Doing this to save on Login API calls and to avoid rate limit limitations.
  private String jwtToken = "";

  // Run shouldLogin() test case and copy and paste the token here.
  // Doing this to save on Login API calls and to avoid rate limit limitations.
  private String feedToken = "";

  @Autowired
  private AngelOneBrokerService angelOneBrokerService;

  @Test
  public void shouldLogin() {
    LoginResponseDto loginResponseDto = login();
    System.out.println(loginResponseDto);
  }

  @Test
  public void shouldFetchRMS() {
    RMSResponseDto rms = angelOneBrokerService.getRMS(AngelOneUser.builder()
      .apiKey(apiKey)
      .jwtToken(jwtToken)
      .build());
    System.out.println(rms);
  }

  @Test
  public void shouldFetchUserProfile() {
    UserProfileResponseDto profile = angelOneBrokerService.getUserProfile(AngelOneUser.builder()
      .apiKey(apiKey)
      .jwtToken(jwtToken)
      .build());

    System.out.println(profile);
  }

  @Test
  public void shouldFetchUserPositions() {
    List<PositionResponseDto> positions = angelOneBrokerService.getPosition(AngelOneUser.builder()
      .apiKey(apiKey)
      .jwtToken(jwtToken)
      .build());
    if (positions != null) {
      positions.forEach(pos -> System.out.println(pos.getTradingSymbol() + ": " + pos.getSymbolToken()));
    }
  }

  @Test
  public void shouldFetchAllInstruments() {
    List<InstrumentResponseDto> instruments = angelOneBrokerService.allInstruments();
    for (int i = 0; i < 10; i++) {
      System.out.println(instruments.get(i).getSymbol());
    }
  }

  @Test
  public void shouldPlaceOrder() {
    OrderResponseDto order = angelOneBrokerService.placeOrder(
      PlaceOrderRequestDto.builder()
        .variety(OrderVariety.AMO)
        .tradingSymbol("BANKNIFTY20JUL2345200CE")
        .symbolToken("37179")
        .transactionType(OrderTransactionType.BUY)
        .exchange(Exchange.NFO)
        .orderType(OrderType.LIMIT)
        .productType(OrderProductType.INTRADAY)
        .duration(OrderDuration.DAY)
        .price(BigDecimal.valueOf(270))
        .quantity(25)
        .build(),
      AngelOneUser.builder()
        .apiKey(apiKey)
        .jwtToken(jwtToken)
        .build());
    System.out.println(order);
  }

  @Test
  public void shouldModifyOrder() {
    String orderId = "230709000012292";
    OrderResponseDto order = angelOneBrokerService.modifyOrder(
      ModifyOrderRequestDto.builder()
        .orderId(orderId)
        .variety(OrderVariety.AMO)
        .tradingSymbol("BANKNIFTY20JUL2345200CE")
        .symbolToken("37179")
        .exchange(Exchange.NFO)
        .orderType(OrderType.LIMIT)
        .productType(OrderProductType.INTRADAY)
        .duration(OrderDuration.DAY)
        .price(BigDecimal.valueOf(240))
        .quantity(25)
        .build(),
      AngelOneUser.builder()
        .apiKey(apiKey)
        .jwtToken(jwtToken)
        .build());
    System.out.println(order);
  }

  @Test
  public void shouldCancelOrder() {
    String orderId = "230709000012292";
    OrderResponseDto order = angelOneBrokerService.cancelOrder(
      CancelOrderRequestDto.builder()
        .orderId(orderId)
        .variety(OrderVariety.AMO)
        .build(),
      AngelOneUser.builder()
        .apiKey(apiKey)
        .jwtToken(jwtToken)
        .build());
    System.out.println(order);
  }

  @Test
  public void shouldgetLtpData() {
    LtpDataResponseDto ltp = angelOneBrokerService.getLtpData(
      LtpDataRequestDto.builder()
        .symbol("BANKNIFTY20JUL2345200CE")
        .token("37179")
        .exchange(Exchange.NFO)
        .build(),
      AngelOneUser.builder()
        .apiKey(apiKey)
        .jwtToken(jwtToken)
        .build());
    System.out.println(ltp);
  }

  @Test
  public void shouldgetHistoricalCandleData() {
    List<CandleDataDto> candleData = angelOneBrokerService.getCandleData(
      CandleDataRequestDto.builder()
        .exchange(Exchange.NSE)
        .symbolToken("26009")
        .interval(CandlePriceInterval.FIVE_MINUTE)
        .fromDate(asDate(LocalDate.now().minusDays(5)))
        .toDate(asDate(LocalDate.now()))
        .build(),
      AngelOneUser.builder()
        .apiKey(apiKey)
        .jwtToken(jwtToken)
        .build());
    System.out.println(candleData);
  }

  @Test
  public void shouldGetTradeBook() {
    List<OrderBookResponseDto> tradeBook = angelOneBrokerService.getTradeBook(
      AngelOneUser.builder()
        .apiKey(apiKey)
        .jwtToken(jwtToken)
        .build());
    System.out.println(tradeBook);
  }

  @Test
  void shouldSubscribeToWSLTPData() throws InterruptedException {

    AngelOneUser user = AngelOneUser.builder()
      .clientCode(clientCode)
      .jwtToken(jwtToken)
      .feedToken(feedToken)
      .build();
    MockLtpListener listener = new MockLtpListener();
    AngelOneWSClient client = new AngelOneWSClient(user, listener);

    WSConfig config1 = WSConfig.builder()
      .subscriptionType(SmartStreamSubsMode.LTP)
      .token(new TokenID(ExchangeType.NSE_FO, "41683"))
      .build();
    client.subscribe(config1);
    Thread.sleep(5000);
    System.out.println(client.isConnectionOpen());

    WSConfig config2 = WSConfig.builder()
      .subscriptionType(SmartStreamSubsMode.LTP)
      .token(new TokenID(ExchangeType.NSE_FO, "41737"))
      .build();
    client.subscribe(config2);
    Thread.sleep(5000);
    System.out.println(client.isConnectionOpen());

    client.unsubscribe(config2);
    Thread.sleep(5000);
    System.out.println(client.isConnectionOpen());

    client.subscribe(config2);
    Thread.sleep(5000);
    System.out.println(client.isConnectionOpen());

    client.disconnect();
  }

  private LoginResponseDto login() {
    return angelOneBrokerService.login(AngelOneUser.builder()
      .id("Karan")
      .clientCode(clientCode)
      .apiKey(apiKey)
      .mPin(mPin)
      .tOtpSecretKey(tOtpSecretKey)
      .build());
  }

  private static Date asDate(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
  }

}
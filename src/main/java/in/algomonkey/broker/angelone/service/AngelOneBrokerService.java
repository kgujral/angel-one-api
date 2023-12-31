package in.algomonkey.broker.angelone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.warrenstrange.googleauth.GoogleAuthenticator;

import in.algomonkey.broker.angelone.dto.auth.LoginRequestDto;
import in.algomonkey.broker.angelone.dto.auth.LoginResponseDto;
import in.algomonkey.broker.angelone.dto.data.CandleDataDto;
import in.algomonkey.broker.angelone.dto.data.CandleDataRequestDto;
import in.algomonkey.broker.angelone.dto.order.CancelOrderRequestDto;
import in.algomonkey.broker.angelone.dto.order.InstrumentResponseDto;
import in.algomonkey.broker.angelone.dto.order.LtpDataRequestDto;
import in.algomonkey.broker.angelone.dto.order.LtpDataResponseDto;
import in.algomonkey.broker.angelone.dto.order.ModifyOrderRequestDto;
import in.algomonkey.broker.angelone.dto.order.OrderBookResponseDto;
import in.algomonkey.broker.angelone.dto.order.OrderResponseDto;
import in.algomonkey.broker.angelone.dto.order.PlaceOrderRequestDto;
import in.algomonkey.broker.angelone.dto.order.PositionResponseDto;
import in.algomonkey.broker.angelone.dto.user.AngelOneUser;
import in.algomonkey.broker.angelone.dto.user.RMSResponseDto;
import in.algomonkey.broker.angelone.dto.user.UserProfileResponseDto;
import in.algomonkey.broker.angelone.mapper.CandleDataMapper;
import in.algomonkey.broker.angelone.service.api.AngelOneApiService;
import in.algomonkey.broker.angelone.service.api.AngelOneInstrumentApiService;
import in.algomonkey.broker.angelone.util.ApiUtilService;
import lombok.RequiredArgsConstructor;
import retrofit2.Call;

@Service
@RequiredArgsConstructor
public class AngelOneBrokerService {

  private final AngelOneApiService angelOneApiService;

  private final AngelOneInstrumentApiService angelOneInstrumentApiService;

  private final ApiUtilService apiUtilService;

  private final GoogleAuthenticator gAuth;

  public LoginResponseDto login(AngelOneUser user) {
    Call<String> login = angelOneApiService.login(LoginRequestDto.builder()
      .clientCode(user.getClientCode())
      .password(user.getMPin())
      .totp(String.valueOf(gAuth.getTotpPassword(user.getTOtpSecretKey())))
      .build(), user.getApiKey());
    return apiUtilService.makeCall(login, LoginResponseDto.class);
  }

  public RMSResponseDto getRMS(AngelOneUser user) {
    Call<String> rms = angelOneApiService.getRMS(user.getApiKey(), bearerToken(user));
    return apiUtilService.makeCall(rms, RMSResponseDto.class);
  }

  public UserProfileResponseDto getUserProfile(AngelOneUser user) {
    Call<String> profile = angelOneApiService.getProfile(user.getApiKey(), bearerToken(user));
    return apiUtilService.makeCall(profile, UserProfileResponseDto.class);
  }

  public List<PositionResponseDto> getPosition(AngelOneUser user) {
    Call<String> positions = angelOneApiService.getPosition(user.getApiKey(), bearerToken(user));
    return apiUtilService.makeCallForList(positions, PositionResponseDto.class);
  }

  public OrderResponseDto placeOrder(PlaceOrderRequestDto placeOrderRequestDto, AngelOneUser user) {
    Call<String> order = angelOneApiService.placeOrder(placeOrderRequestDto, user.getApiKey(), bearerToken(user));
    return apiUtilService.makeCall(order, OrderResponseDto.class);
  }

  public OrderResponseDto modifyOrder(ModifyOrderRequestDto modifyOrderRequestDto, AngelOneUser user) {
    Call<String> order = angelOneApiService.modifyOrder(modifyOrderRequestDto, user.getApiKey(), bearerToken(user));
    return apiUtilService.makeCall(order, OrderResponseDto.class);
  }

  public OrderResponseDto cancelOrder(CancelOrderRequestDto cancelOrderRequestDto, AngelOneUser user) {
    Call<String> order = angelOneApiService.cancelOrder(cancelOrderRequestDto, user.getApiKey(), bearerToken(user));
    return apiUtilService.makeCall(order, OrderResponseDto.class);
  }

  public LtpDataResponseDto getLtpData(LtpDataRequestDto ltpDataRequestDto, AngelOneUser user) {
    Call<String> ltp = angelOneApiService.getLtpData(ltpDataRequestDto, user.getApiKey(), bearerToken(user));
    return apiUtilService.makeCall(ltp, LtpDataResponseDto.class);
  }

  public List<OrderBookResponseDto> getTradeBook(AngelOneUser user) {
    Call<String> tradeBook = angelOneApiService.getTradeBook(user.getApiKey(), bearerToken(user));
    return apiUtilService.makeCallForList(tradeBook, OrderBookResponseDto.class);
  }

  public List<CandleDataDto> getCandleData(CandleDataRequestDto candleDataRequestDto, AngelOneUser user) {
    Call<String> candleData = angelOneApiService.getCandleData(candleDataRequestDto, user.getApiKey(),
      bearerToken(user));
    ArrayNode data = apiUtilService.makeCall(candleData, ArrayNode.class);
    return CandleDataMapper.convert(data);
  }

  public List<InstrumentResponseDto> allInstruments() {
    Call<String> allInstruments = angelOneInstrumentApiService.getAllInstruments();
    return apiUtilService.makeCallCustomResponseType(allInstruments, new TypeReference<List<InstrumentResponseDto>>() {
    });
  }

  private String bearerToken(AngelOneUser user) {
    return "Bearer " + user.getJwtToken();
  }

}

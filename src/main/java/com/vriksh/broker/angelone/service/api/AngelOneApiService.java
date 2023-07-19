package com.vriksh.broker.angelone.service.api;

import com.vriksh.broker.angelone.dto.auth.LoginRequestDto;
import com.vriksh.broker.angelone.dto.data.CandleDataRequestDto;
import com.vriksh.broker.angelone.dto.order.CancelOrderRequestDto;
import com.vriksh.broker.angelone.dto.order.LtpDataRequestDto;
import com.vriksh.broker.angelone.dto.order.ModifyOrderRequestDto;
import com.vriksh.broker.angelone.dto.order.PlaceOrderRequestDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AngelOneApiService {

  @POST("/rest/auth/angelbroking/user/v1/loginByPassword")
  Call<String> login(@Body LoginRequestDto loginRequestDto, @Header("X-PrivateKey") String apiKey);

  @GET("/rest/secure/angelbroking/user/v1/getRMS")
  Call<String> getRMS(@Header("X-PrivateKey") String apiKey, @Header("Authorization") String authorization);

  @GET("/rest/secure/angelbroking/user/v1/getProfile")
  Call<String> getProfile(@Header("X-PrivateKey") String apiKey, @Header("Authorization") String authorization);

  @GET("/rest/secure/angelbroking/order/v1/getPosition")
  Call<String> getPosition(@Header("X-PrivateKey") String apiKey, @Header("Authorization") String authorization);

  @POST("/rest/secure/angelbroking/order/v1/placeOrder")
  Call<String> placeOrder(@Body PlaceOrderRequestDto placeOrderRequestDto, @Header("X-PrivateKey") String apiKey,
    @Header("Authorization") String authorization);

  @POST("/rest/secure/angelbroking/order/v1/modifyOrder")
  Call<String> modifyOrder(@Body ModifyOrderRequestDto modifyOrderRequestDto, @Header("X-PrivateKey") String apiKey,
    @Header("Authorization") String authorization);

  @POST("/rest/secure/angelbroking/order/v1/cancelOrder")
  Call<String> cancelOrder(@Body CancelOrderRequestDto cancelOrderRequestDto, @Header("X-PrivateKey") String apiKey,
    @Header("Authorization") String authorization);

  @POST("/rest/secure/angelbroking/order/v1/getLtpData")
  Call<String> getLtpData(@Body LtpDataRequestDto ltpDataRequestDto, @Header("X-PrivateKey") String apiKey,
    @Header("Authorization") String authorization);

  @GET("/rest/secure/angelbroking/order/v1/getTradeBook")
  Call<String> getTradeBook(@Header("X-PrivateKey") String apiKey, @Header("Authorization") String authorization);

  @POST("/rest/secure/angelbroking/historical/v1/getCandleData")
  Call<String> getCandleData(@Body CandleDataRequestDto candleDataRequestDto, @Header("X-PrivateKey") String apiKey,
    @Header("Authorization") String authorization);

}

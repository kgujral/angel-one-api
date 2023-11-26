package in.algomonkey.broker.angelone.service.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AngelOneInstrumentApiService {

  @GET("/OpenAPI_File/files/OpenAPIScripMaster.json")
  Call<String> getAllInstruments();

}

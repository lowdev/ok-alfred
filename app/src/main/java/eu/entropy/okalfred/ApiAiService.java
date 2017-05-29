package eu.entropy.okalfred;

import eu.entropy.okalfred.eu.entropy.okalfred.apiai.model.ApiAiResponse;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiAiService {
    @GET("query?v=20150910&lang=en&sessionId=1234567890")
    Observable<ApiAiResponse> query(@Header("Authorization") String token, @Query("query") String text);
}

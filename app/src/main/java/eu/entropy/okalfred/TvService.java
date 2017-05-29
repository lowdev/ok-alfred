package eu.entropy.okalfred;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface TvService {
    @GET("tv/{path}")
    Observable<ResponseBody> request(@Query("path") String text);
}

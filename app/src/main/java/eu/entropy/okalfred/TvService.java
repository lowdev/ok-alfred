package eu.entropy.okalfred;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface TvService {
    @GET("tv/{path}")
    Observable<ResponseBody> request(@Path("path") String text);
}

package eu.entropy.okalfred;

import android.app.Activity;
import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;

import eu.entropy.okalfred.eu.entropy.okalfred.apiai.model.ApiAiResponse;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!getIntent().hasExtra(Intent.EXTRA_TEXT)) {
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("https://api.api.ai/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiAiService service = retrofit.create(ApiAiService.class);

        Intent t = getIntent();
        String s = t.getStringExtra(Intent.EXTRA_TEXT);
        System.out.println("===" + s);

        Retrofit tvRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://192.168.1.27:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TvService tvService = tvRetrofit.create(TvService.class);

        Observable<ApiAiResponse> call = service.query("Bearer 30bf818339364a249da4d64c5160ab8f", s);
        call.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(apiAiResponse -> {
                    System.out.println("Action: " + apiAiResponse.getAction());
                    tvService.request(apiAiResponse.getAction()).subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe();
                });
        finish();
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        super.onProvideAssistContent(outContent);
    }
}

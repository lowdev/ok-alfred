package eu.entropy.okalfred;

import android.app.Activity;
import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;

import java.io.IOException;
import java.util.prefs.Preferences;

import eu.entropy.okalfred.eu.entropy.okalfred.apiai.model.ApiAiResponse;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.string.ok;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.api.ai/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiAiService service = retrofit.create(ApiAiService.class);
        Call<ApiAiResponse> call = service.query("Bearer 30bf818339364a249da4d64c5160ab8f", "Shutdown the TV");
        call.enqueue(new Callback<ApiAiResponse>() {
            @Override
            public void onResponse(Call<ApiAiResponse> call, Response<ApiAiResponse> response) {
                ApiAiResponse myItem=response.body();
                System.out.println(myItem.getSpeech());
            }

            @Override
            public void onFailure(Call<ApiAiResponse> call, Throwable t) {
                System.out.println(t);
            }
        });

        Intent t = getIntent();
        String s = t.getStringExtra(Intent.EXTRA_TEXT);
        System.out.println("===" + s);
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        super.onProvideAssistContent(outContent);
    }
}

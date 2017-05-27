package eu.entropy.okalfred;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent t = getIntent();
        String s = t.getStringExtra(Intent.EXTRA_TEXT);
        System.out.println("===" + s);
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        super.onProvideAssistContent(outContent);
    }
}

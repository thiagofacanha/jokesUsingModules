package br.com.sandclan.androidjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainJokeActivity extends AppCompatActivity {
    public static final String JOKE_EXTRA = "jokeextra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);
        Bundle extras = getIntent().getExtras();
        if(extras != null && extras.getString(JOKE_EXTRA) != null){
            TextView textJoke = (TextView) findViewById(br.com.sandclan.androidjoke.R.id.jokeText);
            textJoke.setText(extras.getString(JOKE_EXTRA));
        }
    }
}

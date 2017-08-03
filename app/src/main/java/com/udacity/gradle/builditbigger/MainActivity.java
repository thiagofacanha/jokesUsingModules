package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import br.com.sandclan.androidjoke.MainJokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
//        JavaJokeMain javaJoker = new JavaJokeMain();
        GCEJokeAsyncTask async = new GCEJokeAsyncTask() {
            @Override
            public void callJokeActivity(String result) {
                Intent androidLibJokeIntent = new Intent(MainActivity.this, MainJokeActivity.class);
                androidLibJokeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                androidLibJokeIntent.putExtra(MainJokeActivity.JOKE_EXTRA, result);
                MainActivity.this.startActivity(androidLibJokeIntent);
            }
        };
        async.execute(this);
    }





}

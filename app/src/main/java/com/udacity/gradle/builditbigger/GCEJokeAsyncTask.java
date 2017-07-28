package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import br.com.sandclan.androidjoke.MainJokeActivity;
import br.com.sandclan.gcejokes.backend.myApi.MyApi;

class GCEJokeAsyncTask extends AsyncTask<Context, String, String> {
    private static MyApi myApiService = null;
    private static Context context;

    @Override
    protected String doInBackground(Context... params) {
        return getJokeFromServer(params[0]);
    }

    public static String getJokeFromServer(Context paramContext) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/") // 10.0.2.2 is localhost's IP address in Android emulator
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }
        context = paramContext;
        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent androidLibJokeIntent = new Intent(context, MainJokeActivity.class);
        androidLibJokeIntent.putExtra(MainJokeActivity.JOKE_EXTRA, result);
//        startActivity(androidLibJokeIntent);
    }
}
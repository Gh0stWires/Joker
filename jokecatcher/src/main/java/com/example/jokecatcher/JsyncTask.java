package com.example.jokecatcher;

import android.content.Context;
import android.os.AsyncTask;

import com.example.ghost.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by ghost on 10/21/2016.
 */

public class JsyncTask extends AsyncTask<Void, Void, String> {
    private Context mContext;
    private MyApi mApi = null;

    @Override
    protected String doInBackground(Void... params) {
        if(mApi == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://2-dot-joker-146400.appspot.com/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            mApi = builder.build();
        }
        //mContext = params[0];
        try {
            return mApi.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


}
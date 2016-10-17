package com.example.jokecatcher;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ghost.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        new JokeAsyncTask().execute(this);
        //Intent intent = getIntent();
        //String joke = intent.getStringExtra("JOKE");

    }


    class JokeAsyncTask extends AsyncTask<Context, Void, String>{
        private Context mContext;
        private MyApi mApi = null;

        @Override
        protected String doInBackground(Context... params) {
            if(mApi == null){
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://2-dot-joker-146400.appspot.com/_ah/api#p/myApi/v2/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                                request.setDisableGZipContent(true);
                            }
                        });
                mApi = builder.build();
            }
            mContext = params[0];
            try {
                return mApi.getJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            TextView jokeView = (TextView)findViewById(R.id.textView);
            jokeView.setText(s);
        }
    }
}

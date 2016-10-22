package com.example.jokecatcher;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by ghost on 10/21/2016.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTest {

    @Test
    public void test() throws Exception{
        JsyncTask task = new JsyncTask(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

            }
        };
        String joke = task.execute().get();
        //task.execute().get();
        Assert.assertNotNull(joke);
    }
}

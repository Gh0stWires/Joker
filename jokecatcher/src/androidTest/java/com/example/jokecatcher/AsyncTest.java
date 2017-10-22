package com.example.jokecatcher;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by ghost on 10/21/2016.
 */
@RunWith(JUnit4.class)
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

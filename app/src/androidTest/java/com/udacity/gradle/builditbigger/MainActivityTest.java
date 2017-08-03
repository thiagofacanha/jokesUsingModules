package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {
    private Context instrumentationCtx;

    @Before
    public void setup() {
        instrumentationCtx = InstrumentationRegistry.getContext();

    }

    @Test
    public void tellJoke() throws Exception {
       new GCEJokeAsyncTask() {
            @Override
            public void callJokeActivity(String result) {
                assertTrue(!result.isEmpty());
            }
        }.execute(instrumentationCtx);

    }

}
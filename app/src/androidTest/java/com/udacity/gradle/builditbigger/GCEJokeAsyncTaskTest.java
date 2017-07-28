package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class GCEJokeAsyncTaskTest extends TestCase {

    private Context instrumentationCtx;

    @Before
    public void setup() {
        instrumentationCtx = InstrumentationRegistry.getContext();

    }


    @Test
    public void doInBackground() throws Exception {

        String joke = GCEJokeAsyncTask.getJokeFromServer(instrumentationCtx);
        assertTrue(!joke.isEmpty());
    }





}
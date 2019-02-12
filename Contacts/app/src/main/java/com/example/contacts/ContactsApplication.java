package com.example.contacts;

import android.app.Application;

import com.backendless.Backendless;

public class ContactsApplication extends Application
{
    public static final String APPLICATION_ID = "37367921-91A3-38AB-FF87-BC740AE14B00";
    public static final String API_KEY = "C55EFED4-2439-8926-FF96-EA629B0C7F00";
    public static final String SERVER_URL = "https://api.backendless.com";

    @Override
    public void onCreate() {
        super.onCreate();

        Backendless.setUrl(SERVER_URL);
        Backendless.initApp(getApplicationContext(), APPLICATION_ID, API_KEY);

    }
}

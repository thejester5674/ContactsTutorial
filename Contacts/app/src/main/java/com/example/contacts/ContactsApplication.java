package com.example.contacts;

import android.app.Application;

import com.backendless.Backendless;

public class ContactsApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();

       Backendless.initApp(this,
               "37367921-91A3-38AB-FF87-BC740AE14B00",
               "C55EFED4-2439-8926-FF96-EA629B0C7F00");
    }
}

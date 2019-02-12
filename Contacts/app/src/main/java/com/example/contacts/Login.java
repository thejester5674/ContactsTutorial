package com.example.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Login extends AppCompatActivity {
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        Person person = new Person();
        person.setName("John");
        person.setSurname("Rambo");

        Backendless.Data.of(Person.class).save(person, new AsyncCallback<Person>() {
            @Override
            public void handleResponse(Person response) {

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }

    public void btnLogin(View v)
    {

    }

    public void btnCreateAccount(View v)
    {

    }

    public void btnResetPassword(View v)
    {

    }
}

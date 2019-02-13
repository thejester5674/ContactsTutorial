package com.example.contacts;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import dmax.dialog.SpotsDialog;

public class Login extends AppCompatActivity {
    EditText etUsername, etPassword;
    AlertDialog progressDialog;


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
String username = etUsername.getText().toString().trim();
String password = etPassword.getText().toString().trim();

        if (username.equals("") || password.equals(""))
        {
            Toast.makeText(Login.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (connectionAvailable())
            {
                progressDialog = new SpotsDialog(Login.this, R.style.Custom);
                progressDialog.show();

                Backendless.UserService.login(username, password, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser backendlessUser) {

                        Toast.makeText(Login.this, backendlessUser.getEmail() + " successfully logged in!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, ContactList.class);
                        intent.putExtra("user", backendlessUser.getEmail());
                        startActivity(intent);
                        progressDialog.dismiss();

                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {
                        Toast.makeText(Login.this, "Error:" + backendlessFault.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }, true);
            }
            else {
                Toast.makeText(this, "Please check your  internet connection!", Toast.LENGTH_SHORT).show();
            }

    }
    }

    public void btnCreateAccount(View v)
    {
        Intent intent = new Intent(Login.this, CreateAccount.class);
        startActivity(intent);
    }

    public void btnResetPassword(View v)
    {

    }

    private boolean connectionAvailable()
    {
        boolean connected = false;

        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                connected = true;

            }else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                // connected to the mobile provider's data plan
                connected = true;
            }
        } else {
            // not connected to the internet
            connected = false;
        }

        return connected;
    }
}

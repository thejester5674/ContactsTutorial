package com.example.contacts;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    EditText etName, etSurname,etMail, etPassword, etRePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etMail = (EditText) findViewById(R.id.etMail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etRePassword = (EditText) findViewById(R.id.etRePassword);
    }
    public void btnCreateAccount(View v)
    {
        String name = etName.getText().toString().trim();
        String surname = etSurname.getText().toString().trim();
        String email = etMail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String retype = etRePassword.getText().toString().trim();

        if (name.equals("") || surname.equals("") || email.equals("") ||password.equals("") ||retype.equals("") ||)
        {
            Toast.makeText(CreateAccount.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
        }
        else if(!password.equals(retype))
        {
        Toast.makeText(CreateAccount.this, "Please make sure your passwords match!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (connectionAvailable())
            {

            }
            else{}
        }

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



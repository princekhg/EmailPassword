package com.fantasmacodigo.prince.emailpassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    TextView email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        Bundle extra=getIntent().getExtras();
        if(extra==null)
        {
            return;
        }
        else
        {
            String mail=extra.getString("Mail");
            String pass=extra.getString("Pass");
            email.setText(mail);
            password.setText(pass);
        }
    }
}

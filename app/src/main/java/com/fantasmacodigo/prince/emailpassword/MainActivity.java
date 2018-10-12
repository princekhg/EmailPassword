package com.fantasmacodigo.prince.emailpassword;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextInputLayout email,password;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern=Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email_wrapper);
        password=findViewById(R.id.password_wrapper);
        AppCompatButton btn_click=findViewById(R.id.btn_A);

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=email.getEditText().getText().toString().trim();
                String pass=password.getEditText().getText().toString().trim();
                if(validate(mail,pass))
                {
                    Intent i=new Intent(MainActivity.this,FinalActivity.class);
                    i.putExtra("Mail",mail);
                    i.putExtra("Pass",pass);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Hold On Correct the fields ", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private boolean emailPatternMatch(String eMail)
    {
       matcher=pattern.matcher(eMail);
       return matcher.matches();
    }
    private boolean validatePassword(String pass)
    {
        return pass.length()>5;
    }

    // validate method
    private boolean validate(String eMail,String pass)
    {
        // nullify Error
        email.setError(null);
        password.setError(null);
    // Checking the format of Email and password
        if(TextUtils.isEmpty(eMail) && TextUtils.isEmpty(pass))
        {
            email.setError("Email Cannot Be Empty");
            password.setError("Password Cannot be empty");
            return false;
        }
         if(!emailPatternMatch(eMail))
        {
            email.setError("Not A valid Email");
            return false;
        }
         if(!validatePassword(pass) )
        {
            password.setError("Minimum of 6 character");
            return false;
        }
        return true;
    }
}

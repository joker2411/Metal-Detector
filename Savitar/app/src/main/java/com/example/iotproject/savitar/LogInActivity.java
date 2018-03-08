package com.example.iotproject.savitar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    EditText username,password;
    Button bLogin,bSignup;

    //Record r = new Record();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        username = (EditText)findViewById(R.id.uname);
        password = (EditText)findViewById(R.id.pass);

        bLogin = (Button)findViewById(R.id.blogin);
        bSignup = (Button)findViewById(R.id.bsignin);



        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name,pass;
                name = username.getText().toString();
                pass = password.getText().toString();

                if(username.length()<1)
                {
                    username.setError("Enter User Name");
                }
                if(password.length()<1)
                {
                    password.setError("Enter Password");
                }
                else
                {
                    if(name.equals("sunil")&&pass.equals("1234"))
                    {
                        Intent i = new Intent(LogInActivity.this,MainActivity.class);
                        startActivity(i);
                        Toast.makeText(getApplicationContext(),"Log In Sucessfull ",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Wrong Credentials ",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        bSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LogInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}

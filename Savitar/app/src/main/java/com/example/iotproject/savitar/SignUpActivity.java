package com.example.iotproject.savitar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText et1,et2,et3;
    Button btn;

    Record r = new Record();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et1 = (EditText)findViewById(R.id.uname);
        et2 = (EditText)findViewById(R.id.pass);
        et3 = (EditText)findViewById(R.id.cpass);

        btn = (Button)findViewById(R.id.breg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String one,two,three;
                one = et1.getText().toString();
                two =et2.getText().toString();
                three =et3.getText().toString();
                if(et1.length()<1)
                {
                    et1.setError("Enter User Name");
                }
                if(et2.length()<1)
                {
                    et2.setError("Enter Password");
                }
                else
                {
                    if(!two.equals(three))
                    {
                        Toast.makeText(getApplicationContext(),"Password Don't Match",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        r.setValue(one,two);
                        Toast.makeText(getApplicationContext(),"Successfully Registered!",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}
